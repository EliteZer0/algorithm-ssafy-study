package BOJ_16197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//디버깅 실패.
public class Main_16197 {
	static int row, col, btnCnt, minBtnCnt;
	static char[][] board;
	static boolean[][] visited1, visited2;
	static Queue<int[]> coinState;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		board = new char[row][col];
		visited1 = new boolean[row][col];
		visited2 = new boolean[row][col];
		coinState = new LinkedList<>();
		int[] coin1 = null; 
		int[] coin2 = null;
		
		for (int i = 0; i < row; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				if(board[i][j] == 'o') {
					if(coin1 == null) {
						coin1 = new int[] {i, j};
						visited1[i][j] = true;
					}else {
						coin2 = new int[] {i, j};
						visited2[i][j] = true;
					}
				}
			}
//			System.out.println(board[i]);
		}
		coinState.add(new int[] {coin1[0], coin1[1], coin2[0], coin2[1], 0});
		minBtnCnt = Integer.MAX_VALUE;
		
		bfs();
		if(minBtnCnt == Integer.MAX_VALUE || btnCnt == 10) {
			System.out.println(-1);
		}else {
			System.out.println(minBtnCnt);
		}
		
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void bfs() {
		
		while(!coinState.isEmpty()) {			
			int[] state = coinState.poll();
			
			int coin1Row = state[0];
			int coin1Col = state[1];
			
			int coin2Row = state[2];
			int coin2Col = state[3];
			
			btnCnt = state[4];
			
			if(btnCnt>=10) continue;
			
			for (int d = 0; d < 4; d++) {
				int moveCoin1R = coin1Row+dr[d];
				int moveCoin1C = coin1Col+dc[d];
				int moveCoin2R = coin2Row+dr[d];
				int moveCoin2C = coin2Col+dc[d];
				
				System.out.println("coin1 : " + moveCoin1R +", "+ moveCoin1C);
				System.out.println("coin2 : " + moveCoin2R +", "+ moveCoin2C);
				System.out.println();
				if(isEscape(moveCoin1R, moveCoin1C) && isEscape(moveCoin2R, moveCoin2C)) continue;
				
				if(isEscape(moveCoin1R, moveCoin1C) || isEscape(moveCoin2R, moveCoin2C)) {
					minBtnCnt = Math.min(minBtnCnt, btnCnt+1);
					return;
				}
				
				if(board[moveCoin1R][moveCoin1C] == '#') {
					moveCoin1R = coin1Row;
					moveCoin1C = coin1Col;
				}
				
				if(board[moveCoin2R][moveCoin2C] == '#') {
					moveCoin2R = coin2Row;
					moveCoin2C = coin2Col;
				}
				
				if(!(visited1[moveCoin1R][moveCoin1C] && visited2[moveCoin2R][moveCoin2C])) {
					visited1[moveCoin1R][moveCoin1C] = true;
					visited2[moveCoin2R][moveCoin2C] = true;
					coinState.offer(new int[] {moveCoin1R, moveCoin1C, moveCoin2R, moveCoin2C, btnCnt+1});
				}
				
				System.out.println("btn cnt : " + (btnCnt+1));
				System.out.println();
				System.out.println("visited1");
				
				for (int i = 0; i < row; i++) {
					System.out.println(Arrays.toString(visited1[i]));
				}
				
				System.out.println();
				System.out.println("visited2");
				
				for (int i = 0; i < row; i++) {
					System.out.println(Arrays.toString(visited2[i]));
				}
				
				System.out.println();
			}
		}
	}

	static boolean isEscape(int r, int c) {
		return !(r>=0 && r<row && c>=0 && c<col);
	}
}