/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/22/2019
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StdDraw.setScale(0, n);

        double[] x = new double[n + 1];
        double[] y = new double[n + 1];

        for (int i = 0; i < n; i++) {
            x[i] = i;
            y[i] = i;

            if (i % 2 == 0) {
                StdDraw.setPenColor(StdDraw.BLUE);
            }
            else {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            }
            StdDraw.filledSquare(x[i], y[i], 1 / 2);
        }

    }
}
