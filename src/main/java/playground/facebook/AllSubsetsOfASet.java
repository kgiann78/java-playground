package playground.facebook;

import java.util.*;
import java.util.stream.Collectors;

public class AllSubsetsOfASet {
//    public static void main(String[] args) {
//        String[] array = {"1", "2", "3", "4", "5"};
//        Set<String> set = new TreeSet<>();
//        long start = System.nanoTime();
//        int i = 0;
//        set.add(" ");
//        while (i < array.length) {
//
//            List<String> tmp = new ArrayList<>(set);
//
//            for (String key : tmp) {
//                if (key.equals(" ")) set.add(array[i]);
//                else set.add(key + "," + array[i]);
//            }
//            i++;
//        }
//
//        for (String subset : set)
//            System.out.println(subset);
//
//        long stop = System.nanoTime();
//        System.out.println("Time spent " + (stop - start));
//    }

    public static void main(String[] args) {
        String[] array = {"1", "2", "3", "4", "5"};
        String[] subset = new String[array.length];
        long start = System.nanoTime();
        helper(array, subset, 0);
        long stop = System.nanoTime();
        System.out.println("Time spent " + (stop - start));
    }

    private static void helper(String[] array, String[] subset, int i) {
        if (i == array.length) print_subset(subset);
        else {
            subset[i] = null;
            helper(array, subset, i + 1);

            subset[i] = array[i];
            helper(array, subset, i + 1);
        }
    }

    private static void print_subset(String[] subset) {
        for (String item : subset) {
            if (item != null) System.out.print(item + ",");
        }
        System.out.println();
    }
}
