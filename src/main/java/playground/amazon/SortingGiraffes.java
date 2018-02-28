package playground.amazon;

import java.io.UncheckedIOException;
import java.util.*;

public class SortingGiraffes {

    public static void main(String[] args) {

        SortingGiraffes sortingGirafes = new SortingGiraffes();
//        int[] girafes0 = {1, 2, 4, 5, 3, 7, 8, 6, 9, 10};
//        System.out.println(sortingGirafes.getSortingGroups(girafes0));
//
//        int[] girafes = {1, 3, 4, 8, 5, 2, 9, 7, 10, 11, 12};
//        System.out.println(sortingGirafes.getSortingGroups(girafes));
//
//        int[] girafes2 = {1, 2, 4, 5, 3, 6, 8, 9, 7, 10, 11, 12};
//        System.out.println(sortingGirafes.getSortingGroups(girafes2));

        int[] girafes3 = {1, 3, 5, 2, 4, 6, 8, 9, 7, 10, 11, 13};
//        System.out.println(sortingGirafes.getSortingGroups(girafes3));

        int[] girafes4 = {1, 3, 4, 5, 2, 6, 8, 9, 7, 10, 11, 13};
//        System.out.println(sortingGirafes.getSortingGroups2(girafes4));

        sortingGirafes.getSortingGroups3(girafes3);
        sortingGirafes.getSortingGroups3(girafes4);
    }

    private void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int getSortingGroups(int[] giraffes) {
        printArray(giraffes);

        int n = giraffes.length;
        int groups = 0;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        int max = giraffes[0];
        int pivot = 0;
        int markEndOfGroup = -1;
        boolean abnormality = false;

        for (int i = 0; i < n - 1; i++) {
            if (i > markEndOfGroup) {

                if (giraffes[i + 1] - giraffes[i] == 1) {

                    // normal phase
                    if (!abnormality) {
                        if (!map.containsKey(i)) map.put(i, new ArrayList<>());
                        map.get(i).add(giraffes[i]);
                    } else {
                        if (giraffes[i + 1] > max) max = giraffes[i + 1];
                        if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
                        map.get(pivot).add(giraffes[i + 1]);
                    }

                } else if (giraffes[i + 1] - giraffes[i] > 1) {

                    // abnormal phase
                    if (!abnormality) {
                        if (!map.containsKey(i)) map.put(i, new ArrayList<>());
                        map.get(i).add(giraffes[i]);
                        pivot = i + 1;
                    }
                    if (giraffes[i + 1] > max) max = giraffes[i + 1];
                    abnormality = true;
                    if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
                    map.get(pivot).add(giraffes[i + 1]);

                } else {

                    // looking to terminate the abnormal phase
                    if (giraffes[i + 1] < giraffes[pivot]) {

                        int j = i + 2;
                        while (j < n - 1) {
                            if (giraffes[j] < max) {
                                markEndOfGroup = j;
                                break;
                            } else if (giraffes[j] > max) {
                                max = giraffes[j];
                            }
                            j++;
                        }
                        abnormality = false;
                    } else {
                        if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
                        map.get(pivot).add(giraffes[i + 1]);
                    }
                }
            } else {

                if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
                map.get(pivot).add(giraffes[i]);
                abnormality = false;
            }
        }

        if (giraffes[n - 1] > giraffes[n - 2]) {
            if (!map.containsKey(n - 1)) map.put(n - 1, new ArrayList<>());
            if (!map.get(n - 1).contains(giraffes[n - 1]))
                map.get(n - 1).add(giraffes[n - 1]);
        } else {
            if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
            map.get(pivot).add(giraffes[n - 1]);
        }

        System.out.println(map);


        return map.size();
    }

    private int getSortingGroups2(int[] giraffes) {
        printArray(giraffes);

        int n = giraffes.length;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        int max = giraffes[0];
        int min = -1;
        int previous = giraffes[0];
        int pivot = 0;
        boolean abnormality = false;

        if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
        map.get(pivot).add(previous);

        for (int i = 1; i < n; i++) {
            if (max < giraffes[i]) max = giraffes[i];

            if (previous > giraffes[i]) {
                if (min == -1)
                    min = giraffes[i];
                else if (giraffes[i] < min) min = giraffes[i];

                // this means that the giraffe that we are looking is sorter than the previous

                if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
                map.get(pivot).add(giraffes[i]);

                if ((max != min) && map.get(pivot).size() == (max - min + 1)) {
                    abnormality = false;
                    min = -1;
                }

            } else if (giraffes[i] - previous > 1) {
                System.out.println(map.get(pivot));
                if (min == -1)
                    min = giraffes[i];
                else if (giraffes[i] < min) min = giraffes[i];

                if (!abnormality)
                    pivot = i;

                if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
                map.get(pivot).add(giraffes[i]);

                if ((max != giraffes[pivot]) && map.get(pivot).size() == (max - min + 1)) {
                    abnormality = false;
                    min = -1;
                } else {
                    abnormality = true;
                }
            } else {
                if (!abnormality) {
                    if (!map.containsKey(i)) map.put(i, new ArrayList<>());
                    map.get(i).add(giraffes[i]);
                } else {
                    System.out.println("inserting " + giraffes[i]);
                    if (!map.containsKey(pivot)) map.put(pivot, new ArrayList<>());
                    map.get(pivot).add(giraffes[i]);
                }
            }
            previous = giraffes[i];
        }

        System.out.println(map);
        return map.size();
    }


    private int getSortingGroups3(int[] giraffes) {
        int i = 1;
        int start = giraffes[0];
        while (i < giraffes.length && giraffes[i] > start) {
            start = giraffes[i++];
        }
        System.out.println(giraffes[i] + " at " + i);

        int goBack = giraffes[i];
        int j = i;
        while (j >= 0 && goBack < giraffes[--j]) {

        }
        System.out.println("We found the giraffe " + giraffes[j] + " at " + j);


        return 0;
    }
}
