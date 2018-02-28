package playground.strings;

public class ReplaceDuplicates {

    public static void main(String[] args) {
        String word = "avvcddefggff";
//        String word = "abbracaddabbra";

        System.out.println(caseOne(word));
        System.out.println(caseTwo(word));
    }

    static String caseOne(String word) {

        int dup = 0;
        int i = 0;
        int count = 0;
        System.out.println(word.length());

        while (i < word.length()) {
            int val = word.charAt(i);

            if ((dup & (1 << val)) > 0) {
                System.out.println(i);
//                if (i < word.length() - 1)
                    word = word.substring(0, i) + word.substring(i + 1);
//                else
//                    word = word.substring(0, i);
            } else {
                dup |= (1 << val);
                i++;
            }
            count++;
        }
        System.out.println(count);
        return word;
    }

    static String caseTwo(String word) {
        if (word.length() == 1) return word;
        int dup = word.charAt(0);
        int i = 1;
        while (i < word.length()) {
            int val = word.charAt(i);
            if (val == dup) {
                if (i < word.length() - 1)
                    word = word.substring(0, i) + word.substring(i + 1);
                else
                    word = word.substring(0, i);
            } else {
                dup = val;
                i++;
            }
        }
        return word;
    }
}
