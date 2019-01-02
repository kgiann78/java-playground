package playground.search;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NthSmallestNumber {

    private static Logger logger = Logger.getLogger(NthSmallestNumber.class.getName());

    public static void main(String[] args) {
        int[] arr = new int[]{4, 10, 2, 9, 8};
        logger.log(Level.INFO, "{0}", nthSmallest(arr, 3) == 8);
    }

    private static int nthSmallest(int[] arr, int n) {
        int start = 0;
        int end = arr.length;
        int[] tmpArr = new int[arr.length];
        int pivot = n - 1;

        if (arr.length == 2) {
            return calculateArrayOfTwoElements(arr, n);
        }

        for (int anArr : arr) {
            if (anArr < arr[pivot]) tmpArr[start++] = anArr;
            else if (anArr > arr[pivot]) tmpArr[--end] = anArr;
        }

        tmpArr[start] = arr[pivot];

        if (start < pivot) {
            return nthSmallest(Arrays.copyOfRange(tmpArr, start + 1, tmpArr.length), n - start - 1);
        } else if (start > pivot) {
            return nthSmallest(Arrays.copyOfRange(tmpArr, 0, start), start - pivot);
        } else
            return tmpArr[start];
    }

    private static int calculateArrayOfTwoElements(int[] arr, int n) {
        switch (n) {
            case 0:
                return (arr[0] < arr[1]) ? arr[0] : arr[1];
            case 1:
                return (arr[0] < arr[1]) ? arr[1] : arr[0];
            default:
                return -1;
        }
    }

}
