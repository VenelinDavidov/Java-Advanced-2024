package Exercises_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();

        Deque<StringBuilder> textResult = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();     // 1 abc
            String[] cmd = input.split("\\s+");    // {'1' 'abc'}
            if (cmd[0].equals("1")) {
                result.append(cmd[1]);
                textResult.push(new StringBuilder(result));
            } else if (cmd[0].equals("2")) {
                result = new StringBuilder(result.substring(0, result.length() - Integer.parseInt(cmd[1])));
                textResult.push(new StringBuilder(result));
            } else if (cmd[0].equals("3")) {
                char print = result.charAt(Integer.parseInt(cmd[1]) - 1);
                System.out.println(print);
            } else if (cmd[0].equals("4")) {
                if (textResult.size() > 1) {
                    textResult.pop();
                    result = textResult.peek();
                } else if (textResult.size() == 1) {
                    result = new StringBuilder();
                }
            }
        }
    }
}
