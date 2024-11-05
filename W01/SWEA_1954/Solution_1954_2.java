package SWEA_1954;

import java.util.Scanner;

public class Solution_1954_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();

        for (int trys = 0; trys < testcase; trys++) {
            int n = sc.nextInt();
            int[][] snailMap = new int[n][n];
            int snailNum = 1;
            int row = 0;
            int col = 0;
            int direction = 0;//0 : 우  1 : 하 2 : 좌 3: 상
            int[] dr = {0,1,0,-1};
            int[] dc = {1,0,-1,0};

            while (snailNum < (n * n) + 1) {

                snailMap[row][col] = snailNum;
                snailNum++;

                if (direction == 0) {
                    if (!inBoundary(row, col+1, n) || snailMap[row][col + 1] != 0) {
                        direction = 1;
                    }
                } else if (direction == 1) {
                    if (!inBoundary(row+1, col, n) || snailMap[row + 1][col] != 0) {
                        direction = 2;
                    }
                } else if (direction == 2) {
                    if (!inBoundary(row, col-1, n) || snailMap[row][col - 1] != 0) {
                        direction = 3;
                    }
                } else if (direction == 3) {
                    if (!inBoundary(row-1, col, n) || snailMap[row - 1][col] != 0) {
                        direction = 0;
                    }
                }

                row = row + dr[direction];
                col = col + dc[direction];
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

    public static boolean inBoundary(int row, int col, int n){
        return row>=0 && row<n && col >= 0 && col<n;
    }
}