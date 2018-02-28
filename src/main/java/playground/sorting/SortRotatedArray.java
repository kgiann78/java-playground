package playground.sorting;

/**
 * Created by constantine on 12/05/2017.
 */
public class SortRotatedArray {
    public static void main(String[] args) {
        int[] array = { 3, 4, 5, 6, 7, 1, 2 };

        if (array == null || array.length <= 1) {
            System.out.println("nothing to do here...");
            return;
        }

        int start = 0;
        int end = 0;
        int i = 1;

        while (array[i] > array[start] && i < array.length) {
            i++;
        }

        start = i;
        end = i - 1;

        for (int j=0; j < array.length; j++) {

        }

        System.out.println(start + " " + end);
    }
}
