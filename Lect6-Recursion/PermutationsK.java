/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     11/09/2019
 *
 *  Write a program PermutationsK.java that two command-line arguments n and k,
 *  and prints out all P(n,k)=n!(n−k)! permutations that contain exactly k of the n elements.
 *  Below is the desired output when k = 2 and n = 4 (again, do not worry about the order):
 *  ab ac ad ba bc bd ca cb cd da db dc
 **************************************************************************** */

public class PermutationsK {
    public static void permK(String s, int k) {
        permK("", s, k);
    }

    public static void permK(String prefix, String s, int k) {
        if (prefix.length() == k) {
            StdOut.println(prefix);
            return;
        }
        int n = s.length();
        for (int i = 0; i < n; i++) {
            String p = prefix + s.charAt(i);
            String t = (s.substring(0, i) + s.substring(i + 1, n));
            permK(p, t, k);
        }
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        permK(elements, k);
    }
}
