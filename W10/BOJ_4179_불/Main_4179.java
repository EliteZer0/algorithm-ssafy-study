package BOJ_4179_불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4179 {
	static int row, col, time;
	static char[][] maze;
	static boolean[][] jvisited;
	static boolean[][] fvisited;
	static boolean escape;
	static Queue<int[]> jihoon;
	static Queue<int[]> fire;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		maze = new char[row][col];
		jvisited = new boolean[row][col];
		fvisited = new boolean[row][col];
		jihoon = new LinkedList<>();
		fire = new LinkedList<>();
		
		for (int i = 0; i < row; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < col; j++) {
				if(maze[i][j] == 'J') {
					jihoon.offer(new int[] {i,j});
					jvisited[i][j] = true;
				}
				if(maze[i][j] == 'F') {
					fire.offer(new int[] {i,j});
					fvisited[i][j] = true;
				}
			}
		}
		
		escape = false;
		time = 0;
		
		bfs();
		
		System.out.println(escape ? time : "IMPOSSIBLE");
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static void bfs() {
		
		while(!jihoon.isEmpty()) {			
			int fsize = fire.size();
			for (int i = 0; i < fsize; i++) {
				int[] fcur = fire.poll();
				int fr = fcur[0];
				int fc = fcur[1];					
				
				for (int d = 0; d < 4; d++) {
					int fnr = fr+dr[d];
					int fnc = fc+dc[d];
					if(!check(fnr, fnc)) continue;
					if(maze[fnr][fnc] == '#') continue;
					if(fvisited[fnr][fnc]) continue;
					maze[fnr][fnc] = 'F';
					fvisited[fnr][fnc] = true;
					fire.offer(new int[] {fnr, fnc});
				}
			}
			
			int jsize = jihoon.size();
			for (int i = 0; i < jsize; i++) {
				int[] jcur = jihoon.poll();
				int jr = jcur[0];
				int jc = jcur[1];
				for (int d = 0; d < 4; d++) {
					int jnr = jr+dr[d];
					int jnc = jc+dc[d];
					if(!check(jnr, jnc)) {
						escape = true;
						time++;
						return;
					}
					if(maze[jnr][jnc] == '#') continue;
					if(jvisited[jnr][jnc]) continue;
					if(maze[jnr][jnc] == 'F') continue;
					jvisited[jnr][jnc] = true;
					jihoon.offer(new int[] {jnr, jnc});
				}
			}
			
			time++;
			
		}
	}

	static boolean check(int r, int c) {
		return r>=0 && r<row && c>=0 && c<col;
	}
}
