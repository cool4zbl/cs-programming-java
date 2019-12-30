/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     11/09/2019
 *
 *  Write a program Permutations.java that take an integer command-line argument n and
 *  prints all n! permutations of the n letters starting at a (assume that n is no greater than 26).
 *  A permutation of n elements is one of the n! possible orderings of the elements.
 *  As an example, when n = 3 you should get the following output (but do not worry about the order in which you enumerate them):
 *  bca cba cab acb bac abc
 **************************************************************************** */

public class Permutations {
    // print n! permutation of the characters of the string s (in order)
    public static void perm1(String s) {
        perm1("", s);
    }

    private static void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            StdOut.println(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
            perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
        }
    }

    // print n! permutation of the characters of the string s (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i);
        }
        perm2(a, n);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            StdOut.println(new String(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            perm2(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    private static char[] swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String elements = alphabet.substring(0, n);
        perm1(elements);
        perm2(elements);
    }
}
