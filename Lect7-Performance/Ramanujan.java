/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/13/2019
 **************************************************************************** */

public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long f = (long) Math.floor(Math.cbrt(n));
        int count = 0;
        boolean passed = false;

        for (long i = 1; i <= f; i += 2) {
            long b = (long) Math.floor(Math.cbrt(n - i * i * i));

            long c = i + 1;
            long d = (long) Math.floor(Math.cbrt(n - c * c * c));

            if (b > i && ((b * b * b) + (i * i * i)) == n) {
                // StdOut.println("a " + i + ", b " + b);
                count++;
            }
            if (d > c && ((c * c * c) + (d * d * d)) == n) {
                // StdOut.println("c " + c + ", d " + d);
                count++;
            }

            passed = count == 2;

            if (passed) break;
        }

        return passed;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        StdOut.println(isRamanujan(n));
    }
}
