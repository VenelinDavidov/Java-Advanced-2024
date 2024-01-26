package Exercises_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> function = numbers -> {
            int min = Integer.MAX_VALUE;
            for (int number : numbers) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        };
        int min = function.apply(numArr);
        System.out.println(min);
    }
}