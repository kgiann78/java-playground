package playground.numbers;

import java.util.HashMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Fibonacci {
    private static HashMap<Long, Long> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int f = 50;

        new Thread(() -> {
            long start = System.currentTimeMillis();
            long fib = fibonacci.streams(f);
            long stop = System.currentTimeMillis();
            System.out.println("Streams ended in " + (stop - start) + " ms with value " + fib);
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            long fib = fibonacci.recursive(f);
            long stop = System.currentTimeMillis();
            System.out.println("Recursive ended in " + (stop - start) + " ms with value " + fib);
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            long fib = fibonacci.iterative(f);
            long stop = System.currentTimeMillis();
            System.out.println("Iterative ended in " + (stop - start) + " ms with value " + fib);
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            long fib = fibonacci.hashing(f);
            long stop = System.currentTimeMillis();
            System.out.println("Hashing ended in " + (stop - start) + " ms with value " + fib);
        }).start();
    }

    private long streams(int series) {

        return Stream.iterate(new long[]{0L, 1L}, s -> new long[]{s[1], s[0] + s[1]})
                .limit(series)
                .map(n -> n[1])
                .collect(toList()).get(series - 1);
    }

    private long recursive(long n) {
        if (n < 0) return 0;
        if (n < 2) return n;

        return recursive(n - 1) + recursive(n - 2);
    }

    private long iterative(long n) {
        if (n < 0) return 0;
        if (n < 2) return n;
        long fibonacci = 0L;
        long i = 1L;
        long f1 = 0L;
        long f2 = 1L;

        while (i < n) {
            fibonacci = f1 + f2;
            f1 = f2;
            f2 = fibonacci;
            i++;
        }

        return fibonacci;
    }

    private long hashing(long n) {
        if (hashMap.containsKey(n)) return hashMap.get(n);
        if (n < 0) {
            hashMap.put(0L, 0L);
            return 0;
        }

        if (n < 2) {
            hashMap.put(n, n);
            return n;
        }

        hashMap.put(n, hashing(n - 2) + hashing(n - 1));
        return hashMap.get(n);
    }
}
