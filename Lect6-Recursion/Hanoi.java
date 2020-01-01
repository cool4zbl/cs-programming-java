/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Hanoi {
    public static void hanoi(int n, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, temp, from, to);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        hanoi(n, "A", "B", "C");
    }
}
