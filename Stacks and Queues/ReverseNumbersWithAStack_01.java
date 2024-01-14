package Exercises_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Deque<Integer> stack = new ArrayDeque<>();

        //Arrays.stream(scanner.nextLine().split("\\s+"))
        //        .map(Integer::parseInt)
        //       .forEach(stack::push);

        for (String el : input) {
            int number = Integer.parseInt(el);
            stack.push(number);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
