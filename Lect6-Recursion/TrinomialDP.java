/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class TrinomialDP {
    public static long trinomial(int n, int k) {
        long[][] tri = new long[n + 2][k + 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0 && i == 0) {
                    tri[i][j] = 1;
                }
                else if (j > i) tri[i][j] = 0;
                else tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j] + tri[i - 1][j + 1];
            }
        }
        return tri[0][0];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}
