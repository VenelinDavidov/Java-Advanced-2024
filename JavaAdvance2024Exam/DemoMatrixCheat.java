import java.util.Scanner;

public class DemoMatrixCheat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        int startRow = -1;
        int startColl = -1;

        for (int row = 0; row < n; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 'P') {
                    startRow = row;
                    startColl = col;
                }
            }
        }
        //Fill matrix
        // for (int row = 0; row < n; row++) {
        // String rowContent = scanner.nextLine(); // "M--"
        // char [] rowSymbols = rowContent.toCharArray(); // ['M', '-', '-']
        // matrix[row] = rowSymbols;
        //        }
        //    }

        //       for (int row = 0; row < n; row++) {
        //       String line = scanner.nextLine();
        //        matrix [row] = line.toCharArray();
        //
        //        if (line.contains("M")) {
        //            mouseRow = row;
        //            mouseColl = line.indexOf("M");
        //            }
        //        }


        fillMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c: chars) {
                System.out.print(c +" ");
            }
            System.out.println();
        }
    }
}
