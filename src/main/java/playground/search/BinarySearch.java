package playground.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 9, 10, 14, 19, 25, 28, 31, 38, 45};
        int search = 21;
        int min = 0;
        int max = array.length - 1;
        int pos = (max - min) / 2;

        while (array[pos] != search && min != max) {
            System.out.println("Searching into [" + min + ", " + max + "] at pos: " + pos);
            System.out.println("Looking for " + search + " and array[" + pos + "] is " + array[pos]);

            if (array[min] == search) {
                pos = min;
                break;
            } else if (array[max] == search) {
                pos = max;
                break;
            } else if (max - min == 2) {

                if (array[pos] < search && (search - array[pos] > array[max] - search)) pos = max;
                else if (array[pos] > search && (search - array[min] < array[pos] - search)) pos = min;

                break;
            }

            if (array[pos] < search) {
                min = pos;
            } else if (array[pos] > search) {
                max = pos;
            }
            pos = min + ((max - min) / 2);
        }

        System.out.println("Answer: " + pos);

    }
}
