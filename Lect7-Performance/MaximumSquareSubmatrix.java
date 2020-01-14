/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/13/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][0] = a[i][0];
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = a[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int max = dp[i - 1][j - 1];
                if (a[i][j] + a[i - max][j] + a[i][j - max] + a[i - 1][j - 1] == 4) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    // dp[i][j] = dp[i - 1][j - 1];
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                StdOut.print(dp[i][j] + " ");
            }
            StdOut.println();
        }

        return dp[n - 1][n - 1];
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int value = StdIn.readInt();
        int[][] a = new int[value + 1][value + 1];

        while (!StdIn.isEmpty()) {
            for (int j = 0; j < value; j++) {
                for (int i = 0; i < value; i++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }

        StdOut.println(size(a));
    }
}
