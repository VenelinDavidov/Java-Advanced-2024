package TrainerDemo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //1. входни данни
        String input = scanner.nextLine();
        List<String> words = Arrays.stream(input.split("\\s+")).collect(Collectors.toList()); //лист със всички думи в текста

        //дума -> true (ако започва с главна буква) / false (ако не започва с главна буква)
        Predicate<String> isUppercase = word -> Character.isUpperCase(word.charAt(0));
        words = words.stream().filter(isUppercase).collect(Collectors.toList());

        //words -> имаме само думи, които започват с главна буква
        System.out.println(words.size());
        System.out.println(String.join("\n", words));

    }
}
