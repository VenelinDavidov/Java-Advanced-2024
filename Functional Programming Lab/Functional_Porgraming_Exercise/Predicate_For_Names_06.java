package TrainerDemo.Functional_Porgraming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Predicate_For_Names_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int requiredLength = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        // Predicate: аргумент -> израз/действие, който връща булева стойност
        Predicate<String> predicate = name -> name.length() <= requiredLength;

        for (String name : names) {
            predicate.test(name);
            System.out.println(name);
        }

        //Начин 1:
//        names.stream()
//                .filter(predicate)
//                .forEach(name -> System.out.println(name));
    }
}
