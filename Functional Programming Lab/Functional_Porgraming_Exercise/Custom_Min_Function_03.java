package TrainerDemo.Functional_Porgraming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Custom_Min_Function_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();
        // Function: аргумент -> извършва се действие с този аргумент и връща резултат
        Function<List<Integer>, Integer> function = listOfNumbers -> Collections.min(listOfNumbers);

        Integer minValue = function.apply(integers);
        System.out.println(minValue);
    }
}
