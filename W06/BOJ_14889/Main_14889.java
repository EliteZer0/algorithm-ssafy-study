package BOJ_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;
//이 방식이 더 빠를 거라고 생각했는데 17368KB 256 ms(처음은 18056KB 228 ms)
public class Main_14889 {
	static int[][] score;
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int r = n/2;
		score = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[n];
		answer = Integer.MAX_VALUE;
		combination(0, 0, n, r);
		System.out.println(answer);
	}

	static void combination(int idx, int depth, int n, int r) {
		if(idx == r) {
			int team1Sum = 0;
			int team2Sum = 0;
			
			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited.length; j++) {
					if(visited[i]) {
						if(visited[j]) {
							team1Sum += score[i][j];
						}
					}else {
						if(!visited[j]) {
							team2Sum += score[i][j];
						}
					}
				}
			}
			int difference = Math.abs(team1Sum - team2Sum);
//			System.out.println("difference: "+difference);
			answer = Math.min(answer, difference);
//			System.out.println("answer: "+answer);  
			return;
		}
		for (int i = depth; i<n; i++) {
			visited[i] = true;
			combination(idx+1, i+1, n, r);
			visited[i] = false;
		}
	}
}
