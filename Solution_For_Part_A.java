class Solution_For_Part_A {

    // Part-A (1st question)
    static int get_the_total_combinations_possible(int[] Dice_A, int[] Dice_B) {
        return Dice_A.length * Dice_B.length;
    }

    // Part-A (2nd question)
    static int[][] finding_the_distribution_of_all_possble_combinations(int[] Dice_A, int[] Dice_B, int[][] distribution) {

        System.out.println("All Possible distribution combinations");
        for(int i=1 ; i<=Dice_A.length ; i++) {
            for(int j=1 ; j<=Dice_B.length ; j++) {
                System.out.print("(" + i + "," + j + ")" + " ");
                distribution[i][j] = i + j;
            }
            System.out.println();
        }

        System.out.println();

        return distribution;
    }


    // Part-A (3rd question)
    static void print_all_probabilities(int[][] distribution) {
        int[] total_occrances_of_a_sum = new int[13];

        for(int i=1 ; i<distribution.length ; i++) {
            for(int j=1 ; j<distribution[i].length ; j++) {
                total_occrances_of_a_sum[distribution[i][j]]++;
            }
        }

        for(int i=2 ; i<13 ; i++) {
            System.out.printf("Probability of (sum=%d) = %.2f", i,  (double) total_occrances_of_a_sum[i] / 36 * 100);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] Dice_A = new int[]{1, 2, 3, 4, 5, 6};
        int[] Dice_B = new int[]{1, 2, 3, 4, 5, 6};

        // Finding the total no.of combinations possible
        int combinations = get_the_total_combinations_possible(Dice_A, Dice_B);
        System.out.println("Total number of combinations possible for two dices is: " + combinations);
        System.out.println();


        // Finding the distribution of all possible combinations
        int[][] distribution = new int[7][7];
        distribution = finding_the_distribution_of_all_possble_combinations(Dice_A, Dice_B, distribution);
        // Printing the sum
        System.out.println("All possible distribution combinations sum");
        for (int i = 1; i < distribution.length; i++) {
            for (int j = 1; j < distribution[i].length; j++) {
                System.out.print(distribution[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


        // Probability of all possible sums occuring from the above distributions
        print_all_probabilities(distribution);
    }
}