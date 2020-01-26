/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/26/2020
 **************************************************************************** */

import java.awt.Color;

public class Mandelbrot {
    public static Color mand(Complex z0) {
        Complex z = z0;
        for (int t = 0; t < 255; t++) {
            if (z.abs() > 2.0) return new Color(255 - t, 255 - t, 255 - t);
            z = z.times(z);
            z = z.plus(z0);
        }
        return Color.BLACK;
    }

    public static void main(String[] args) {
        double xc = Double.parseDouble(args[0]);
        double yc = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);
        int n = Integer.parseInt(args[3]);
        Picture pic = new Picture(n, n);

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x0 = xc - size / 2 + size * col / n;
                double y0 = yc - size / 2 + size * row / n;
                Complex z0 = new Complex(x0, y0);
                Color color = mand(z0);
                pic.set(col, n - 1 - row, color);
            }
        }
        pic.show();
    }
}
