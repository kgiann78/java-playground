package playground.amazon;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EarliestTime {
    private static Logger logger = Logger.getLogger(EarliestTime.class.getName());

    private String getEarliestTime(int a, int b, int c, int d, int e, int f) {

        int[] array = { a, b, c, d, e, f};
        String errorMessage = "NOT PROPER TIME";
        int n = array.length;

        Arrays.sort(array);
        String result = Arrays.toString(array);
        logger.log(Level.INFO, result);

        // 00:00:00 - 23:59:59
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
                    result = Arrays.toString(array);
                    logger.log(Level.INFO, result);
                }
            }
        }

        if (array[0] > 2) return errorMessage;
        if (array[0] == 2 && array[1] > 3) return errorMessage;
        if (array[2] > 5 || array[4] > 5) return errorMessage;

        return String.format("%d%d:%d%d:%d%d", array[0],array[1],array[2],array[3],array[4],array[5]);
    }

    public static void main(String[] args) {
        EarliestTime earliestTime = new EarliestTime();
        logger.log(Level.INFO, earliestTime.getEarliestTime(7, 2, 1, 4, 5, 6));
        logger.log(Level.INFO, earliestTime.getEarliestTime(0, 0, 0, 0, 0, 0));
        logger.log(Level.INFO, earliestTime.getEarliestTime(0, 0, 0, 7, 8, 9));
        logger.log(Level.INFO, earliestTime.getEarliestTime(0, 0, 7, 7, 8, 9));
        logger.log(Level.INFO, earliestTime.getEarliestTime(0, 0, 1, 7, 8, 9));
        logger.log(Level.INFO, earliestTime.getEarliestTime(9, 8, 7, 1, 1, 1));
    }
}
