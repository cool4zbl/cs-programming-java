/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Binary {
    public static String convert(int N) {
        if (N == 1) return "1";
        return convert(N / 2) + N % 2;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        System.out.println(convert(N));
    }
}
