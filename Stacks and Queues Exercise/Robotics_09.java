package Exercises_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Robotics_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(";");// "ROB-15", "SS2-10", "NX8000-3"
       // Четем и сплитваме по ;
        // Създаваме празни масиви с дължината на input;
        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];
         // итерираме и пълним масива с данни от input;
        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-"); // "ROB-15"; -> "ROB"-"15";
            robots[i] = data[0];
            processTime[i] = Integer.parseInt(data[1]);
        }
        String[] startTime = scanner.nextLine().split(":"); //"8", "00", "00"
        Deque<String> products = new ArrayDeque<>();

        String inputProducts = "";
        while (!"End".equalsIgnoreCase(inputProducts = scanner.nextLine())) {
            products.offer(inputProducts);
        }
        int hours = Integer.parseInt(startTime[0]);
        int minutes = Integer.parseInt(startTime[1]);
        int seconds = Integer.parseInt(startTime[2]);

        int beginSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()) {

            beginSeconds++;
            String product = products.poll();
            boolean isAssigned = false;
            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isAssigned) {
                    workTime[i] = processTime[i];
                    isAssigned = true;
                    printRobodata(robots[i], product, beginSeconds);
                }
                if (workTime[i]>0){
                    workTime[i]--;
                }
            }
            if (!isAssigned){
                products.offer(product);
            }
        }
    }

    private static void printRobodata(String robot, String product, int beginSeconds) {
        long s = beginSeconds % 60;
        long m = (beginSeconds / 60) % 60;
        long h = (beginSeconds / 3600) % 24;
        System.out.println(String.format("%s - %s [%02d:%02d:%02d]",robot,product,h,m,s));
    }
}
