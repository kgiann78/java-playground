package playground.sorting;

public class BubbleSort {
    public static void main(String[] args) {

        boolean hasSwap;

        int[] array = {1, 2, 3, 4, 7, 5, 8, 10, 9, 6};

        printArray(array);

        int count = 0;

        do {
            count++;
            hasSwap = false;
            for (int i=0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    System.out.println("Loop " + count + ": changing " + array[i] + " with " + array[i + 1]);
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    hasSwap = true;
                }
            }
        } while (hasSwap);

        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
