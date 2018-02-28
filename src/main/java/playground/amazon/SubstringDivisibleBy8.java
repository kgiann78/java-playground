package playground.amazon;

import java.util.HashMap;
import java.util.Map;

public class SubstringDivisibleBy8 {
    public static void main(String[] args) {
        int number = 10858;

        int[] num = String.valueOf(number).chars().map(Character::getNumericValue).toArray();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < num.length; i++) {
            addToMapDistinct(map, num, i);
            addToMapAsc(map, num, i);
            addToMapDesc(map, num, i);
        }

        System.out.println(map);
    }

    private static void addToMapDistinct(Map<Integer, Integer> map, int[] num, int i) {
        int substr = num[i];
        if (substr % 8 == 0) {
            if (!map.containsKey(substr))
                map.put(substr, 1);
            else {
                map.put(substr, map.get(substr) + 1);
            }
        }
    }

    private static void addToMapAsc(Map<Integer, Integer> map, int[] num, int i) {
        StringBuilder substringBuilder = new StringBuilder();
        for (int j = 0; j < i + 1; j++) {
            substringBuilder.append(num[j]);
        }
        if (!substringBuilder.toString().isEmpty()) {

            int substr = Integer.valueOf(substringBuilder.toString());
            if (substr % 8 == 0) {
                if (!map.containsKey(substr))
                    map.put(substr, 1);
                else {
                    map.put(substr, map.get(substr) + 1);
                }
            }
        }
    }

    private static void addToMapDesc(Map<Integer, Integer> map, int[] num, int i) {
        StringBuilder substringBuilder = new StringBuilder();

        for (int j = i; j < num.length; j++) {
            substringBuilder.append(num[j]);
        }

        if (!substringBuilder.toString().isEmpty()) {

            int substr = Integer.valueOf(substringBuilder.toString());
            if (substr % 8 == 0) {
                if (!map.containsKey(substr))
                    map.put(substr, 1);
                else {
                    map.put(substr, map.get(substr) + 1);
                }
            }
        }
    }
}
