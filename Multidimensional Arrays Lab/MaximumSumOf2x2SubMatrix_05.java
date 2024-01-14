package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: ЦЯЛОСТНО ЧЕТЕНЕ НА МАСИВ В МАСИВИ
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)    //Input
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] maxMatrix = new int[2][2];

        int maxSum = Integer.MIN_VALUE;
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int currentElement = matrix[r][c];
                int right = matrix[r][c + 1];
                int below = matrix[r + 1][c];
                int rightBelow = matrix[r + 1][c + 1];

                int sum = currentElement + rightBelow + right + below;
                if (maxSum < sum) {
                    maxSum = sum;
                    maxMatrix[0][0] = currentElement;
                    maxMatrix[0][1] = right;
                    maxMatrix[1][0] = below;
                    maxMatrix[1][1] = rightBelow;

                }
            }
        }
        System.out.println(maxMatrix[0][0] + " " + maxMatrix[0][1]);
        System.out.println(maxMatrix[1][0] + " " + maxMatrix[1][1]);
        System.out.println(maxSum);
    }
}
