import java.util.Arrays;

public class DoomedDice {

    public static void main(String[] args) {
        int totalCombinations = 6 * 6;

        int[][] combinationsDistribution = new int[6][6];
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                combinationsDistribution[i][j] = i + j + 2;

        double[] probabilityOfSums = new double[11];
        for (int[] row : combinationsDistribution)
            for (int value : row)
                probabilityOfSums[value - 2] += 1.0 / totalCombinations;

        int[] newDieA = Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6 }).map(x -> x > 4 ? x : 5 - x).toArray();
        int[] newDieB = Arrays.copyOf(newDieA, 6);

        System.out.println("Part-A: Total Combinations: " + totalCombinations);
        System.out.println("\nPart-A: Combinations Distribution:");
        Arrays.stream(combinationsDistribution).map(Arrays::toString).forEach(System.out::println);
        System.out.println("\nPart-A: Probability of Sums:");
        for (int i = 0; i < probabilityOfSums.length; i++)
            System.out.println("P(Sum = " + (i + 2) + ") = " + probabilityOfSums[i]);

        System.out.println("\nPart-B: New Die A:");
        System.out.println(Arrays.toString(newDieA));
        System.out.println("\nPart-B: New Die B:");
        System.out.println(Arrays.toString(newDieB));
    }
}
