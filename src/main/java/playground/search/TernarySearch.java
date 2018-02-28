package playground.search;

public class TernarySearch {
    public static void main(String[] args) {
        int[] array = {1, 4, 7, 9, 10, 14, 19, 25, 28, 31, 38, 45};
        int search = 38;
        int min = 0;
        int max = array.length - 1;

        int med1 = min + (max - min) / 3;
        int med2 = med1 + (max - min) / 3;

        int pos = -1;

        while (array[med1] != search && array[med2] != search && min != max) {
            if (array[max] == search) {
                pos = max;
                break;
            }
            else if (array[min] == search) {
                pos = min;
                break;
            }

            if (search < array[med1]) {
                max = med1;
            } else if (search > array[med2]) {
                min = med2;
            } else {
                min = med1;
                max = med2;
            }

            med1 = min + ((max - min) / 3);
            med2 = med1 + ((max - min) / 3);
            if (array[med1] == search) {
                pos = med1;
                break;
            }
            else if (array[med2] == search) {
                pos = med2;
                break;
            }
        }

        System.out.println(pos);
    }
}
