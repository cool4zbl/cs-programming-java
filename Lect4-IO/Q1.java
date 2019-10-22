/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/21/2019
 **************************************************************************** */
/*
    前两位的累加器
 */

public class Q1 {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            if (!StdIn.isEmpty()) x += StdIn.readInt();
            StdOut.print(x + " ");
        }
        StdOut.println();
    }
}
