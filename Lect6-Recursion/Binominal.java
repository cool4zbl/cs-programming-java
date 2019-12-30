/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Binominal {
    public static long binomial(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];

        // base case
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        for (int j = 1; j <= k; j++) dp[0][j] = 0;

        // bottom-up dynamic programming
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++)
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];

        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(binomial(n, k));
    }
}
