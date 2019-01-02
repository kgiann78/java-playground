package playground.strings;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReverseWordsInArray {

    private static Logger logger = Logger.getLogger(ReverseWordsInArray.class.getName());

    public static void main(String[] args) {
        char[] input = {'P', 'r', 'a', 'c', 't', 'i', 'c', 'e', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'e', 'r', 'f', 'e', 'c', 't'};

        String result = Arrays.toString(input);
        logger.log(Level.INFO, result);
        reverseArray(input, 0, input.length - 1);
        reverseWord(input);
        result = Arrays.toString(input);
        logger.log(Level.INFO, result);
    }

    private static void reverseWord(char[] input) {
        int start = 0;
        int end = 0;

        while (end < input.length) {
            end = indexOf(input, ' ', start);
            reverseArray(input, start, end - 1);
            start = end + 1;
        }
    }

    private static int indexOf(char[] input, char c, int start) {

        for (int i = start; i < input.length; i++) {
            if (input[i] == c) return i;
        }

        return input.length;
    }

    private static void reverseArray(char[] input, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(input, i, j);
        }
    }

    private static void swap(char[] input, int i, int j) {
        char c = input[i];
        input[i] = input[j];
        input[j] = c;
    }
}
