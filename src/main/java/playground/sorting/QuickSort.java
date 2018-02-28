package playground.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 4, 2, 8, 10, 5, 9, 6};
        int low = 0;
        int high = array.length - 1;

        printArray(array);
        quickSort(array, low, high);
        printArray(array);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot);
            quickSort(array, pivot + 1, high);
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
