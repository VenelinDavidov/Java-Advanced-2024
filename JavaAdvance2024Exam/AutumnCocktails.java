import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    private static final int Pear_Sour = 150;
    private static final int The_Harvest = 250;
    private static final int Apple_Hinny = 300;
    private static final int High_Fashion = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cocktails = new HashMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        ArrayDeque<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshness::push);

        while (!ingredients.isEmpty() && !freshness.isEmpty()) {
            int firstIngredients = ingredients.poll();
            if (firstIngredients == 0){
                continue;
            }
            int lastFreshness = freshness.pop();

            int totalLevel = firstIngredients * lastFreshness;

            switch (totalLevel) {
                case Pear_Sour:
                    int currentPearSour = cocktails.get("Pear Sour");
                    currentPearSour++;
                    cocktails.put("Pear Sour", currentPearSour);
                    break;
                case The_Harvest:
                    int currentTheHarvest = cocktails.get("The Harvest");
                    currentTheHarvest++;
                    cocktails.put("The Harvest", currentTheHarvest);
                    break;
                case Apple_Hinny:
                    int currentApple = cocktails.get("Apple Hinny");
                    currentApple++;
                    cocktails.put("Apple Hinny", currentApple);
                    break;
                case High_Fashion:
                    int currentHigh = cocktails.get("High Fashion");
                    currentHigh++;
                    cocktails.put("High Fashion", currentHigh);
                    break;
                default:
                    firstIngredients +=5;
                    ingredients.offer(firstIngredients);
                    break;

            }
        }

        if (cocktails.get("Pear Sour") > 0
                && cocktails.get("The Harvest") > 0
                && cocktails.get("Apple Hinny") > 0
                && cocktails.get("High Fashion") > 0){
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()){
            int sum = 0;
            int leftoverIngredients = ingredients.stream().mapToInt(e->e).sum();
            for (Integer ingredient : ingredients) {
                sum +=ingredient;
            }
            System.out.printf("Ingredients left: %d%n",sum);
        }

        if (cocktails.get("Apple Hinny") > 0) {
            System.out.printf("# Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
        }

        if (cocktails.get("High Fashion") > 0) {
            System.out.printf("# High Fashion --> %d%n", cocktails.get("High Fashion"));
        }

        if (cocktails.get("Pear Sour") > 0) {
            System.out.printf("# Pear Sour --> %d%n", cocktails.get("Pear Sour"));
        }

        if (cocktails.get("The Harvest") > 0) {
            System.out.printf("# The Harvest --> %d%n", cocktails.get("The Harvest"));
        }

    }
}