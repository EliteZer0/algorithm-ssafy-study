package SWEA_1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767 {
    static int T, N, minWireLength, maxCore;
    static int[][] cell;
    static List<Core> coreList;

    static class Core {
        int row, col;

        public Core(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            cell = new int[N][N];
            coreList = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    cell[i][j] = input;
                    if (input == 1 && !isConnected(i, j)) {
                        coreList.add(new Core(i, j));
                    }
                }
            }

            minWireLength = Integer.MAX_VALUE;
            maxCore = 0;
            dfs(0, 0, 0);

            sb.append("#").append(tc).append(" ").append(minWireLength);
            System.out.println(sb.toString());
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int idx, int coreCnt, int wireCnt) {
        if (idx == coreList.size()) {
            if (coreCnt > maxCore) {
                maxCore = coreCnt;
                minWireLength = wireCnt;
            }
            else if (coreCnt == maxCore) {
                minWireLength = Math.min(wireCnt, minWireLength);
            }
            return;
        }

        int row = coreList.get(idx).row;
        int col = coreList.get(idx).col;

        for (int d = 0; d < 4; d++) {
            if (canConnect(row, col, d)) {
                int wireLength = connectWire(row, col, d, true);
                dfs(idx + 1, coreCnt + 1, wireCnt + wireLength);
                connectWire(row, col, d, false); // 백트래킹: 배선을 해제
            }
        }
        dfs(idx + 1, coreCnt, wireCnt);
    }

    static int connectWire(int row, int col, int d, boolean isConnect) {
        int curRow = row;
        int curCol = col;
        int count = 0;

        while (true) {
            int moveRow = curRow + dr[d];
            int moveCol = curCol + dc[d];

            if (!check(moveRow, moveCol)) break;

            if (isConnect) {
                cell[moveRow][moveCol] = 1;
            } else {
                cell[moveRow][moveCol] = 0;
            }

            curRow = moveRow;
            curCol = moveCol;
            count++;
        }
        return count;
    }

    static boolean canConnect(int row, int col, int dir) {
        int curRow = row;
        int curCol = col;

        while (true) {
            int moveRow = curRow + dr[dir];
            int moveCol = curCol + dc[dir];

            if (!check(moveRow, moveCol)) return true;
            if (cell[moveRow][moveCol] == 1) return false;

            curRow = moveRow;
            curCol = moveCol;
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static boolean isConnected(int r, int c) {
        return r == 0 || r == N - 1 || c == 0 || c == N - 1;
    }
}