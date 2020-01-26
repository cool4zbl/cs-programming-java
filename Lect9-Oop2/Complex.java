/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/26/2020
 **************************************************************************** */

public class Complex {
    private final double re;
    private final double im;

    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    public Complex plus(Complex b) {
        double real = this.re + b.re;
        double imag = this.im + b.im;
        return new Complex(real, imag);
    }

    public Complex times(Complex b) {
        double real = this.re * b.re - this.im * b.im;
        double imag = this.re * b.im + this.im * b.re;
        return new Complex(real, imag);
    }

    public double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public String toString() {
        return re + " + " + im + "i";
    }

    public static void main(String[] args) {
        Complex a = new Complex(3.0, 4.0);
        Complex b = new Complex(-2.0, 3.0);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("a * b = " + a.times(b));

    }
}
