package playground.sorting;

public class BubbleSort {


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 7, 5, 8, 10, 9, 6};

        printArray(array);
        long start = System.nanoTime();
        bubbleSort(array);
        long stop = System.nanoTime();
        printArray(array);
        System.out.println("Time consumption: " + (stop - start));

        System.out.println();

        array = new int[] {1, 2, 3, 4, 7, 5, 8, 10, 9, 6};
        printArray(array);
        start = System.nanoTime();
        optimizedBubbleSort(array);
        stop = System.nanoTime();
        printArray(array);
        System.out.println("Time consumption: " + (stop - start));

    }

    private static void optimizedBubbleSort(int[] array) {
        boolean isSorted = false;
        int lastSortedIndex = array.length - 1;

        while (!isSorted) {
            isSorted = true;
            for (int i=0; i < lastSortedIndex; i++) {
                if (array[i] > array[i+1]) {
                    isSorted = false;
                    swap(array, i, i+1);
                }
            }
            lastSortedIndex--;
        }
    }


    private static void bubbleSort(int[] array) {
        boolean isSorted;
        do {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
        } while (!isSorted);
    }

    private static void swap(int[] array, int i, int i1) {
        int tmp = array[i];
        array[i] = array[i1];
        array[i1] = tmp;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
