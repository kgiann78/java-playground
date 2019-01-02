package playground.search;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FindMissingNumber {

    private static Logger logger = Logger.getLogger(FindMissingNumber.class.getName());

    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        int[] arr2 = new int[] {1, 2, 4, 5};

        logger.log(Level.INFO, "{0}", findMissingNumber(arr1, arr2));
    }

    private static int findMissingNumber(int[] arr1, int[] arr2) {

        if (arr1.length < arr2.length) return findMissingNumber(arr2, arr1);

        int sum = 0;
        int i = 0;
        for (i=0; i < arr2.length; i++) {
            sum += (arr1[i] - arr2[i]);
        }

        sum += arr1[i];

        return sum;
    }
}
