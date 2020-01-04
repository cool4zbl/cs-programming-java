/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/4/2020
 **************************************************************************** */

/**
 * Array rotation.
 * Given an array of n elements, give a linear-time algorithm to rotate the array k positions.
 * That is, if the array contains a[0], a[1], …, a[n–1] ,
 * the rotated array is a[k], a[k+1], …, a[n–1], a[0], …, a[k–1].
 * Use at most a constant amount of extra memory. Hint : Reverse three subarrays.
 */

public class Rotate {
    public static void reverse(int[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] a, int k) {
        int n = a.length;
        k %= n;

        reverse(a, 0, n - 1);
        reverse(a, 0, n - 1 - k);
        reverse(a, n - k, n - 1);

    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int v = StdIn.readInt();
            a[i] = v;
        }

        rotate(a, k);

        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
