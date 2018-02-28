package playground.search;

public class FindAPeak {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 1, 1, 2, 1, 2, 3, 4, 3, 2, 1};
        System.out.println(findAPeak(array, 0, array.length));
    }

    private static boolean findAPeak(int[] array, int start, int end) {
        if (end - start <= 2) {
            return true;
        }

        int middle = (end - start) / 2;

        if (array[middle] < array[middle - 1]) {
            return findAPeak(array, start, middle);
        } else if (array[middle] < array[middle + 1]) {
            return findAPeak(array, middle + 1, end);
        } else {
            return true;
        }
    }
}
