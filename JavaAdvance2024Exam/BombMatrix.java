import java.sql.SQLOutput;
import java.util.Scanner;

public class BombMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        int size = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(",");

        char[][] bombMatrix = new char[size][size];

        int startRow = 0;
        int startColl = 0;
        int countBomb = 0;


        for (int row = 0; row < size; row++) {
            String inputCommand = scanner.nextLine();
            char[] input = inputCommand.replaceAll("\\s+", "").toCharArray();
            bombMatrix[row] = input;

            // if (inputCommand.contains("s")) {
            // startRow = row;
            // startColl = inputCommand.indexOf("s");
            // }

            for (int r = 0; r < size; r++) {
                for (int c = 0; c < size; c++) {
                    if (bombMatrix[r][c] == 's') {
                        startRow = r;
                        startColl = c;
                        break;
                    }
                }
            }

            for (char ch : inputCommand.toCharArray()) {
                if (ch == 'B') {
                    countBomb++;
                }
            }
        }

        for (int i = 0; i < command.length; i++) {
            String commandName = command[i];

            int nextRow = startRow;
            int nextColl = startColl;

            switch (commandName) {
                case "up":
                    if (nextRow != 0) {
                        bombMatrix[startRow][startColl]= '+';
                        nextRow--;
                    }
                    break;
                case "down":
                    if (nextRow != bombMatrix.length - 1) {
                        bombMatrix[startRow][startColl]= '+';
                        nextRow++;
                    }
                    break;
                case "right":
                    if (nextColl != bombMatrix.length - 1) {
                        bombMatrix[startRow][startColl]= '+';
                        nextColl++;
                    }
                    break;
                case "left":
                    if (nextColl != 0) {
                        bombMatrix[startRow][startColl]= '+';
                        nextColl--;
                    }
                    break;
            }


            if (bombMatrix[nextRow][nextColl] == 'B') {
                countBomb--;
                System.out.print("You found a bomb!");
                System.out.println();
                bombMatrix[nextRow][nextColl] = '+';
            }else if (bombMatrix[nextRow][nextColl] == 'e') {
                System.out.printf("END! %d bombs left on the field", countBomb);
                return;
            } else if (bombMatrix[nextRow][nextColl] == '+'){
                bombMatrix[nextRow][nextColl] = 's';
            }

            startRow = nextRow;
            startColl = nextColl;


        }
        if (countBomb == 0) {
            System.out.println("Congratulations! You found all bombs!");
            // return
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", countBomb, startRow, startColl);
        //print(bombMatrix);
    }

    private static void print(char[][] bombMatrix) {
        for (int row = 0; row < bombMatrix.length; row++) {
            for (int col = 0; col < bombMatrix.length; col++) {
                System.out.print(bombMatrix[row][col]);
            }
            System.out.println();
        }
    }

}



