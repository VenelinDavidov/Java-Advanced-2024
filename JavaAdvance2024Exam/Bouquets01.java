import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))   //stack
                .map(Integer::parseInt)
                .forEach(tulips::push);


        ArrayDeque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(", ")) //queue
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;

        int leftFlower = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tulip = tulips.peek();
            int daffodil = daffodils.peek();

           int sumBouquets = tulip + daffodil;

            if (sumBouquets == 15) {
                bouquets++;
                tulips.pop();
                daffodils.poll();
            } else if (sumBouquets > 15) {
                tulips.pop();
                tulips.push(tulip - 2);
            } else if (sumBouquets < 15) {
                leftFlower += sumBouquets;
                tulips.pop();
                daffodils.poll();
            }
        }

      // int lastBouquets = leftFlower / 15;
      //  bouquets += lastBouquets;
        while (leftFlower >= 15) {
            bouquets++;
            leftFlower -= 15;
        }

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }

    }
}
