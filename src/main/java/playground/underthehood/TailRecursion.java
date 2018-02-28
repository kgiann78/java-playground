package playground.underthehood;

public class TailRecursion {

    /*
    Tail recursion is functionally equivalent to iteration. Since Java does not yet support tail call optimization,
    describe how to transform a simple tail recursive function into a loop and why one is typically preferred over the other.
     */

    public long sumFromOneToN1(long n) {
        if (n < 1) return 0;
        return n + sumFromOneToN1(n-1);
    }

    public long sumFromOneToN2(long n, long a) {
        if (n < 1) {
            return a;
        }

        return sumFromOneToN2(n - 1, a + n);
    }

    public int sumFromOneToN3(int n) {
        int a = 0;

        while(n > 0) {
            a += n--;
        }

        return a;
    }

    public static void main(String[] args) {
        TailRecursion tailRecursion = new TailRecursion();

        long start = System.nanoTime();
        System.out.println(tailRecursion.sumFromOneToN1(1000));
        long stop = System.nanoTime();

        System.out.println("sumFromOneToN1 ended in " + (stop-start) + " ns");

        start = System.nanoTime();
        System.out.println(tailRecursion.sumFromOneToN2(1000, 0));
        stop = System.nanoTime();

        System.out.println("sumFromOneToN2 ended in " + (stop-start) + " ns");

        start = System.nanoTime();
        System.out.println(tailRecursion.sumFromOneToN3(1000));
        stop = System.nanoTime();

        System.out.println("sumFromOneToN3 ended in " + (stop-start) + " ns");
    }
}
