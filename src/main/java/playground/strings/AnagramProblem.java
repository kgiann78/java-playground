package playground.strings;

public class AnagramProblem {

    /*
        For two strings s1 and s2 remove as many letters from either strings in order
        to become anagrams to each other.

        Return the number of letters needed to be removed.
     */

    public static int NUMBER_OF_LETTERS = 26;

    public static void main(String[] args) throws Exception {
        String s1 = "hello";
        String s2 = "billion";

        System.out.println(numberNeeded(s1, s2));
    }

    private static int numberNeeded(String s1, String s2) throws Exception {
        int[] charCount1 = getCharCounts(s1);
        int[] charCount2 = getCharCounts(s2);

        return delta(charCount1, charCount2);
    }

    private static int delta(int[] charCount1, int[] charCount2) throws Exception {
        if (charCount1.length != charCount2.length)
            throw new Exception("Arrays should have the same amount of characters");

        int delta = 0;
        for (int i=0; i < charCount1.length; i++) {
            delta += Math.abs(charCount1[i] - charCount2[i]);
        }
        return delta;
    }

    private static int[] getCharCounts(String s) {
        int[] charCount = new int[NUMBER_OF_LETTERS];
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            int offset = (int)'a';
            int code = (int)c - offset;
            charCount[code]++;
        }

        for (int i=0; i < NUMBER_OF_LETTERS; i++)
            System.out.print(charCount[i] + " ");
        System.out.println();
        return charCount;
    }
}
