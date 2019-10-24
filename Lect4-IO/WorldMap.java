/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/24/2019
 **************************************************************************** */

public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        StdOut.println("width: " + width + ", height: " + height);

        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int numberOfVertices = StdIn.readInt();
            double[] verticesX = new double[numberOfVertices];
            double[] verticesY = new double[numberOfVertices];

            for (int i = 0; i < numberOfVertices; i++) {
                verticesX[i] = StdIn.readDouble();
                verticesY[i] = StdIn.readDouble();
            }
            // for (int i = 0; i < verticesX.length; i++) {
            //     StdOut.println("vertices: " + verticesX[i]);
            // }

            // double[] verticesX = { 100.0, 500.0, 300.0 };
            // double[] verticesY = { 100.0, 100.0, 500.0 };

            StdDraw.polygon(verticesX, verticesY);
        }
        // double[] verticesX = { 1.0, 5.0, 3.0 };
        // double[] verticesY = { 1.0, 1.0, 5.0 };
        // StdDraw.polygon(verticesX, verticesY);

    }
}
