package playground.sorting;

public class MergeSortedArrays {
    public int[] mergeSortedArrays(int[] array1, int[] array2) {
        if (array2.length > array1.length) return mergeSortedArrays(array2, array1);
        else {
            int[] array3 = new int[array1.length + array2.length];
            int offset = 0;

            for (int i=0; i < array1.length; i++) {
                if (i < array2.length) {
                    int min = array1[i];
                    int max = array2[i];
                    if (array1[i] > array2[i]) {
                        min = array2[i];
                        max = array1[i];
                    }
                    array3[i + offset] = min;
                    offset++;
                    array3[i + offset] = max;
                } else {
                    array3[i + offset] = array1[i];
                }
            }
            return array3;
        }
    }
}
