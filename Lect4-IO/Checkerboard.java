/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/25/2019
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] verticesX = new double[n];
        double[] verticesY = new double[n];

        double scale = n;
        StdDraw.setScale(0, n);

        double r = scale / (2 * n);

        for (int i = 0; i < n; i++) {
            verticesX[i] = scale * i / n + r;
            verticesY[i] = scale * i / n + r;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || Math.abs(i - j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                StdDraw.filledSquare(verticesX[i], verticesY[j], r);
            }
        }
    }
}
