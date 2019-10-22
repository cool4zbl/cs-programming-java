/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/20/2019
 **************************************************************************** */

/**
 * Write a program LongestRun.java that reads in a sequence of integers and
 * prints out both the integer that appears in a longest consecutive run and the length of the run.
 * For example, if the input is 1 2 2 1 5 1 1 7 7 7 7 1 1, then your program should print Longest
 * run: 4 consecutive 7s.
 */
public class LongestRun {
    public static void main(String[] args) {
        if (StdIn.isEmpty()) {
            StdOut.println("no longest consecutice run.");
        }

        int prev = StdIn.readInt();
        int count = 1;
        int best = prev;
        int bestCount = count;

        while (!StdIn.isEmpty()) {
            // read in the next value.
            int current = StdIn.readInt();

            // update current run.
            if (current == prev) count++;
            else {
                prev = current;
                count = 1;
            }

            // update champion value.
            if (bestCount < count) {
                best = current;
                bestCount = count;
            }
        }

        StdOut.println(bestCount + " consecutive " + best + "s.");
    }
}
