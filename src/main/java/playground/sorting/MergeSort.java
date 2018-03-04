package playground.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 4, 2, 8, 10, 5, 9, 6};
        printArray(array);
        mergesort(array);
        printArray(array);
    }

    private static void mergesort(int[] array) {
        // call mergesort method with actual limits of array (0 to length - 1)
        mergesort(array, new int[array.length], 0, array.length - 1);
    }

    // find median and call mergesort for two halves (start to median, median to end)
    // in the end merge the two halves together
    private static void mergesort(int[] array, int[] tmp, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) / 2;
        mergesort(array, tmp, start, middle);
        mergesort(array, tmp, middle + 1, end);
        mergeHalves(array, tmp, start, end);
    }

    // Merging the two halves needs another temporal array to store the sorted
    // elements and then copy the sorted slots back to the array
    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            } else {
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
