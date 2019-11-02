/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     11/02/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int i = 1;
        double fraction = 0;
        double[] peopleCount = new double[n + 2];

        while (fraction < 0.50 && i <= n) {
            for (int j = 0; j < trials; j++) {
                int found = 0;
                boolean[] birthArr = new boolean[n];
                int enterPeople = 1;

                while (enterPeople < i) {
                    int birthday = (int) (Math.random() * n);
                    if (birthArr[birthday]) {
                        found++;
                    }
                    else {
                        birthArr[birthday] = true;
                    }
                    enterPeople++;
                }

                peopleCount[i] += found;
                fraction = peopleCount[i] / trials > 1 ? 1.0 : peopleCount[i] / trials;
            }
            System.out.println(i + "\t" + peopleCount[i] + "\t" + fraction);
            i++;
        }

    }
}
