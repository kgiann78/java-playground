package playground.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 4, 2, 8, 10, 5, 9, 6};
        printArray(array);
        mergesort(array, 0, array.length - 1);
        printArray(array);
    }

    private static void mergesort(int[] array, int lo, int hi) {

        if (lo < hi) {

            // find median and call mergesort for the two halves
            int m = (lo + hi) / 2;
            mergesort(array, lo, m);
            mergesort(array, m + 1, hi);

            // then merge and sort the two halves
            merge(array, lo, m, hi);
        }
    }

    private static void merge(int[] array, int lo, int m, int hi) {
        int leftSize = m - lo + 1;
        int rightSize = hi - m;

        // Create two temp arrays to store the initial values of the array
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // Copy values to tmp arrays
        for (int i=0; i<leftSize; ++i)
            left[i] = array[lo + i];
        for (int j=0; j<rightSize; ++j)
            right[j] = array[m + 1+ j];


        int i = 0;
        int j = 0;
        int k = lo;

        // Start comparing and sorting elements to the array
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        // copying rest elements to the array
        while (i < leftSize) {
            array[k++] = left[i++];
        }

        while (j < rightSize) {
            array[k++] = right[j++];
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
