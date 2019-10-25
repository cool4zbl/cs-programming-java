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

        StdDraw.enableDoubleBuffering();

        StdDraw.setCanvasSize(width, height);

        while (!StdIn.isEmpty()) {
            int numberOfVertices = StdIn.readInt();
            double[] verticesX = new double[numberOfVertices];
            double[] verticesY = new double[numberOfVertices];

            for (int i = 0; i < numberOfVertices; i++) {
                verticesX[i] = StdIn.readDouble();
                verticesY[i] = StdIn.readDouble();
            }

            StdDraw.polygon(verticesX, verticesY);
        }
        StdDraw.show();
    }
}
