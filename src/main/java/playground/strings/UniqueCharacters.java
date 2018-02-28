package playground.strings;

public class UniqueCharacters {
    public static void main(String[] args) {
        System.out.println(hasUniqueLetters2("AbcdefgA"));
        System.out.println("Successfully past test one");

        System.out.println(hasUniqueLetters2("Abcdefg"));
        System.out.println("Successfully past test two");

        System.out.println("Done");
    }

    static boolean hasUniqueLetters1(String word) {
        int[] chars = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int c = word.toLowerCase().charAt(i);
            if (chars[c % 26] != 1) chars[c % 26] = 1;
            else {
                return false;
            }
        }
        return true;
    }

    static boolean hasUniqueLetters2(String word) {
        int unique = 0;
        for (int i = 0; i < word.length(); i++) {
            int c = word.toLowerCase().charAt(i);
            if ((unique & (1 << c)) > 0) {
                return false;
            }
            unique |= (1 << c);
        }
        return true;
    }
}
