/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     11/03/2019
 *  Brownian.java produces a function graph that approximates a simple example of
 *  fractional Brownian motion known as Brownian bridge.
 **************************************************************************** */

public class Brownian {
    public static void curve(double x0, double y0, double x1, double y1,
                             double var, double s) {
        if (Math.abs(x1 - x0) < .01) {
            StdDraw.line(x0, y0, x1, y1);
            return;
        }

        double xm = (x0 + x1) / 2;
        double ym = (y0 + y1) / 2;

        ym += StdRandom.gaussian(0, Math.sqrt(var));

        curve(x0, y0, xm, ym, var / s, s);
        curve(xm, ym, x1, y1, var / s, s);

    }

    public static void main(String[] args) {
        double hurstExponent = Double.parseDouble(args[0]);
        double s = Math.pow(2, 2 * hurstExponent);

        curve(0, .5, 1.0, .5, .01, s);
    }
}
