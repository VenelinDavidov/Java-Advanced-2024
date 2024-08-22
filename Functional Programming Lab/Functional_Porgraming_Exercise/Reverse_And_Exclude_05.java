package TrainerDemo.Functional_Porgraming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Reverse_And_Exclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Списък с елементи, които мога да премахвам/добавям и т.н.
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());
        //1 2 3 4 5 6 -> "6 5 4 3 2 1"
        Collections.reverse(numbers);
        // Predicate: аргумент -> израз/действие, който връща булева стойност
        Predicate<Integer> predicate = number -> number % n == 0;

        numbers.removeIf(predicate);
        numbers.forEach(num -> System.out.print(num + " "));

    }
}
