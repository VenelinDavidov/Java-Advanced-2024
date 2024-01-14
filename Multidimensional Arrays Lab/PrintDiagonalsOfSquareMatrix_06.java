package MultidimensionalArrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[matrix.length - 1 - i][i] + " ");
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        int size = Integer.parseInt(scanner.nextLine());


        int[][] matrix = new int[size][size];

        for (int r = 0; r < size; r++) {
            matrix[r] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)    //Input
                .toArray();
    }
}
