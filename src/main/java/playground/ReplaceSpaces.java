package playground;

public class ReplaceSpaces {
    public static void replaceSpaces1(String input) {
        String output = input.replaceAll(" ", "%20");
        System.out.println(output);
    }

    public static void replaceSpaces2(String input) {
        int count = 0;
        char[] output;
        char[] inputArr = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (inputArr[i] == ' ') count++;
        }
        int outputLength = input.length() + count * 2;
        output = new char[outputLength];

        int offset = 0;
        for (int i = 0; i < input.length(); i++) {

            if (inputArr[i] != ' ') output[i + offset] = inputArr[i];
            if (inputArr[i] == ' ') {
                output[i + offset] = '%';
                offset++;
                output[i + offset] = '2';
                offset++;
                output[i + offset] = '0';
            }
        }

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
        }
        System.out.println("");
    }
}
