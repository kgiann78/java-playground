package playground;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AhoCorasick {

    final int MAXS = 500;
    final int MAXC = 26;

    int[][] g = new int[MAXS][MAXC];
    int[] out = new int[MAXS];
    int[] failure = new int[MAXS];

    public static void main(String[] args) {
        AhoCorasick ahoCorasick = new AhoCorasick();

        String[] array = {"a", "ab", "acaa", "caa", "abc"};
        ahoCorasick.buildMatchingMachine(array, array.length);

        for (int i =0; i < ahoCorasick.g.length; i++){
            for (int j = 0; j < ahoCorasick.g[i].length; j++) {
                if (ahoCorasick.g[i][j] != -1)
                    System.out.print(ahoCorasick.g[i][j] + " ");
            }
        }
    }

    public void buildMatchingMachine(String[] array, int k) {
        int states = 1;
        for (int i=0; i < g.length; i++) {
            Arrays.fill(g[i], -1);
        }

        for (int i=0; i < k; i++) {
            String word = array[i];
            int currentState = 0;

            for (String letter : word.split("")) {
                int ch = letter.toCharArray()[0] - 'a';

                // Allocate a new node (create a new state) if a
                // node for ch doesn't exist.
                if (g[currentState][ch] == -1)
                    g[currentState][ch] = states++;

                currentState = g[currentState][ch];
            }

            // Add current word in output function
            out[currentState] |= (1 << i);
        }

        // For all characters which don't have an edge from
        // root (or state 0) in Trie, add a goto edge to state
        // 0 itself
        for (int ch = 0; ch < MAXC; ++ch)
            if (g[0][ch] == -1)
                g[0][ch] = 0;

        // Now, let's build the failure function
        // Initialize values in fail function
        Arrays.fill(failure, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int ch = 0; ch < MAXC; ++ch) {
            if (g[0][ch] != 0) {
                failure[g[0][ch]] = 0;
                q.add(g[0][ch]);
            }
        }


    }

}
