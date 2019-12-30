/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     11/03/2019
 **************************************************************************** */

public class LongestCommonSubsequence {
    public static String trace(int[][] opt, String s, String t) {
        int m = s.length();
        int n = t.length();

        String lcs = "";
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                lcs += s.charAt(i);
                i++;
                j++;
            }
            else if (opt[i + 1][j] > opt[i][j + 1]) {
                i++;
            }
            else {
                j++;
            }
        }
        return lcs;
    }

    public static String lcs(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] opt = new int[m + 1][n + 1];

        // Method 1.
        // calculate `m * n` times.
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if (s.charAt(i - 1) == t.charAt(j - 1))
        //             opt[i][j] = opt[i - 1][j - 1] + 1;
        //         else
        //             opt[i][j] = Math.max(opt[i - 1][j], opt[i][j - 1]);
        //     }
        // }
        // return opt[m][n];

        // Method 2. Backwards
        // Also calculate `m * n` times.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j))
                    opt[i][j] = opt[i + 1][j + 1] + 1;
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
            }
        }

        return trace(opt, s, t);
    }

    public static void main(String[] args) {
        String lcs = lcs(args[0], args[1]);

        StdOut.println("lcs: " + lcs);
        StdOut.println("lcs length: " + lcs.length());
    }
}
