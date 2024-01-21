package Exercises_SetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

          String input = scanner.nextLine();

        Map<Character, Integer> symbolMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (!symbolMap.containsKey(currentSymbol)){
                symbolMap.put(currentSymbol, 1);
            } else {
                int currentOccurrences = symbolMap.get(currentSymbol);
                symbolMap.put(currentSymbol, currentOccurrences + 1);
            }
            //symbolMap.putIfAbsent(currentSymbol, 1);    //TODO: oder metods

        }

        for (Map.Entry<Character, Integer> pair : symbolMap.entrySet()) {
            System.out.printf("%s: %d time/s%n", pair.getKey(), pair.getValue());
        }
    }
}
