import java.util.Scanner;

public class SellingMatrix02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrixBakery = new char[size][size];

        int bakeryRow = -1;
        int bakeryColl = -1;
        int money = 0;

        for (int row = 0; row < size; row++) {
            String input = scanner.nextLine();
            matrixBakery[row] = input.toCharArray();
            if (input.contains("S")) {
                bakeryRow = row;
                bakeryColl = input.indexOf("S");
            }
        }


        while (money < 50) {
            String command = scanner.nextLine();

            matrixBakery[bakeryRow][bakeryColl] = '-';
            int newRow = bakeryRow;
            int newColl = bakeryColl;

            switch (command) {
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "right":
                    newColl++;
                    break;
                case "left":
                    newColl--;
                    break;
            }
            if (!isValidMove(size, newRow, newColl)) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            char newPosition = matrixBakery[newRow][newColl];

            if (Character.isDigit(newPosition)) {
                money += Character.getNumericValue(newPosition);
                matrixBakery[newRow][newColl] = '-';

            } else if (newPosition == 'O') {
                matrixBakery[newRow][newColl] = '-';
                for (int r = 0; r < size; r++) {
                    for (int c = 0; c < size; c++) {
                        if (matrixBakery[r][c] == 'O' && (r != newRow && c != newColl)) {
                            newRow = r;
                            newColl = c;
                            matrixBakery[newColl][newColl] = '-';
                        }
                    }
                }
            }

            bakeryRow = newRow;
            bakeryColl = newColl;
            matrixBakery[bakeryRow][bakeryColl] = 'S';
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);

        for (int row = 0; row < matrixBakery.length; row++) {
            for (int coll = 0; coll < matrixBakery[row].length; coll++) {
                System.out.print(matrixBakery[row][coll]);
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int size, int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
