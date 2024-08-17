package TrainerDemo.Functional_Porgraming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Knights_of_Honor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Peter George Alex Stan
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        // Consumer: аргумент -> извършва се действие без да се връща резултата
        Consumer<String> consumer = name -> System.out.println("Sir " + name);

        Function<String,  String> function = name -> "Sir " + name;

        names.stream()
                .map(function)
                .forEach(n-> System.out.println(n));

    }
}
