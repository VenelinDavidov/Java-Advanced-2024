import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] pastryShop = new char[n][n];

        int row = -1;
        int col = -1;
        int money = 0;

        for (int rows = 0; rows < n; rows++) {
            String line = scanner.nextLine();
            pastryShop[rows] = line.toCharArray();

            if (line.contains("S")) {
                row = rows;
                col = line.indexOf("S");
            }
        }

        while (money < 50) {
            String command = scanner.nextLine();
            pastryShop[row][col] = '-';

            int newRow = row;
            int newCol = col;

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

            if (!isValidPosition(newRow, newCol, n)) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            char newPosition = pastryShop[newRow][newCol];

            if (Character.isDigit(newPosition)) {
                money += Character.getNumericValue(newPosition);
                pastryShop[newRow][newCol] = '-';
            } else if (newPosition == 'P') {
                pastryShop[newRow][newCol] = '-';
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (pastryShop[r][c] == 'P' && (r != newRow || c != newCol)) {
                            newRow = r;
                            newCol = c;
                            pastryShop[r][c] = '-';
                        }
                    }
                }
            }

            row = newRow;
            col = newCol;
            pastryShop[row][col] = 'S';
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + money);
        printPastryShop(pastryShop);
    }

    private static boolean isValidPosition(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    private static void printPastryShop(char[][] pastryShop) {
        for (char[] row : pastryShop) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
