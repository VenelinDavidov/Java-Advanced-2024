package Exercises_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Deque<String> numbersQueue = new ArrayDeque<>(); //опашка
        Deque<String> operatorStack = new ArrayDeque<>(); // стек

        for (String s : input) {
            if (Character.isDigit(s.charAt(0)) || Character.isLetter(s.charAt(0))) {
                numbersQueue.offer(s);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(s);
                } else {
                    String lastOperator = operatorStack.peek();
                    switch (s) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                operatorStack.push(s);
                            } else {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(s);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(s);
                            } else {
                                operatorStack.push(s);
                            }
                            break;
                        case "(":
                            operatorStack.push(s);
                            break;
                        case ")":
                            while (!operatorStack.peek().equals("(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            //Removing the non-necessary open parenthesis '('
                            operatorStack.pop();
                            break;
                    }
                }
            }
        }

        while (!numbersQueue.isEmpty()) {
            System.out.print(numbersQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()) {
            System.out.print(operatorStack.pop() + " ");
        }
        System.out.println();
    }
}

