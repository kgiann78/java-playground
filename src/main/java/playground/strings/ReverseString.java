package playground.strings;

import java.util.logging.Logger;

public class ReverseString {

    private static Logger logger = Logger.getLogger(ReverseString.class.getName());

    public static void main(String[] args) {
        String value = "This is a string to be reversed?";
        logger.info(value);

        long start = System.nanoTime();
        value = reverseWithStringBuilder(value);
        long middle = System.nanoTime();
        value = reverseWithCharArray(value);
        long end = System.nanoTime();

        logger.info(value);

        logger.info("First reversion: " + (middle - start));
        logger.info("Second reversion: " + (end - middle));

    }

    private static String reverseWithCharArray(String value) {

        char[] chars = value.toCharArray();
        for (int i=0, j=chars.length - 1; i < j; i++, j--) {
            swap(chars, i, j);
        }

        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    private static String reverseWithStringBuilder(String value) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i= value.length() -1; i >=0 ; i--) {
            stringBuilder.append(value.charAt(i));
        }
        return stringBuilder.toString();
    }
}
