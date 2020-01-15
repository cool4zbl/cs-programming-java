/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/12/2019
 **************************************************************************** */

/**
 * Inversions 倒置.
 */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        long MAX_COUNT = (n / 2) * (n - 1);

        if (k > MAX_COUNT) {
            throw new IllegalArgumentException();
        }

        int[] a = new int[n];

        if (k == 0) {
            for (int i = 0; i < n; i++) {
                a[i] = i;
            }
            return a;
        }

        if (k == MAX_COUNT) {
            for (int i = 0; i < n; i++) {
                a[i] = n - 1 - i;
            }
            return a;
        }

        /**
         * Greedy Approach.
         */
        int pos = n - 1;
        int start = 0;
        int end = n - 1;
        while (start != end) {
            // StdOut.println("pos " + pos + ", k: " + k);
            if (k >= pos) {
                a[start] = pos;
                k = k - pos;
                start++;
            }
            else {
                a[end] = pos;
                end--;
            }
            pos--;
        }

        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[] a = generate(n, k);

        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        // StdOut.println();
        // StdOut.println(count(a));
    }

}
