package Exercises_StacksAndQueues;

import java.util.*;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = numbers[0];
        int s = numbers[1];
        int x = numbers[2];

        Deque<Integer> stack = new ArrayDeque<>();
        String[] numbersToAdd = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(numbersToAdd[i]));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(x)) {
            System.out.println(true);
        } else {
            //         int minElement = Integer.MAX_VALUE;       Вариант №1
            //         for (Integer number : stack) {
            //          if (number < minElement) {
            //          minElement = number;
            //       }
            // }
            int minElement = Collections.min(stack);
            System.out.println(minElement);
        }
    }
}
