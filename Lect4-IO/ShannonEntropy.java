/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/22/2019
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        double[] a = new double[m + 1];
        int count = 0;

        double[] p = new double[m + 1];
        double entropy = 0.0;

        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            a[value] += 1;
            count += 1;
        }

        for (int i = 1; i <= m; i++) {
            if (a[i] == 0) {
                p[i] = 0;
            }
            else {
                p[i] = -(a[i] / count * (Math.log(a[i] / count) / Math.log(2)));
            }
            entropy += p[i];
        }
        StdOut.printf("%.4f", entropy);
    }
}
