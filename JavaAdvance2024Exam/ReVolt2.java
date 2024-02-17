package ExamPrepare;

import java.util.Scanner;

public class ReVolt2 {
    public static int playerRow;
    public static int playerColl;
    public static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine()); //commands

        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String matrixRow = scanner.nextLine();
            matrix[row] = matrixRow.toCharArray();

            if (matrixRow.contains("f")) {
                playerRow = row;
                playerColl = matrixRow.indexOf("f");
            }
        }
        while (commandsCount-- > 0 && !hasWon) {
            String command = scanner.nextLine();

            if (command.equals("up")) {
                movePlayer(matrix, -1, 0);
            } else if (command.equals("down")) {
                movePlayer(matrix, 1, 0);
            } else if (command.equals("right")) {
                movePlayer(matrix, 0, 1);
            } else if (command.equals("left")) {
                movePlayer(matrix, 0, -1);
            }
        }


        System.out.println(hasWon ? "Player won!" : "Player lost!");

        printMatrix(matrix);
    }

    private static void movePlayer(char[][] matrix, int rowMutation, int collMutation) {
        int nextRow = playerRow + rowMutation;
        int nextColl = playerColl + collMutation;

        if (isOutOfBounds(matrix, nextRow, nextColl)) {
            // nextRow < 0 || nextRow >= size
            if (nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else {
                nextColl = nextColl < 0 ? matrix[nextRow].length - 1 : 0;
            }
            //nextColl < 0 || nextColl >= size;
        }
        // Рефреш на индексите и проверява,какво има на тях;

        if (matrix[nextRow][nextColl] == 'T') {
            return;
        } else if (matrix[nextRow][nextColl] == 'B') {
            matrix[playerRow][playerColl] = '-';
            playerRow = nextRow;
            playerColl = nextColl;
            movePlayer(matrix, rowMutation, collMutation);
        } else if (matrix[nextRow][nextColl] == 'F') {
            hasWon = true;
        }


        if (matrix[playerRow][playerColl] != 'B') {
            matrix[playerRow][playerColl] = '-';
        }
        matrix[nextRow][nextColl] = 'f';
        playerRow = nextRow;
        playerColl = nextColl;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}