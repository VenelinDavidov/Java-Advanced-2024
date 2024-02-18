package ExamPre;

import java.util.Scanner;

public class ClearSkies02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        fillMatrix(matrix, scanner);

        int[] startPosition = findStartPointPosition(matrix);
        int row = startPosition[0];
        int col = startPosition[1];

        int armoury = 300;
        int enemy = 4;
        boolean missionAcomplish = false;

        String command = scanner.nextLine();
        matrix[row][col] = '-';

        while (true) {

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }

            if (matrix[row][col] == 'E') {
                if (armoury > 100) {
                    matrix[row][col] = '-';
                    armoury -= 100;
                    enemy -= 1;
                    if (enemy == 0) {
                        missionAcomplish = true;
                        break;
                    }
                } else {
                    if (enemy == 1) {
                        matrix[row][col] = '-';
                        missionAcomplish = true;
                        break;
                    } else {
                        break;
                    }
                }
            } else if (matrix[row][col] == 'R') {
                matrix[row][col] = '-';
                if (armoury < 300) {
                    armoury = 300;
                }
            } else {
                matrix[row][col] = '-';
            }

            command = scanner.nextLine();
        }

        if (missionAcomplish) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        } else {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n", row, col);
        }

        matrix[row][col] = 'J';

        printMatrix(matrix);

    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static int[] findStartPointPosition(char[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char curent = matrix[row][col];
                if (curent == 'J') {
                    startRow = row;
                    startCol = col;
                }
            }
        }
        return new int[]{startRow, startCol};
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}


