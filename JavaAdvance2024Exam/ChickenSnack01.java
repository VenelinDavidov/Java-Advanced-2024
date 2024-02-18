package ExamPre;

import java.util.*;
import java.util.stream.Collectors;

public class ChickenSnack01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> moneyStack = new ArrayDeque<>();   //Stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(moneyStack::push);

        ArrayDeque<Integer> pricesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));


        // Read the sequence of money and prices
        // String[] moneyStr = scanner.nextLine().split(" "); //TODO: stack
        // String[] pricesStr = scanner.nextLine().split(" "); //TODO: queue

        // Create stack for money and queue for prices
        // Stack<Integer> moneyStack = new Stack<>();
        //Queue<Integer> pricesQueue =  new ArrayDeque<>();

        // Fill stack with money
        //for (String s : moneyStr) {
        //    moneyStack.push(Integer.parseInt(s));
        // }

        // Fill queue with prices
        // for (String s : pricesStr) {
        //     pricesQueue.offer(Integer.parseInt(s));
        // }

        int foodCount = 0;

        // Compare money with prices
        while (!moneyStack.isEmpty() && !pricesQueue.isEmpty()) {
            int money = moneyStack.pop();
            int price = pricesQueue.poll();

            if (money == price) {
                // Henry buys the food
                foodCount++;
            } else if (money > price) {
                // Henry buys the food and gets change
                int change = money - price;
                if (!moneyStack.isEmpty()) {
                    int nextMoney = moneyStack.pop() + change;
                    moneyStack.push(nextMoney);
                }
                foodCount++;
            }
            // If the amount of money is lower than the price, do nothing

            // Check if Henry has eaten enough food
            if (foodCount >= 4) {
                System.out.println("Gluttony of the day! Henry ate " + foodCount + " foods.");
                return;
            }
        }

        // Print the result based on the number of foods Henry ate
        if (foodCount > 0) {
            if (foodCount == 1) {
                System.out.println("Henry ate: 1 food.");
            } else {
                System.out.println("Henry ate: " + foodCount + " foods.");
            }
        } else {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }
}