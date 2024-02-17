import java.util.Scanner;

public class MoveMouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //бр. редове = бр. колони
        char [][] matrix = new char[n][n];
        int mouseRow = -1; //ред на мишката
        int mouseCol = -1; //колона на мишката
        int countCheese = 0; //брой изядени сиренца

        //пълним матрицата
        fillMatrix(scanner, n, matrix);

        //намираме мишката
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col];
                if (currentSymbol == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String direction = scanner.nextLine();
        while (!direction.equals("end")) {
            //direction -> "up", "down", "left", "right"
            matrix[mouseRow][mouseCol] = '-';
            switch(direction) {
                case "up":
                    //намаляме ред с 1
                    mouseRow--;
                    break;
                case "down":
                    //увеличаваме ред с 1
                    mouseRow++;
                    break;
                case "left":
                    //намаляме колоната с 1
                    mouseCol--;
                    break;
                case "right":
                    //увеличаваме колоната с 1
                    mouseCol++;
                    break;
            }
            //преди да поставим мишката на новото и място -> проверка на ред и колоната
            if (mouseCol < 0 || mouseCol >= n || mouseRow < 0 || mouseRow >= n) {
                System.out.println("Where is the mouse?");
                break;
            }

            //проверим мястото, на което ще отиде мишката
            if (matrix[mouseRow][mouseCol] == 'c') {
                //сирене
                countCheese++;
            } else if (matrix[mouseRow][mouseCol] == 'B') {
                //бонус
                continue;
            }
            //поставяне на новото място на мишката
            matrix[mouseRow][mouseCol] = 'M';

            direction = scanner.nextLine();
        }

        //проверка дали е изяла достатъчно сиренца
        if (countCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!", countCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - countCheese);
        }

        //принтиране на матрицата
        printMatrix(n, matrix);
    }

    private static void printMatrix(int n, char[][] matrix) {
        System.out.println();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int n, char[][] matrix) {
        for (int row = 0; row < n; row++) {
            String rowContent = scanner.nextLine(); // "M--"
            char [] rowSymbols = rowContent.toCharArray(); // ['M', '-', '-']
            matrix[row] = rowSymbols;
        }
    }
}

