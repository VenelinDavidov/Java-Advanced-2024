package Exercise_MultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine()); //бр. редове = бр. колони
        int [][] matrix = new int[n][n];

        //1. напълваме матрицата
        fillMatrix(matrix, scanner);

        //2. сума от числата на главния диагонал
        int sumPrimaryDiagonal = getSumElementsOnPrimaryDiagonal(matrix);

        //3. сума от числата на второстепенния диагонал
        int sumSecondaryDiagonal = getSumElementsOnSecondaryDiagonal(matrix);

        //4. принтираме абс.стойност на разликата
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));
    }

    private static int getSumElementsOnSecondaryDiagonal(int[][] matrix) {
        int sum = 0; //сума от числата на второстепенния диагонал
        //всички елементи в матрицата -> сумирам само тези, които са на второстепенния дигонал

        // (колона = общ брой редове - ред - 1)
        // ред + колона = общ брой редове - 1
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col]; //текущия елемент
                //проверяваме дали е на второстепенния диагонал
                if (col == matrix.length - row - 1) {
                    //елементът е на второстепенния диагонал
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static int getSumElementsOnPrimaryDiagonal(int[][] matrix) {
        int sum = 0; //сума от числата на главния диагонал
        //всички елементи в матрицата -> сумирам само тези, които са на главния дигонал (ред == колона)
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                int currentElement = matrix[row][col]; //текущия елемент
                //проверяваме дали е на главния диагонал
                if (row == col) {
                    //елементът е на главния диагонал
                    sum += currentElement;
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        int rows = matrix.length; //брой на редовете = брой на колони
        for (int row = 0; row < rows; row++) { //обхожда редовете
            for (int col = 0; col < rows; col++) { //обхожда колоните
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}