import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[n][n];

        int mouseRow = -1;
        int mouseColl = -1;

        int cheeseEaten = 0;

         //Fill matrix
        // for (int row = 0; row < n; row++) {
        //  String rowContent = scanner.nextLine(); // "M--"
        // char [] rowSymbols = rowContent.toCharArray(); // ['M', '-', '-']
        // matrix[row] = rowSymbols;
        //        }
        //    }

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine();
            territory[row] = line.toCharArray();

            if (line.contains("M")) {
                mouseRow = row;
                mouseColl = line.indexOf("M");
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            territory[mouseRow][mouseColl] = '-';
            switch (command) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseColl--;
                    break;
                case "right":
                    mouseColl++;
                    break;
            }

            if (mouseRow < 0 || mouseRow >= territory.length || mouseColl < 0 || mouseColl >= territory[mouseRow].length) {
                System.out.println("Where is the mouse?");
                break;
            }

            char newPosition = territory[mouseRow][mouseColl];

            if (newPosition == 'c') {
                cheeseEaten++;
                territory[mouseRow][mouseColl] = '-';
            }
            if (newPosition == 'B') {  // next one step
                continue;
            }

            territory[mouseRow][mouseColl] = 'M';

            command = scanner.nextLine();

        }
        if (cheeseEaten >= 5) {
            System.out.printf("Great job, the mouse is fed %d%n cheeses!", cheeseEaten);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d%n cheeses more.", 5 - cheeseEaten);
        }

        System.out.println();

        for (int row = 0; row < territory.length; row++) {
            for (int coll = 0; coll < territory[row].length ; coll++) {
                System.out.print(territory[row][coll]);
            }
            System.out.println();
        }
    }
}


