import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // jetfighter - J - изтребител;
        //'E' battle begins
        //

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        int startRow = -1;
        int startColl = -1;
        int armorPlane = 300;
        boolean missionFailed = false;

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("J")) {
                startRow = i;
                startColl = line.indexOf("J");
            }
        }

        int enemyPlanes = 4;


        while (enemyPlanes > 0 && armorPlane > 0) {
            String command = scanner.nextLine();

            int newRow = startRow;
            int newCol = startColl;

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

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                continue; // Ignore invalid moves
            }

            char newPosition = matrix[newRow][newCol];

            //armour loses 100 units. It can withstand two hits from enemy planes.
            if (newPosition == 'E') {
                armorPlane -= 100;
                if (armorPlane <= 0) {
                    matrix[newRow][newCol] = 'J';
                    matrix[startRow][startColl] = '-';
                    startRow = newRow;
                    startColl = newCol;
                    missionFailed = true;
                    break;
                }
                enemyPlanes--;
                matrix[newRow][newCol] = 'J';
                matrix[startRow][startColl] = '-';

                //'R' is reached your plane is repaired and restores 300
            } else if (newPosition == 'R') {
                armorPlane = 300; // Repair
                matrix[newRow][newCol] = 'J';
                matrix[startRow][startColl] = '-';


            } else if (newPosition == '-') {

                matrix[startRow][startColl] = '-';
                matrix[newRow][newCol] = 'J';

            }

            startRow = newRow;
            startColl = newCol;
        }


        if (missionFailed) {
            System.out.println("Mission failed, your jetfighter was shot down! Last coordinates [" + startRow + ", " + startColl + "]!");
        } else {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == startRow && j == startColl) {
                    System.out.print("J ");
                } else {
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}



