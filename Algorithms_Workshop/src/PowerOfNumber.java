import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);


        int x = 2;

        int n = 16;

        System.out.println(Math.pow(x,n));

        int result = x;

        for (int i = n; i > 1; i--) {
            result = result * x;
        }

        System.out.println(result);
        System.out.println(power(x, n));
    }

    private static int power(int number, int power) {

        if (power == 1){
            return number;
        }
        int prevPower = power(number, power - 1);
        int pow = number * prevPower;
        return pow;
    }
}
