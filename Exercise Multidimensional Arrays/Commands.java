package Exercise_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Commands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = 4; //общ брой на редовете в матрицата
        int cols = 4; //общ брой на колони в матрицата

        //1. Какво е матрица?
        int[][] matrix = new int[rows][cols];

        // TODO:2. Как се чете матрица?
        //вариант 1 -> вложен for цикли
        for (int row = 0; row < rows; row++) { //обхожда редовете
            for (int col = 0; col < cols; col++) { //обхожда колоните
                matrix[row][col] = scanner.nextInt();
            }
        }
        //вариант 2 -> streamAPI
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        //вариант 3 -> for loop
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }

        //TODO:3. Как се отпечатва матрица?
        //вариант 1 -> foreach
        for (int[] row : matrix) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        //вариант 2 -> for loop
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        //TODO:4. Движения в матрица
        //нагоре -> ред - 1
        //надолу -> ред + 1
        //дясно -> колона + 1
        //ляво-> колона - 1


        //TODO:5. Валидиране на индекси
        //колона -> колона >= 0 и колона < брой колони
        //ред -> ред >= 0 и ред < брой редове
    }
}



