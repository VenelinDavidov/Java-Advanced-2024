package Exercises_Streams_Files_And_Directories;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //5,5
        int[] input = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        // create a matrix
        char[][] matrix = new char[input[0]][input[1]];

        fillTheMatrix(matrix, scanner);

        int mouseRow = -1; //ред на мишката
        int mouseCol = -1; //колона на мишката

        // Намирам стартовата позиция на моето мишле
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        int cheeseCount = getCheeseCount(matrix);

        String command = scanner.nextLine();

        while (!command.equals("danger")) {
            //direction -> "up", "down", "left", "right"

            int newRow = mouseRow;
            int newCol = mouseCol;

            switch (command) {
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
            }

            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[newRow].length) {
                System.out.println("No more cheese for tonight!");
                printMatrix(matrix);
                return;
            }

            char symbol = matrix[newRow][newCol];
            if (symbol != '@') {
                // 1. Премествам мишлето на новата клетка
                matrix[newRow][newCol] = 'M';
                // 2. Занулявам старата позиция на мишлето (*)
                matrix[mouseRow][mouseCol] = '*';
                // 3. Обновявам кординатите (ред и колона) на моето мишле
                mouseRow = newRow;
                mouseCol = newCol;
            }

            switch (symbol) {
                case 'C':
                    cheeseCount--;
                    if (cheeseCount == 0) {
                        System.out.println("Happy mouse! All the cheese is eaten, good night!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case 'T':
                    System.out.println("Mouse is trapped!");
                    printMatrix(matrix);
                    return;
            }

            command = scanner.nextLine();
        }

        System.out.println("Mouse will come back later!");
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int getCheeseCount(char[][] matrix) {
        int countCheese = 0; // брой сиренца
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'C') {
                    countCheese++;
                }
            }
        }

        return countCheese;
    }

    private static void fillTheMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String rowContent = scanner.nextLine();
            char[] rowSymbol = rowContent.toCharArray();
            matrix[row] = rowSymbol;
        }
    }
}
