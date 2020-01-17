/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/17/2020
 **************************************************************************** */

// use `Math.floorMod(x, y)`
// Math.floorMod(-1, 3) = 2;
// Math.floorMod(1, 3) = 1;
// Math.floorMod(3, 3) = 0;

import java.awt.Color;

public class KernelFilter {

    private static int format(double v) {
        if (v < 0) return 0;
        if (v > 255) return 255;
        return (int) Math.round(v);
    }

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        Picture target = new Picture(picture);

        for (int tcol = 0; tcol < picture.width(); tcol++) {
            for (int trow = 0; trow < picture.height(); trow++) {
                double sumR = 0;
                double sumG = 0;
                double sumB = 0;
                int wLen = weights.length;
                int center = wLen / 2;

                // 按矩阵的顺序，遍历
                for (int i = 0; i < wLen; i++) {
                    for (int j = 0; j < wLen; j++) {
                        // 求得当前像素点的系数.
                        double coefficient = weights[i][j];

                        // Periodic pixels & their colors.
                        int scol = Math.floorMod(tcol - center + i, picture.width());
                        int srow = Math.floorMod(trow - center + j, picture.height());

                        Color color = picture.get(scol, srow);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        sumR += r * coefficient;
                        sumG += g * coefficient;
                        sumB += b * coefficient;
                    }
                }

                Color c = new Color(format(sumR), format(sumG), format(sumB));
                target.set(tcol, trow, c);
            }
        }
        return target;
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                { (double) 2 / 16, (double) 4 / 16, (double) 2 / 16 },
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                };

        return kernel(picture, weights);
    }

    public static Picture identity(Picture picture) {
        double[][] weights = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = {
                { (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9 },
                };

        return kernel(picture, weights);
    }

    // Test client (ungraded).
    public static void main(String[] args) {

        String filename = args[0];
        Picture source = new Picture(filename);
        Picture g = gaussian(source);
        Picture s = sharpen(source);
        Picture i = identity(source);
        Picture lp = laplacian(source);
        Picture e = emboss(source);
        Picture m = motionBlur(source);

        s.show();
        i.show();
        g.show();
        lp.show();
        e.show();
        m.show();

    }
}
