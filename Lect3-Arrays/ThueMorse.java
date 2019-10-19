/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/17/2019
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (n <= 0) return;

        int powerOf2 = n;
        // if n is odd.
        if ((n & n - 1) != 0) {
            powerOf2 = (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)));
        }
        boolean[] morseSequence = new boolean[powerOf2];
        morseSequence[0] = false;

        int indicator = 1;

        while (indicator < powerOf2) {
            for (int i = 0; i < indicator; i++) {
                morseSequence[indicator + i] = !morseSequence[i];
            }
            indicator *= 2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((j == 0 ? "" : " ")
                                         + (morseSequence[i] == morseSequence[j] ? "+" : "-")
                                         + (j == n - 1 ? "" : " "));
            }
            System.out.println();
        }

    }
}
