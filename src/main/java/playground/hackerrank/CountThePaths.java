package playground.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    In a labyrinth one starts from the upper left corner
    and moves to the exit of the labyrinth at the bottom right corner.
    The moves allowed in the labyrinth are from left to right and
    from top to bottom.

    For a given nxn matrix that represents the labyrinth, count all the necessary moves
    that a person can make to reach the exit.
 */
public class CountThePaths {
    private int size = 8;
    private char[][] matrix = new char[size][size];
    private Map<String, Integer> paths = new HashMap<>();


    public CountThePaths() {
        for (int i = 0; i < size; i++)
            Arrays.fill(matrix[i], '\0');

        initializeMatrix();
    }

    private void initializeMatrix() {
        matrix[1][2] = '*';
        matrix[1][6] = '*';
        matrix[2][4] = '*';
        matrix[3][0] = '*';
        matrix[3][2] = '*';
        matrix[3][5] = '*';
        matrix[4][2] = '*';
        matrix[5][3] = '*';
        matrix[5][4] = '*';
        matrix[5][6] = '*';
        matrix[6][1] = '*';
        matrix[6][5] = '*';
    }

    private int calculatePaths(int row, int col) {
        if (matrix[row][col] == '*') return 0;
        if (paths.containsKey(row + ":" + col)) return paths.get(row + ":" + col);

        int count = 0;
        for (int i = size - 1; i >= row; i--) {
            for (int j = size - 1; j >= col; j--) {

                if ((i == size - 1) && (j == size - 1)) paths.put(i + ":" + j, 1);
                else {
                    if ((j + 1 == size) && (i + 1 < size)) {
                        count = calculatePaths(i + 1, j);
                    } else if ((i + 1 == size) && (j + 1 < size)) {
                        count = calculatePaths(i, j + 1);
                    } else {
                        count = calculatePaths(i + 1, j) + calculatePaths(i, j + 1);
                    }
                }
            }
        }

        paths.put(row + ":" + col, count);
        return count;
    }

    public int getSize() {
        return size;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public static void main(String[] args) {
        CountThePaths countThePaths = new CountThePaths();

        System.out.println(countThePaths.calculatePaths(7, 1));
        System.out.println(countThePaths.calculatePaths(1, 7));
        System.out.println(countThePaths.calculatePaths(6, 6));
        System.out.println(countThePaths.calculatePaths(5, 5));
        System.out.println(countThePaths.calculatePaths(0, 1));
        System.out.println(countThePaths.calculatePaths(1, 0));
        System.out.println(countThePaths.calculatePaths(5, 0));
    }


}
