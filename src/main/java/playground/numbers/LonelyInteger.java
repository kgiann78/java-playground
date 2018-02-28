package playground.numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
In an array of integers, all numbers appear twice except of one. Find and print the number that appears only once.
 */
public class LonelyInteger {
    public static void main(String[] args) throws Exception {
        int[] integers = {9, 1, 2, 3, 2, 9, 1, 7, 7};
        System.out.println(getTheLonelyIntegerWithHashMap(integers));
        System.out.println(getTheLonelyIntegerWithBytes(integers));
    }

    // XORs each bit of the integer.
    // Odd 1s give 1
    // Even 1s give 0
    //
    // XOR bool table
    // 1 ^ 0 = 1
    // 0 ^ 1 = 1
    // 1 ^ 1 = 0
    // 0 ^ 0 = 0
    private static int getTheLonelyIntegerWithBytes(int[] integers) {
        int result = 0;
        for (int integer : integers)
            result ^= integer;
        return result;
    }

    private static int getTheLonelyIntegerWithHashMap(int[] integers) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();

        for (int integer : integers) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);
            } else {
                map.put(integer, map.get(integer) + 1);
            }
        }

        for (Integer key : map.keySet())
            if (map.get(key) == 1) return key;

        throw new Exception("Not found Lonely number Exception");
    }
}
