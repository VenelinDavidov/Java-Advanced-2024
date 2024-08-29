public class CountingSort {
    public static void main(String[] args) {


        int[] numbers = new int[]{13, 73, 42, 69, 13, 42, 99, 69, 13};

        int[] sort = new int[100];

        for (int number : numbers) {
            sort[number]++;
        }

        for (int index = 0; index < sort.length; index++) {
            if (sort[index] != 0 ){
                for (int i = 0; i < sort[index]; i++) {
                    System.out.print(index + " ");
                }
            }
        }
    }
}
