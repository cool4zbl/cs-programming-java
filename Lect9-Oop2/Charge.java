/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/25/2020
 **************************************************************************** */

public class Charge {
    private final double rx;
    private final double ry;
    private final double q;

    public Charge(double x0, double y0, double q0) {
        rx = x0;
        ry = y0;
        q = q0;
    }

    public double potentialAt(double x, double y) {
        double k = 8.99e09;
        double dx = x - rx;
        double dy = x - ry;
        return k * q / Math.sqrt(dx * dx + dy * dy);
    }

    public String toString() {
        return q + " at " + "(" + rx + ", " + ry + ")";
    }

    public static void main(String[] args) {
        Charge c = new Charge(0.72, 0.31, 20.1);
        System.out.println(c);
        System.out.printf("%6.2e\n", c.potentialAt(0.42, 0.71));
    }
}
