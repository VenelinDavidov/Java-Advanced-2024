package Exercises_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueName = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            uniqueName.add(name);
        }
        for (String names : uniqueName) {
            System.out.println(names);
        }
    }
}
