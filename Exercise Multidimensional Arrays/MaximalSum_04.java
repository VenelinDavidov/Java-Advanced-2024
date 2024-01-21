package Exercise_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray(); //[4, 5]

        int rows = dimensions[0]; //брой редове
        int cols = dimensions[1]; //брой колони

        int [][] matrix = new int[rows][cols];

        //1. въвеждаме матрицата
        fillMatrix(matrix, scanner);

        //2. намираме матрицата
        int maxSum = Integer.MIN_VALUE; //най-голямата сума
        int bestStartingRow = 0; //от кой ред започва най-добрата матрица
        int bestStartingColumn = 0; //от коя колона започва най-добрата матрица

        for (int row = 0; row < rows - 2; row++) {

            for (int col = 0; col < cols - 2; col++) {
                int startElement = matrix[row][col]; //елемент, който може да образув матрица 3 х 3
                int sum = startElement + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 2][col] + matrix[row + 1][col + 1]
                        + matrix[row + 2][col + 2] + matrix[row + 2][col + 1] + matrix[row + 1][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestStartingRow = row;
                    bestStartingColumn = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int row = bestStartingRow; row <= bestStartingRow + 2 ; row++) {
            for (int col = bestStartingColumn; col <= bestStartingColumn + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}



