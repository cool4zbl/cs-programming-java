/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/27/2020
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // StdAudio.loop("soundtrackA.wav");

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In in = new In(filename);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();

        while (in.hasNextLine()) {
            BarChart chart = new BarChart(title, xAxis, source);

            in.readLine(); // blank line
            int nums = Integer.parseInt(in.readLine());

            Bar[] bars = new Bar[nums];
            String caption = "";

            for (int i = 0; i < nums; i++) {
                String temp = in.readLine();
                String[] a = temp.split(",");
                // { Year/Date, name, country, value, category }
                // chart.add("Tokyo",       38194, "East Asia");
                bars[i] = new Bar(a[1], Integer.parseInt(a[3]), a[4]);
                caption = a[0];
            }
            Arrays.sort(bars);

            // DEBUG
            // for (int i = 0; i < bars.length; i++) {
            //     StdOut.print(bars[i].getName() + " - " + bars[i].getValue());
            //     StdOut.println();
            // }
            // DEBUG

            chart.setCaption(caption);
            for (int i = bars.length - 1; i > bars.length - 1 - k; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            StdDraw.setCanvasSize(1000, 700);
            StdDraw.enableDoubleBuffering();

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(300);
            chart.reset();
        }
    }
}
