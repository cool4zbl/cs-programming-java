/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/27/2019
 **************************************************************************** */

public class ActivationFunction {
    // Returns the Heaviside funciton of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x < 0) return 0;
        if (x == 0) return 0.5;
        return 1;
    }

    // Returns the sigmoid funciton of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        double r = 1 / (1 + Math.exp(-1 * x));
        return r;
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return (Math.exp(x) - Math.exp(-1 * x)) / (Math.exp(x) + Math.exp(-1 * x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x <= -2) return -1;
        if (x > -2 && x < 0) return x + x * x / 4;
        if (x >= 0 && x < 2) return x - x * x / 4;
        return 1;
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        StdOut.print("heaviside(" + x + ")\t = \t" + heaviside(x) + "\n");
        StdOut.print("sigmoid(" + x + ")\t = \t" + sigmoid(x) + "\n");
        StdOut.print("tanh(" + x + ")\t = \t" + tanh(x) + "\n");
        StdOut.print("softsign(" + x + ")\t = \t" + softsign(x) + "\n");
        StdOut.print("sqnl(" + x + ")\t = \t" + sqnl(x) + "\n");

    }
}
