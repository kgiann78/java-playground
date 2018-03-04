package playground.sorting;

/**
 * Created by constantine on 12/05/2017.
 */
public class SortRotatedArray {
    public static void main(String[] args) {
        int[] array = { 3, 4, 5, 6, 7, 1, 2 };
        printArray(array);

        int start = 0;
        int i = 1;

        while (i < array.length && array[i] > array[start]) {
            i++;
        }

        int[] tmp = new int[i];
        System.arraycopy(array, 0, tmp, 0, i);
        System.arraycopy(array, i, array, 0, array.length - i);
        System.arraycopy(tmp, 0, array, array.length - i, i);
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
