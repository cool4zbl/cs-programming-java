/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/29/2020
 **************************************************************************** */

/**
 * Write a function windowPosSum(int[] a, int n)
 * that replaces each element a[i] with the sum of a[i] through a[i + n],
 * but only if a[i] is positive valued.
 * If there are not enough values because we reach the end of the array, we sum only as many values
 * as we have.
 */

public class WindowPosSum {
    public static void windowPosSum(int[] a, int n) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            /* use `continue` to skip negative values. */
            if (a[i] <= 0) continue;
            // for (int j = i + 1; j < Math.min(i + n + 1, len); j++) {
            for (int j = i + 1; j < i + n + 1; j++) {
                /* use `break` to avoid going over end of the array. */
                if (j == len) break;
                a[i] += a[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, -3, 4, 5, 4 };
        int[] b = { 1, -1, -1, 10, 5, -1 };

        int n = 3;
        windowPosSum(a, n);
        windowPosSum(b, 2);

        // Should print 4, 8, -3, 13, 9, 4
        System.out.println(java.util.Arrays.toString(a));
        System.out.println(java.util.Arrays.toString(b));
    }
}
