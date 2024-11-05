package SWEA_1959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1959_maxminArr {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] maxArr;
			int[] minArr;
			if(N>=M) {
				maxArr = new int[N];
				minArr = new int[M];
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < N; i++) {
					maxArr[i] = Integer.parseInt(st.nextToken());
				}
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < M; i++) {
					minArr[i] = Integer.parseInt(st.nextToken());
				}
			}else {
				minArr = new int[N];
				maxArr = new int[M];
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < N; i++) {
					minArr[i] = Integer.parseInt(st.nextToken());
				}
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < M; i++) {
					maxArr[i] = Integer.parseInt(st.nextToken());
				}
			}
			int sum = 0;
			int maxSum = 0;
			for (int i = 0; i < maxArr.length - minArr.length + 1; i++) {
				for (int j = 0; j < minArr.length; j++) {
					sum += minArr[j]*maxArr[j+i];
				}
				maxSum = Math.max(maxSum, sum);
				sum = 0;
			}
			System.out.printf("#%d %d\n",tcNum, maxSum);
		}
	}
}
