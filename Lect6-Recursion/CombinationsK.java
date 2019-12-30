/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class CombinationsK {
    public static void comb(String s, int k) {
        comb("", s, k);
    }

    public static void comb(String prefix, String s, int k) {
        int n = s.length();
        if (prefix.length() == k) {
            StdOut.println(prefix);
            return;
        }

        for (int i = 0; i < n; i++) {
            comb(prefix + s.charAt(i), s.substring(i + 1), k);
        }
    }

    public static void comb2(String s, int k) {
        comb2("", s, k);
    }

    public static void comb2(String prefix, String s, int k) {
        if (k == 0) {
            StdOut.println(prefix);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            comb2(prefix + s.charAt(i), s.substring(i + 1), k - 1);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);

        comb(elements, k);
        StdOut.println("===");
        comb2(elements, k);
    }
}
