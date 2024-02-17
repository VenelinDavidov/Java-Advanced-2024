import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        // Read the size of the airspace
        int n = Integer.parseInt(scanner.nextLine());

        // Read the airspace matrix
        char[][] airspace = new char[n][n];
        int startRow = -1, startColl = -1;

        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            airspace[i] = row.toCharArray();

            // Find the starting position of the jetfighter
            if (row.contains("J")) {
                startRow = i;
                startColl = row.indexOf("J");
            }
        }

        // Number of enemy planes
        int enemyPlanes = 4;

        // Armor of the jetfighter
        int armor = 300;
        boolean missionFailed = false;

        // Directions: up, down, left, right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Start battle
        while (enemyPlanes > 0 && armor > 0) {
            String command = scanner.nextLine();

            // Calculate new position based on the command
            int dir;
            switch (command) {
                case "up":
                    dir = 0;
                    break;
                case "down":
                    dir = 1;
                    break;
                case "left":
                    dir = 2;
                    break;
                case "right":
                    dir = 3;
                    break;
                default:
                    continue; // Invalid command, ignore
            }

            int newRow = startRow + dx[dir];
            int newCol = startColl + dy[dir];

            // Check if the new position is within the airspace
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n)
                continue;

            // Handle encounters
            char newPosition = airspace[newRow][newCol];
            if (newPosition == 'E') {
                armor -= 100;
                if (armor <= 0) {
                    missionFailed = true;
                    break;
                }
                enemyPlanes--;
                airspace[newRow][newCol] = 'J';
                airspace[startRow][startColl]='-';

            } else if (newPosition == 'R') {
                armor = 300; // Repair
                airspace[newRow][newCol] = 'J';
                airspace[startRow][startColl]='-';


            } else if (newPosition == '-') {

                airspace[startRow][startColl] = '-';
                airspace[newRow][newCol] = 'J';

            }

            startRow = newRow;
            startColl = newCol;

        }



        // Print result
        if (missionFailed) {
            System.out.println("Mission failed, your jetfighter was shot down! Last coordinates [" + startRow + ", " + startColl + "]!");
        } else {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        }

        // Print final state of the airspace
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(airspace[i][j] + " ");
            }
            System.out.println();
        }
    }
}



