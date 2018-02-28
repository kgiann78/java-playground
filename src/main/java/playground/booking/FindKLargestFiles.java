package playground.booking;

import java.util.*;

public class FindKLargestFiles {

    public static void main(String[] args) {
        int[] array = {5, 6, 7, 5, 1, 39, 39, 12, 14, 16, 12, 6, 34, 54, 24, 35, 39, 44, 39, 41};
        int k = 5;

        reversedTreeMap(array, k);
        unreversedTreeMap(array, k);
    }

    public static void reversedTreeMap(int[] array, int k) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < array.length; i++) {
            count1++;
           if (!map.containsKey(array[i])) {
               map.put(array[i], new ArrayList<>());
           }
           map.get(array[i]).add(array[i]);
        }

        List<Integer> largeFiles = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            count2++;
            if (entry.getValue().size() < k - largeFiles.size()) {
                count3 += entry.getValue().size();
                largeFiles.addAll(entry.getValue());
            } else {
                int size = k - largeFiles.size();
                for (int i = 0; i < size; i++) {
                    count3++;
                    largeFiles.add(entry.getValue().get(i));
                }
            }
            if (largeFiles.size() == k) break;
        }


        System.out.println("O(n = " + count1 + ") + O(m = " + count2 + " * l = " + count3 + ")");
        System.out.println(map);
        System.out.println(largeFiles);
    }

    public static void unreversedTreeMap(int[] array, int k) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        for (int i = 0; i < array.length; i++) {
            count1++;
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(array[i]);
        }

        Stack<List<Integer>> stack = new Stack<>();

        for (Integer key : map.keySet()) {
            count2++;
            stack.push(map.get(key));
        }

        List<Integer> largeFiles = new ArrayList<>();

        while (largeFiles.size() < k && !stack.isEmpty()) {
            count3++;
            if (stack.peek().size() < k - largeFiles.size()) {
                count4 += stack.peek().size();
                largeFiles.addAll(stack.pop());
            } else {
                int size = k - largeFiles.size();
                count4 += size;
                List<Integer> list = stack.pop();
                for (int i = 0; i < size; i ++) {
                    largeFiles.add(list.get(i));
                }
            }
            System.out.println(largeFiles.size());
        }


        System.out.println("O(n = " + count1 + ") + O(m = " + count2 + ") + O(k = " + count3 + " * l = " + count4 + ")");
        System.out.println(map);
        System.out.println(largeFiles);
    }
}
