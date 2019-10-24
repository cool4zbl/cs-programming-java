/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/22/2019
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] x = new double[N + 1];
        double[] y = new double[N + 1];

        double scale = 100;
        StdDraw.setScale(0, scale);

        for (int i = 0; i <= N; i++) {
            x[i] = scale * i / N;
            y[i] = scale * i / N;
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (j % 2 == 0 && i % 2 != 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdOut.println(i + " " + x[i] + ", " + y[j]);
                StdDraw.filledSquare(x[i], y[j], scale / N * 0.5);
            }
        }

    }
}
