import java.util.Scanner;

public class Fibonacci_Two {

    public static long counter = 0;
    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1];

        //create a methods
        long fibonacci = fibonacci(n);

        System.out.println(fibonacci);
        System.out.println(counter);;
    }


    private static long fibonacci(int n) {

        counter++;

        if (n <= 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
