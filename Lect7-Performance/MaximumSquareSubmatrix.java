/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/14/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.

    /**
     * 第1种，dp 矩阵为 (n+1) * (n+1), 第一行 & 列为 base cases.
     */
    public static int size3(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];
        int maxLen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxLen = Math.max(dp[i][j], maxLen);
                }
            }
        }

        printMatrix(dp);
        return maxLen;
    }

    /**
     * 第二种，dp 矩阵为 n * n
     */
    public static int size2(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = a[i][0];
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = a[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        printMatrix(dp);
        return maxLen;
    }

    /**
     * DP 优化，使用一维数组
     *
     * @param a 矩阵
     * @return maxLen
     */
    public static int size(int[][] a) {
        int n = a.length;
        int[] dp = new int[n + 1];
        int maxLen = 0;
        int prev = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (a[i - 1][j - 1] == 1) {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxLen = Math.max(dp[j], maxLen);
                }
                else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }

        return maxLen;
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                StdOut.print(matrix[i][j] + " ");
            }
            StdOut.println();
        }
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int value = StdIn.readInt();
        int[][] a = new int[value][value];

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
