/* *****************************************************************************
 *  Name:              Binliu ZHANG
 *  Coursera User ID:  123456
 *  Last modified:     10/14/2019
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != 0) System.out.print(" ");
                if (Math.abs(j - i) > width) {
                    System.out.print("0");
                }
                else {
                    System.out.print("*");
                }
                if (j != n) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
