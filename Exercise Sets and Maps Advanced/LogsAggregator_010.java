package Exercises_SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator_010 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, Integer> usersWithTime = new TreeMap<>();
        TreeMap<String, TreeSet<String>> addresses = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String ip = tokens[0];
            String name = tokens[1];
            int time = Integer.parseInt(tokens[2]);

            if(!usersWithTime.containsKey(name)){
                usersWithTime.put(name, time);
                addresses.put(name, new TreeSet<>(){{add(ip);}});
            }else{
                usersWithTime.put(name, usersWithTime.get(name)  + time);
                addresses.get(name).add(ip);
            }
        }

        usersWithTime.forEach((key, value) ->{

            System.out.println(String.format("%s: %d %s", key, value, addresses.get(key).toString()));

        });
    }
}


