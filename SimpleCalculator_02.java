package Stacks_And_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         String expression = scanner.nextLine();
          String[] tokens = expression.split("\\s+");
        ArrayDeque <String> stack = new ArrayDeque<>();

        for (int i = tokens.length-1; i >= 0; i--) {
            String token = tokens[i];
            stack.push(token);
        }
        while (stack.size() > 1){
            int firstElement = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int secondElement = Integer.parseInt(stack.pop());

            switch (op){
                case "+":
                    stack.push(String.valueOf(firstElement+secondElement));
                break;
                case "-":
                    stack.push(String.valueOf(firstElement-secondElement));
                    break;
            }
        }
        System.out.println(stack.pop());
    }
}
