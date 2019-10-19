/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     10/18/2019
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int minesNum = Integer.parseInt(args[2]);
        int totalMines = minesNum;

        boolean[][] hasMine = new boolean[m + 2][n + 2];
        int[][] neighboringMines = new int[m + 2][n + 2];

        // Place the mines 0.
        // TODO: whether it is good?
        /*
        while (totalMines > 0) {
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    int r = (int) (Math.random() * m * n);
                    if (r < minesNum) {
                        hasMine[i][j] = true;
                        totalMines--;
                    }
                }
            }
        }
         */

        // Place the mines 3.
        while (totalMines > 0) {
            int rx = 1 + (int) (Math.random() * m);
            int ry = 1 + (int) (Math.random() * n);
            if (!hasMine[rx][ry]) {
                hasMine[rx][ry] = true;
                totalMines--;
            }
        }

        // Place the mines 1.
        /*
        while (totalMines > 0) {
            int r = (int) (Math.random() * m * n);
            int count = 0;
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (count == r && !hasMine[i][j]) {
                        hasMine[i][j] = true;
                        totalMines--;
                    }
                    count++;
                }
            }
        }

         */

        // Place the mines 2.
        /*
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (totalMines > 0 && !hasMine[i][j]) {
                    hasMine[i][j] = true;
                    totalMines--;
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int rx = i + (int) (Math.random() * (m - i));
                int ry = j + (int) (Math.random() * (n - j));

                boolean b = hasMine[rx][ry];
                hasMine[rx][ry] = hasMine[i][j];
                hasMine[i][j] = b;
            }
        }
         */

        // Calculate the neiboring mines.
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!hasMine[i][j]) {
                    int mines = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int p = j - 1; p <= j + 1; p++) {
                            if (hasMine[k][p]) {
                                mines++;
                            }
                        }
                    }
                    neighboringMines[i][j] = mines;
                }
                else {
                    neighboringMines[i][j] = -1;
                }
            }
        }

        // Print the Minesweeper.
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (neighboringMines[i][j] < 0) {
                    System.out.print((j == 1 ? "" : " ") + "*" + (j == n ? "" : " "));
                }
                else {
                    System.out.print((j == 1 ? "" : " ") + neighboringMines[i][j] + (j == n ? "" :
                                                                                     " "));
                }
            }
            System.out.println();
        }

    }
}
