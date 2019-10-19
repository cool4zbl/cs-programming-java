public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;

        while (Math.abs(x) + Math.abs(y) < r) {
            System.out.println("(" + x + ", " + y + ")");
            double p = Math.random();
            if (p > 0.75) {
                x += 1;
            }
            else if (p > 0.5) {
                x -= 1;
            }
            else if (p > 0.25) {
                y += 1;
            }
            else {
                y -= 1;
            }
            steps++;
        }
        System.out.println("(" + x + ", " + y + ")");
        System.out.println("steps = " + steps);
    }
}
