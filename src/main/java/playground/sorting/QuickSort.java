package playground.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 4, 2, 8, 10, 5, 9, 6};
        printArray(array);
        quickSort(array);
        printArray(array);
    }

    private static void quickSort(int[] array) {
        quickSort(array, 0,array.length - 1);

    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int median = partition(array, low, high);
            quickSort(array, low, median);
            quickSort(array, median + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low;
        int j = high;

        while (true) {
            while ((i < high) && (array[i] < pivot)) i++;

            while ((j > low) && (array[j] > pivot)) j--;

            if (i >= j) return j;

            swap(array, i, j);
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
