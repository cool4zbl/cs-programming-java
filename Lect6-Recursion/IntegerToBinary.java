/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 *
 *  Binary representation.
 *  Write a program IntegerToBinary.java that takes a positive integer n (in decimal)
 *  as a command-line argument and prints its binary representation.
 *  Recall, in Binary.java, we used the method of subtracting out powers of 2.
 *  Now, use the following simpler method: repeatedly divide 2 into n and read the remainders backwards.
 *  First, write a while loop to carry out this computation and print the bits in the wrong order.
 *  Then, use recursion to print the bits in the correct order.
 **************************************************************************** */

public class IntegerToBinary {
    public static void convert(int n) {
        if (n == 0) return;
        convert(n / 2);
        StdOut.print(n % 2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        convert(n);
        String reverseString = "";

        while (n > 0) {
            reverseString += n % 2;
            n = n / 2;
        }
        StdOut.println("reverse" + reverseString);
        StdOut.println();

    }
}
