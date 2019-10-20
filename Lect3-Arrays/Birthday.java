/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/18/2019
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int i = 1;
        double count = 0.0;
        double fraction = 0;
        int[] eachCount = new int[n + 2];

        while (fraction < 0.50 && i <= n) {

            for (int j = 0; j < trials; j++) {
                int found = 0;
                int enterPerson = 1;

                boolean[] birthArr = new boolean[n];

                while (enterPerson < i + 1) {
                    int enterPersonBirth = (int) (Math.random() * n);

                    if (birthArr[enterPersonBirth] && enterPerson == i) {
                        found++;
                    }
                    else {
                        birthArr[enterPersonBirth] = true;
                    }
                    enterPerson++;
                    // System.out.println("enterPerson " + enterPerson);
                }
                eachCount[i] += found;
                count += found;
                fraction = count / trials > 1 ? 1.0 : count / trials;
            }
            System.out.println(i + "\t" + eachCount[i] + "\t" + fraction);
            i++;
        }

    }
}
