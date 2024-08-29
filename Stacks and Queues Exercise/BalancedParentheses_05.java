package Exercises_StacksAndQueues;

import java.util.*;
import java.util.stream.Collectors;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        String result = isBalance(input) ? "YES" : "NO";
        System.out.println(result);
    }

    private static boolean isBalance(List<String> input) {
        Deque<String> openParenthesesStack = new ArrayDeque<>();

        for (String brace : input) {
            switch (brace) {
                case "}":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    String openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("{")) {
                        return false;
                    }
                    break;
                case "]":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("[")) {
                        return false;
                    }
                    break;
                case ")":
                    if (openParenthesesStack.isEmpty()) {
                        return false;
                    }
                    openBrace = openParenthesesStack.pop();
                    if (!openBrace.equals("(")) {
                        return false;
                    }
                    break;
                default:
                    openParenthesesStack.push(brace);
                    break;
            }
        }
        return openParenthesesStack.isEmpty();



    }
}
