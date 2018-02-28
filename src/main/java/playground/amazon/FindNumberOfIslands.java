package playground.amazon;

import java.util.*;

public class FindNumberOfIslands {

    public static void main(String[] args) {
        int[][] mat =  {{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}};


        System.out.println(findIslands(mat));
    }


    // A function to check if a given cell (row, col) can
    // be included in DFS
    private static boolean isSafe(int[][] mat, int row, int col, boolean[][] visited) {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return row > 0 && col > 0
                && row < mat.length && col < mat.length
                && !visited[row][col]
                && mat[row][col] == 1;
    }

    private static void dfs(int[][] mat, int row, int col, boolean[][] visited) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell

        int[] rowNbr = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] colNbr = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
//            System.out.println("for " + row + ":" + col + ", checking " + (row + rowNbr[i]) + ":" + (col + colNbr[i]));

            if (isSafe(mat, row + rowNbr[i], col + colNbr[i], visited)) {
//                System.out.println("double for " + row + ":" + col + ", checking " + (row + rowNbr[i]) + ":" + (col + colNbr[i]));
                dfs(mat, row + rowNbr[i], col + colNbr[i], visited);
            }
        }
    }

    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    private static int findIslands(int[][] mat) {
        boolean[][] visited = new boolean[mat.length][mat.length];
        int count = 0;
        for (int i=0; i < mat.length; i++) {
            for (int j=0; j < mat.length; j++) {
                // If a cell with value 1 is not
                // visited yet, then new island found, Visit all
                // cells in this island and increment island count
                if (mat[i][j] == 1  && !visited[i][j]) {
                    dfs(mat, i, j, visited);
//                    System.out.println(i + " : " + j);
                    count++;
                }
            }
        }

        return count;
    }
}
