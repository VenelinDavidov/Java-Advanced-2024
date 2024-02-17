import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);



        ArrayDeque<Integer> money  = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))   //stack
                .map(Integer::parseInt)
                .forEach(money::push);

        ArrayDeque<Integer> prices = Arrays.stream(scanner.nextLine().split("\\s+")) //queue
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));












    }
}
