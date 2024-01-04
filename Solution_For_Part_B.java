import java.util.ArrayList;
import java.util.List;

public class Solution_For_Part_B {

    public static void Combinations_of_dice_A(List<Integer> arr, int length, List<Integer> present, List<List<Integer>> allCombinations) {
        if (present.size() == length) {
            allCombinations.add(new ArrayList<>(present));
            return;
        }
        for (int element : arr) {
            present.add(element);
            Combinations_of_dice_A(arr, length, present, allCombinations);
            present.remove(present.size() - 1);
        }
    }

    public static void Combinations_of_dice_B(List<Integer> arr, int length, int start, List<Integer> present, List<List<Integer>> allCombinations) {
        if (present.size() == length) {
            allCombinations.add(new ArrayList<>(present));
            return;
        }
        for (int i = start; i < arr.size(); i++) {
            present.add(arr.get(i));
            Combinations_of_dice_B(arr, length, i + 1, present, allCombinations);
            present.remove(present.size() - 1);
        }
    }

    public static List<Double> Calculate_Probability_Sum(List<Integer> arr_A, List<Integer> arr_B) {
        List<Double> Probability_Sum = new ArrayList<>(List.of(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
        for (int i : arr_A) {
            for (int j : arr_B) {
                int k = i + j;
                Probability_Sum.set(k - 1, Probability_Sum.get(k - 1) + 1);
            }
        }
        for (int i = 0; i < Probability_Sum.size(); i++) {
            if (Probability_Sum.get(i) != 0) {
                Probability_Sum.set(i, Probability_Sum.get(i) / 36);
            }
        }
        return Probability_Sum;
    }

    static void doomed_dice(int[] Dice_A, int[] Dice_B, List<Double> Probability_Sums) {

        // generating the Dice_A combinations
        List<Integer> arr_A = List.of(1, 2, 3, 4);
        List<Integer> present = new ArrayList<>();
        List<List<Integer>> combination_A = new ArrayList<>();
        Combinations_of_dice_A(arr_A, 6, present, combination_A);

        // generating the Dice_B combinations
        List<Integer> arr_B = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        List<List<Integer>> combination_B = new ArrayList<>();
        Combinations_of_dice_B(arr_B, 6, 0, present, combination_B);


        // maintaining the flag so that if we encounter the lists 
        // with probabilities equal to the older probabilities 
        // so that we will get out of the loops.
        boolean flag = false;

        for (List<Integer> list_A : combination_A) {
            for (List<Integer> list_B : combination_B) {
                if (Calculate_Probability_Sum(list_A, list_B).equals(Probability_Sums)) {
                    System.out.print("New_Dice_A = [");
                    for (int x : list_A) {
                        System.out.print(x + ",");
                    }
                    System.out.println("]");
                    System.out.print("New_Dice_B = [");
                    for (int x : list_B) {
                        System.out.print(x + ",");
                    }
                    System.out.println("]");
                    flag = true;
                    break;
                }
            }
            
            if (flag) break;
        }
    }
    public static void main(String[] args) {
        
        // Initial dices are as follows
        int[] Dice_A = new int[]{1, 2, 3, 4, 5, 6};
        int[] Dice_B = new int[]{1, 2, 3, 4, 5, 6};
        List<Double> Probability_Sums = List.of(0.0, 1.0 / 36, 2.0 / 36, 3.0 / 36, 4.0 / 36, 5.0 / 36, 6.0 / 36, 5.0 / 36, 4.0 / 36, 3.0 / 36, 2.0 / 36, 1.0 / 36);

        doomed_dice(Dice_A, Dice_B, Probability_Sums);
    }
}
