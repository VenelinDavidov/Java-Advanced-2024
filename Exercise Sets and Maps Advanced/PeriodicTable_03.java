package Exercises_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

          int numberOfCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < numberOfCompounds; i++) {
            String [] compound = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(compound));
        }

        String result = String.join(" ", elements);
        System.out.println(result);
    }
}
