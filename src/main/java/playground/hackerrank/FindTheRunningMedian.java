package playground.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindTheRunningMedian {

    public static double[] getMedians(int[] array) {
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });

        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        double[] medians = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            addNumber(array[i], lowers, highers);
            balance(lowers, highers);
            double median = getMedian(lowers, highers);
            medians[i] = median;
        }

        return medians;
    }

    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    public static void balance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = (lowers.size() > highers.size()) ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = (lowers.size() < highers.size()) ? lowers : highers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() < highers.size() ? lowers : highers;

        if (biggerHeap.size() == smallerHeap.size()) {
            return (double) (highers.peek() + lowers.peek()) / (double) 2;
        } else {
            return biggerHeap.peek();
        }
    }


    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of integers that will follow:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer: ");
            array[i] = scanner.nextInt();
        }

        double[] medians = getMedians(array);

        for (int i = 0; i < n; i++) {
            System.out.println(medians[i]);
        }
    }
}
