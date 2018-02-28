package playground.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 4, 2, 8, 10, 5, 9, 6};
        printArray(array);
        mergeArray(array, 0, array.length - 1);
        printArray(array);
    }

    private static void mergeArray(int[] array, int start, int stop) {
        if (stop < start || start == stop) return;

        int startLeft = start;
        int stopLeft = (start + stop) / 2;
        int startRight = (start + stop) / 2;
        int stopRight = stop;


        if (stop - start > 1) {
            mergeArray(array, startLeft, stopLeft);
            mergeArray(array, startRight, stopRight);
        }
        if (stop - start == 1) {
            if (array[start] > array[stop]) {
                swap(array, start, stop);
            }
        } else {
            for (int i = startLeft; i <= stopLeft; i++) {
                for (int j = startRight; j <= stopRight; j++) {
                    if (array[i] > array[j]) {
                        swap(array, i, j);
                    }
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
