package playground.strings;

public class FindAllPermutations {

    public static void main(String[] args) {
        String s = "xacxzaa";
        String b = "fxaazxacaaxzoecazxaxaz";
        int count = 0;

        int[] tmpArr = {0};
        s.chars().forEach(value -> {
            tmpArr[0] += value;
        });

        int sAscii = tmpArr[0];

        int[] arr = b.chars().map(Character::toLowerCase).toArray();
        int ascii = initialize(arr, s.length());

        if (ascii == sAscii) {
            if (compare(s, b.substring(0, s.length()))) {
                count++;
            }
        }

        for (int i = s.length(); i < arr.length; i++) {
            ascii -= arr[i - s.length()];
            ascii += arr[i];
            if (ascii == sAscii) {
                int start = i - s.length();
                int end = (start + s.length() > b.length())? b.length() - start:start + s.length();
                if (compare(s, b.substring(start, end))) {
                    System.out.println(s + " has permutation " + b.substring(start, end));
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean compare(String s, String b) {
        for (String b1 : b.split("")) {
            if (!s.contains(b1)) return false;
        }
        return true;
    }

    private static int initialize(int[] arr, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            System.out.print((char)arr[i]);
            count += arr[i];
        }
        System.out.println();
        return count;
    }
}
