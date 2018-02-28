package playground.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 4, 2, 8, 10, 5, 9, 6};
        printArray(array);
        insertionSort(array);
        printArray(array);
    }

    private static void insertionSort(int[] array) {
        if (array.length <= 1) return;

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int pos = i;
            int j = i - 1;
            for (; j >= 0; --j) {
                if (current < array[j]) {
                    array[pos] = array[j];
                    pos = j;
                }
            }
            array[pos] = current;
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
