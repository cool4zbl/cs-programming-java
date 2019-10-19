/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/18/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int minesNum = Integer.parseInt(args[2]);
        int k = minesNum;

        boolean[][] hasMine = new boolean[m][n];
        int[][] neighboringMines = new int[m][n];

        while (k > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int r = (int) (Math.random() * m * n);
                    if (r < minesNum) {
                        hasMine[i][j] = true;
                        k--;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (hasMine[i][j]) {
                    if (i == 0 && j > 0) {
                        a[i][j - 1] += 1;
                        a[i][j + 1] += 1;
                        a[i + 1][j + 1] += 1;
                        a[i + 1][j - 1] += 1;
                    }
                    if (j == 0 &&)
                }

            }
        }

    }
}
