package TrainerDemo.Functional_Porgraming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Applied_Arithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Function<List<Integer>, List<Integer>> addFunction = listOfNumber -> listOfNumber.stream()
                .map(number -> number + 1).toList();
        Function<List<Integer>, List<Integer>> multiplyFunction = listOfNumber -> listOfNumber.stream()
                .map(number -> number * 2).toList();
        Function<List<Integer>, List<Integer>> subtractFunction = listOfNumber -> listOfNumber.stream()
                .map(number -> number - 1).toList();

        String command = scanner.next();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = addFunction.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunction.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunction.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(number -> System.out.print(number + " "));
                    System.out.println();
                    break;
            }
            command = scanner.next();
        }

    }
}
