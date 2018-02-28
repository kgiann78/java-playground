package playground.hackerrank;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange
{
    static long getWays(int n, long[] c){
        // Complete this function
        long[] ways = new long[n + 1];
        ways[0] = 1;
        for (int i = 0; i < c.length; i++) {
            for (long j = c[i]; j < ways.length; j++) {
                ways[(int)j] += ways[(int)(j - c[i])];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println("Write input here:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);

        System.out.println(ways);
    }
}
