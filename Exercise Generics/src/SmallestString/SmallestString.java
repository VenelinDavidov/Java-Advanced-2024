package SmallestString;

import java.util.List;
import java.util.Scanner;

public class SmallestString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }

  // get smallest String in integer;
    public static <T extends Comparable<T>> T getSmallestString(List<T> list) {
        T min = list.get(0);
        for (T element : list) {
            if (element.compareTo(min) > 0){
                min = element;
            }
        }
        return min;
    }
}
