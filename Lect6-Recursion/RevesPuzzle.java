/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2020
 **************************************************************************** */

/**
 * Let k denote the integer nearest to n+1− Math.sqrt(2n+1).
 * Transfer (recursively) the k smallest discs to a single pole other than the start or destination
 * poles.
 * Transfer the remaining n−k disks to the destination pole (without using the pole that now
 * contains the smallest k discs).
 * To do so, use the algorithm for the 3-pole towers of Hanoi problem.
 * Transfer (recursively) the k smallest discs to the destination pole.
 */

// *  Move disc 1 from A to C
public class RevesPuzzle {
    private static void revers(int n, String from, String temp1, String temp2, String to) {
        if (n == 0) return;
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        revers(k, from, to, temp2, temp1);
        hanoi(n, k, from, temp2, to);
        revers(k, temp1, from, temp2, to);
    }

    private static void hanoi(int n, int k, String from, String temp, String to) {
        if (n == k) return;
        hanoi(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        revers(n, "A", "B", "C", "D");
    }
}
