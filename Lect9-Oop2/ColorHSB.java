/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/26/2020
 **************************************************************************** */

public class ColorHSB {
    private final int hue;
    private final int sat;
    private final int bright;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (0 > h || h > 359 || 0 > s || s > 100 || 0 > b || b > 100) {
            throw new IllegalArgumentException("Please check the format of input");
        }
        hue = h;
        sat = s;
        bright = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + hue + ", " + sat + ", " + bright + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return this.bright == 0 || this.sat == 0;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException();
        }
        int h2 = that.hue;
        int s2 = that.sat;
        int b2 = that.bright;

        int h1 = this.hue;
        int s1 = this.sat;
        int b1 = this.bright;

        return Math.min(
                (h1 - h2) * (h1 - h2),
                (360 - Math.abs(h1 - h2)) * (360 - Math.abs(h1 - h2))
        ) + (s1 - s2) * (s1 - s2) + (b1 - b2) * (b1 - b2);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB color = new ColorHSB(h, s, b);

        int minDistance = 360 * 360 + 100 * 100 * 2;
        String closetColorName = "";
        ColorHSB closetColor = color;

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();
            ColorHSB curColor = new ColorHSB(h2, s2, b2);

            int distance = color.distanceSquaredTo(curColor);
            if (distance < minDistance) {
                minDistance = distance;
                closetColorName = name;
                closetColor = curColor;
            }
        }
        StdOut.println(closetColorName + " " + closetColor);
    }
}
