package SWEA_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//18676kb 107ms
public class Solution_1966_used_ArraysSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			int n = Integer.parseInt(br.readLine());
			int[] data = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(data);
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tcNum);
			for (int i = 0; i < n; i++) {
				sb.append(" ").append(data[i]);
			}
			System.out.println(sb.toString());
		}
	}
}
