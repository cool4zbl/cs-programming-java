/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/26/2020
 **************************************************************************** */

public class Clock {
    private int hour;
    private int min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (verify(h, m)) {
            hour = h;
            min = m;
        }
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        String[] a = s.split(":");
        String hourStr = a[0];
        String minStr = a[1];

        if (hourStr.length() != 2 || minStr.length() != 2) {
            throw new IllegalArgumentException();
        }

        int h = Integer.parseInt(hourStr);
        int m = Integer.parseInt(minStr);
        if (verify(h, m)) {
            hour = h;
            min = m;
        }
    }

    private static boolean verify(int h, int m) {
        if (h > 23 || h < 0 || m < 0 || m > 59) {
            throw new IllegalArgumentException("Please check the format of your inputs!");
        }
        return true;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = hour >= 10 ? "" + hour : "0" + hour;
        String m = min >= 10 ? "" + min : "0" + min;
        return h + ":" + m;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hour > that.hour) return false;
        if (this.hour < that.hour) return true;
        return this.min < that.min;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.hour == 23 && this.min == 59) {
            this.hour = 0;
            this.min = 0;
            return;
        }
        if (this.min == 59) {
            this.hour += 1;
            this.min = 0;
            return;
        }
        this.min += 1;
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("Delta cannot be negative");
        int incH = delta / 60;
        int incM = delta % 60;

        this.hour = (this.hour + incH + (this.min + incM) >= 60 ? 1 : 0) % 24;
        this.min = (this.min + incM) % 60;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock a = new Clock(23, 59);
        Clock b = new Clock("22:59");

        StdOut.println(a + " is earlier than " + b + "? " + a.isEarlierThan(b));
        a.tic();
        StdOut.println("a tic: " + a);
        b.toc(131);
        StdOut.println("b toc 121 mins: " + b);
    }
}
