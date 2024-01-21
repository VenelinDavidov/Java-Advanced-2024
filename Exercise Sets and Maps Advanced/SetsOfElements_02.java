package Exercises_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] setSize = scanner.nextLine().split(" ");
        int firstSize = Integer.parseInt(setSize[0]);
        int secondSize = Integer.parseInt(setSize[1]);


        LinkedHashSet<String> firstSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSize; i++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }

        LinkedHashSet<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < secondSize; i++) {
            String element = scanner.nextLine();
            secondSet.add(element);
        }

        for (String element : firstSet) {
            if (secondSet.contains(element)){
                System.out.print(element + " ");
            }
        }
    }
}
