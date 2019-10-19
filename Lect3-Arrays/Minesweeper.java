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

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (!hasMine[i][j]) {
                    int mines = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            if (hasMine[k][l]) {
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
