import java.util.Arrays;
import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();


        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
        System.out.println(getSumArr(arr, 0));
    }

    private static int getSumArr(int[] arr, int index) {
        if (index == arr.length) {
            return arr[index];
        }
        int sum = arr[index] + getSumArr(arr, index + 1);
        return sum;
    }
}
