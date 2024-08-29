import java.util.*;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Coins: 1, 2, 5, 10, 20, 50
        // Sum: 923

        String[] elements = in.nextLine().substring(7).split(", ");

        int[] coins = new int[elements.length];

        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));

        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        int sumCollected = usedCoins.entrySet().stream()
                .mapToInt(e -> e.getKey() * e.getValue())
                .sum();

        if (sumCollected != targetSum) {
            System.out.println("Error");
        } else {
            for (Map.Entry<Integer, Integer> entry : usedCoins.entrySet()) {
                System.out.println(entry.getKey() + "->" + entry.getValue());
            }
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        //Map
        Map<Integer, Integer> coinsCount = new LinkedHashMap<>();

        int index = coins.length - 1;

        while (targetSum > 0 && index >= 0) {

            int coin = coins[index];
            int coinsToTake = targetSum / coin;

            if (coinsToTake != 0) {
                coinsCount.put(coin, coinsToTake);
            }

            targetSum = targetSum % coin;
            index--;
        }
        return coinsCount;
    }

}