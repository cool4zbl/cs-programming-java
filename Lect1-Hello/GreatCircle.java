/* *****************************************************************************
 *  Name:              Binliu Zhang
 *  Coursera User ID:  57c008f67741bc302f05939083aff283
 *  Last modified:     10/13/2019
 **************************************************************************** */

public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        double s0 = Math.pow(Math.sin((x2 - x1) / 2.0), 2);
        double s1 = Math.pow(Math.sin((y2 - y1) / 2.0), 2) * Math.cos(x1) * Math.cos(x2);
        double sqrt = Math.sqrt(s0 + s1);
        double r = 6371.0;
        double distance = 2.0 * r * Math.asin(sqrt);
        System.out.println(distance + " kilometers");
    }
}
