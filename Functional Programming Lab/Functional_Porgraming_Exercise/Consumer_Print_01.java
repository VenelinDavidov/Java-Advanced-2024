package TrainerDemo.Functional_Porgraming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Consumer_Print_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .toList();
        // Consumer: аргумент -> извършва се действие без да се връща резултата
        Consumer<String> consumer = System.out::println;


//        // Начин 1:
//        for (String name : names) {
//            consumer.accept(name);
//        }

        // Начин 2:
        // names.forEach(consumer);

        // Начин 2:
//        names.forEach(name -> System.out.println(name));

    }
}
