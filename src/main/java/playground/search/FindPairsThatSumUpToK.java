package playground.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairsThatSumUpToK {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 5, 2, 7, 3, 4};
        findPairsThatSumUpToK(arr, 5);
    }

    private static void findPairsThatSumUpToK(int[] arr, int i) {

        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        Set<Integer> uniques = new HashSet<>();

        System.out.println(Arrays.toString(arr));

        while (start < end) {

            while (start < arr.length && (arr[start] > i || uniques.contains(arr[start]))) {
                start++;
            }
            while (end > 0 && (arr[end] > i || uniques.contains(arr[end]))) {
                end--;
            }

            int sum = arr[end] + arr[start];
            if (sum != i) --end;
            else {
                System.out.println("(" + arr[start] + ", " + arr[end] + ")");
                uniques.add(arr[start]);
                uniques.add(arr[end]);
                start++;
            }
        }
    }
}
