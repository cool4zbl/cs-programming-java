/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Triangle {
    public static void main(String[] args) {
        double t = Math.sqrt(3.0) / 2.0;

        double[] verticesX = { 0.0, 0.5, 1.0 };
        double[] verticesY = { 0.0, t, 0.0 };

        // StdDraw.line(0.0, 0.0, 1.0, 0.0);
        // StdDraw.line(1.0, 0.0, 0.5, t);
        // StdDraw.line(0.5, t, 0.0, 0.0);
        StdDraw.polygon(verticesX, verticesY);
        StdDraw.point(0.5, t / 3.0);

    }
}
