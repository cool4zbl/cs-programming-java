/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     11/09/2019
 *
 *  Write a program Combinations.java that takes an integer command-line argument n
 *  and prints all 2^n combinations of any size.
 *  A combination is a subset of the n elements, independent of order.
 *  As an example, when n = 3, you should get the following output:
 *  "" a ab abc ac b bc c
 *  Note that your program needs to print the empty string (subset of size 0).
 **************************************************************************** */

public class Combinations {
    public static void comb(String s) {
        comb("", s);
    }

    private static void comb(String prefix, String s) {
        int n = s.length();
        StdOut.println(prefix);
        for (int i = 0; i < n; i++) {
            comb(prefix + s.charAt(i), s.substring(i + 1));
        }
    }

    public static void comb1(String s) {
        comb("", s);
    }

    public static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            StdOut.println(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix, s.substring(1));
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        comb(elements);
        StdOut.println();
        comb1(elements);
    }
}
