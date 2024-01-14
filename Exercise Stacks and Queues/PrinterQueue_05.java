package Stacks_And_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        // LIFO => ArrayDeque (pop () , push () , peek () )
        // FIFO => ArrayDeque (poll () , offer () , peek () )

        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = "";

        while (!"print".equalsIgnoreCase(input = scanner.nextLine())){

            if (!"cancel".equalsIgnoreCase(input)){
                queue.offer(input);
            }else {
                if (!queue.isEmpty()){
                    System.out.println("Canceled "+queue.poll());
                }else {
                    System.out.println("Printer is on standby");
                }
            }
        }
        queue.forEach(System.out::println);
    }
}


