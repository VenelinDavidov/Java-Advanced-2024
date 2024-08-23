package Tuple;

import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // 23 21.2321232

        //Sam Johnson Sofia -> "Sam", "Johnson", "Sofia";
        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String city = input[2];
        Tuple<String, String> firstTuple = new Tuple<>(name, city);
        // John 2
        input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        Integer litersOfBeer = Integer.parseInt(input[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(firstName, litersOfBeer);
        // 23 21.2321232
        input = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(input[0]);
        Double decimal = Double.parseDouble(input[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(number, decimal);

        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);

    }
}
