/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/27/2020
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        // StdAudio.loop("soundtrackA.wav");

        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String filename = args[0];
        int k = Integer.parseInt(args[1]);

        In in = new In(filename);

        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        in.readLine(); // blank line

        BarChart chart = new BarChart(title, xAxis, source);
        while (in.hasNextLine()) {
            int nums = Integer.parseInt(in.readLine());

            Bar[] bars = new Bar[nums];
            String caption = "";

            for (int i = 0; i < nums; i++) {
                String temp = in.readLine();
                String[] a = temp.split(",");
                // { Year/Date, name, country, value, category }
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

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(1);
            chart.reset();

            in.readLine(); // blank line
        }
        chart.reset();
    }
}
