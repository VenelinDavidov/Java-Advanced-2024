package Exercise_MultidimensionalArrays;

import java.util.Scanner;

public class Matrix_OfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        writeMatrix(rows, cols, matrix);

        printMatrix(rows, cols, matrix);

    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void writeMatrix(int rows, int cols, String[][] matrix) {
        char startLetter = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //(a -> b -> c)(startLetter + 1)()
                String palindrome = "" + startLetter + (char) (startLetter + col) + startLetter;
                matrix[row][col] = palindrome;
            }
            startLetter = (char) (startLetter + 1);
        }
    }
}
