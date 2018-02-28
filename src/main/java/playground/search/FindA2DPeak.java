package playground.search;

public class FindA2DPeak {

    public static void main(String[] args) {
        int[][] mat = {{01, 02, 05, 06, 10},
                {11, 12, 18, 19, 20},
                {12, 13, 17, 18, 19},
                {23, 20, 19, 20, 20},
                {20, 10, 19, 17, 16}};

        find2DPeak(mat, 0, mat.length, -1);

    }

    private static boolean find2DPeak(int[][] mat, int start, int end, int row) {

        int col;

        if (row >= 0 && end - start == 2) {
            if (mat[row][end-1] > mat[row][start])
                col = end-1;
            else
                col = start;
        }
        else {
            col = (end - start) / 2;
        }



        int max = 0;
        int maxRow = 0;

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > max) {
                max = mat[i][col];
                maxRow = i;
            }
        }

        System.out.println(max + " at " + maxRow);
        System.out.println("Looking at [" + maxRow + "][" + col + "] = " + max);

        if (mat[maxRow][col] < mat[maxRow][col + 1]) return find2DPeak(mat, col + 1, end, maxRow);
        else if (mat[maxRow][col] < mat[maxRow][col - 1]) return find2DPeak(mat, start, col, maxRow);
        else return true;
    }
}
