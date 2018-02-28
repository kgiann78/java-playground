package playground;

import org.junit.Test;
import playground.sorting.MergeSortedArrays;

public class MergeSortedArraysTest {
    @Test
    public void mergeSortedArrays() throws Exception {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] array1 = {1, 2, 4, 5, 6, 7, 10, 12, 15, 19, 21};
        int[] array2 = {2, 3, 4, 5, 6, 7, 10, 13, 16, 20, 22, 23};
        int[] array3 = mergeSortedArrays.mergeSortedArrays(array1, array2);

        for (int i = 0 ; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
        System.out.println("");
    }

}