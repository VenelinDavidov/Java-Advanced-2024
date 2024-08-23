package Threeuple;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split("\\s+");

        //Sofia Jackson Izgrev Burgas -> Sofia Jackson -> Izgrev -> Burga
        String name = input[0] + " " + input[1];
        String neighborhood = input[2];
        String city = input[3];
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, neighborhood, city);
        System.out.println(firstThreeuple);

        // Max 18 drunk
        input = scanner.nextLine().split("\\s+");
        String firstName = input[0];
        Integer litersOfBeer = Integer.parseInt(input[1]);
        String drunkOrNot = input[2];
        boolean isDrunk = drunkOrNot.equals("drunk");
        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(firstName, litersOfBeer, isDrunk);
        System.out.println(secondThreeuple);


        // Alex 0.10 DSK
        input = scanner.nextLine().split("\\s+");
        String nameAccount = input[0];
        double amount = Double.parseDouble(input[1]);
        String bank = input[2];
        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(nameAccount, amount, bank);
        System.out.println(thirdThreeuple);

    }
}
