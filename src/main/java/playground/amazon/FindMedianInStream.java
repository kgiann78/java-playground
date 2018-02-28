package playground.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindMedianInStream {

    static List<Integer> stream = new ArrayList<>();
    static int median = 0;
    static int sum = 0;

    public static void main(String[] args) {

        addNumber(5);
        addNumber(15);
        addNumber(1);
        addNumber(3);
    }

    private static void addNumber(int n) {
        stream.add(n);
        System.out.println(stream);
        sum += n;
        median = sum/stream.size();
        System.out.println(median);
    }
}
