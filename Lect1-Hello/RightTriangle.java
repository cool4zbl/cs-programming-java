public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        /*
        int max = Math.max(a, b);
        int mid = a + b - max;
        int min;
        if (max < c) {
            min = mid;
            mid = max;
            max = c;
        }
        else {
            min = Math.min(mid, c);
            mid = mid + c - min;
        }
         */

        boolean r = a * a + b * b == c * c
                || a * a + c * c == b * b
                || b * b + c * c == a * a;

        System.out.println(a > 0 && b > 0 && c > 0 && r);
    }
}
