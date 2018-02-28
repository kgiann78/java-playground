package playground.numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Prime {

    List<Integer> primes = new ArrayList<>();

    boolean findPrime(int n) {
        if (n % 2 == 0) return false;
        if (n % 3 == 0) return false;
        else primes.add(3);

        for (int i = 5; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    boolean findPrimeStream(int n) {
        if (n % 2 == 0) return false;
        if (n % 3 == 0) return false;
        else primes.add(3);

        IntStream.generate(new IntSupplier() {
            int seed = 2;

            @Override
            public int getAsInt() {
                seed++;
                if (seed == 3) return seed;
                if (seed == 5) return seed;

                while (seed % 3 != 0 || seed % 5 != 0) {
                    seed++;
                }
                return seed;
            }
        });

        for (int i = 5; i * i <= n; i += 2) {
            final int comparator = i;
            if (primes.stream().anyMatch(p-> comparator % p == 0))
                continue;
            if (n % i == 0) return false;
            else primes.add(i);
        }
        return true;
    }


    public static IntStream stream() {
        return IntStream.rangeClosed(2, Integer.MAX_VALUE).filter(n -> n % 2 != 0).filter(n -> isPrime(n));
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .allMatch(n -> number % n != 0);
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        double in = System.currentTimeMillis();
        System.out.println(prime.findPrime(10201));
        double out = System.currentTimeMillis();
        System.out.println("without stream: " + (out - in));

        in = System.currentTimeMillis();
        System.out.println(prime.findPrimeStream(10201));
        out = System.currentTimeMillis();
        System.out.println("with stream: " + (out - in));

    }
}
