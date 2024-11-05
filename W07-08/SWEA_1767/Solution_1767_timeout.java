package SWEA_1767;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_timeout {
	static int T,N, minWireLength, maxCore;
	static int[][] cell;
	static List<Core> coreList;
	
	static class Core{
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
		
		for (int tc = 1; tc < T+1; tc++) {
			StringBuilder sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			cell = new int[N][N];
			coreList = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					if(input == 1) {
						cell[i][j] = input;
						if(isConnected(i, j)) continue;
						coreList.add(new Core(i,j));
					}
				}
			}

			minWireLength = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			sb.append("#").append(tc).append(" ").append(minWireLength);
			System.out.println(sb.toString());
		}
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void dfs(int idx, int coreCnt, int wireCnt) {
		if(idx == coreList.size()) {
			if(maxCore < coreCnt) {
				maxCore = coreCnt;
				minWireLength = wireCnt;
			}else if(maxCore == coreCnt) {
				minWireLength = Math.min(wireCnt, minWireLength);
			}
			return;
		}
		
		int row = coreList.get(idx).row;
		int col = coreList.get(idx).col;
		
		for(int d = 0; d<4; d++) {
			int count = 0;
			int curRow = row;
			int curCol = col;
			
			while(true) {
				int moveRow = curRow + dr[d];
				int moveCol = curCol + dc[d];
				
				if(!check(moveRow, moveCol)) break;
				
				if(cell[moveRow][moveCol] == 1) {
					count = 0;
					break;
				}
				
				count++;
			}
	             
			for(int i=0; i<count; i++) {
				int moveRow = curRow + dr[d];
	        	int moveCol = curCol + dc[d];
	            cell[moveRow][moveCol] = 1;
			}
			
			if(count == 0) {
				dfs(idx+1, coreCnt, wireCnt);
			}else {
				dfs(idx+1, coreCnt+1, wireCnt+count);
				for(int i=0; i<count; i++) {
					int moveRow = curRow + dr[d];
		        	int moveCol = curCol + dc[d];
		            cell[moveRow][moveCol] = 0;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
	
	static boolean isConnected(int r, int c) {
		return r==0 || r==N-1 || c==0 || c==N-1;
	}
}
