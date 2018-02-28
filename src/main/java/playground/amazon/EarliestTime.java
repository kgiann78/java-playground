package playground.amazon;

import java.util.Arrays;

public class EarliestTime {
    public String getEarliestTime(int A, int B, int C, int D, int E, int F) {

        int[] array = { A, B, C, D, E, F};
        String errorMessage = "NOT PROPER TIME";
        int n = array.length;

        Arrays.sort(array);
        printArray(array);

        if (array[0] > 2) return errorMessage;

        //01:23:45
        for (int i=n -1; i >= 0; i--) {
            // index j points to what is left of index i
            for (int j=i-1; j >=0; j--) {
                // if the digit is the decades and it is more than 59
                // swap it with what is left to it
                if (i%2 == 0 && array[i] > 5 && array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                    printArray(array);
                }
            }
        }

        if (array[0] > 2) return errorMessage;
        if (array[0] == 2 && array[1] > 3) return errorMessage;
        if (array[2] > 5 || array[4] > 5) return errorMessage;

        return String.format("%d%d:%d%d:%d%d", array[0],array[1],array[2],array[3],array[4],array[5]);
    }

    public void printArray(int[] array) {
        for (int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) {
        EarliestTime earliestTime = new EarliestTime();

        System.out.println(earliestTime.getEarliestTime(7, 2, 1, 4, 5, 6));
        System.out.println(earliestTime.getEarliestTime(0, 0, 0, 0, 0, 0));
        System.out.println(earliestTime.getEarliestTime(0, 0, 0, 7, 8, 9));
        System.out.println(earliestTime.getEarliestTime(0, 0, 7, 7, 8, 9));
        System.out.println(earliestTime.getEarliestTime(0, 0, 1, 7, 8, 9));
        System.out.println(earliestTime.getEarliestTime(9, 8, 7, 1, 1, 1));
    }
}
