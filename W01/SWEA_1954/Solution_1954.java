package SWEA_1954;

import java.util.Scanner;

public class Solution_1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for (int trys = 0; trys < testcase; trys++) {
            int n = sc.nextInt();
            int[][] snailMap = new int[n][n];
            int snailNum = 1;
            int row = 0;
            int col = 0;
            int direction = 0;

            while (snailNum < (n * n) + 1) {

                snailMap[row][col] = snailNum;
                snailNum++;

                if (direction == 0) {
                    if (col + 1 < n && snailMap[row][col + 1] == 0) {
                        col++;
                    } else {
                        direction = 1;
                        row++;
                    }
                } else if (direction == 1) {
                    if (row + 1 < n && snailMap[row + 1][col] == 0) {
                        row++;
                    } else {
                        direction = 2;
                        col--;
                    }
                } else if (direction == 2) {
                    if (col > 0 && snailMap[row][col - 1] == 0) {
                        col--;
                    } else {
                        direction = 3;
                        row--;
                    }
                } else if (direction == 3) {
                    if (row > 0 && snailMap[row - 1][col] == 0) {
                        row--;
                    } else {
                        direction = 0;
                        col++;
                    }
                }
            }
            System.out.printf("#%d\n", (trys + 1));
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", snailMap[i][j]);
                }
                System.out.println();
            }
        }
    }
}