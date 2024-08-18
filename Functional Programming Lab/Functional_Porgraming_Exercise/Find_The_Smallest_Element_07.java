package TrainerDemo.Functional_Porgraming_Exercise;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Find_The_Smallest_Element_07 {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Function: аргумент -> извършва се действие с този аргумент и връща резултат
        Function<List<Integer>, Integer> function = listOfNumbers -> Collections.min(listOfNumbers);
        Integer minValue = function.apply(numbers);

        // 5 6 7 1 8 5 1 3
        //System.out.println(numbers.indexOf(minValue)); // получавам първата повява за този елемент
        System.out.println(numbers.lastIndexOf(minValue)); // получавам последната повява за този елемент


    }
}
