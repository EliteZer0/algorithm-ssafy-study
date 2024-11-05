package SWEA_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//19112kb 120ms
public class Solution_1966_used_PriorityQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			int n = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> data = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++) {
				data.add(Integer.parseInt(st.nextToken()));
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tcNum);
			for (int i = 0; i < n; i++) {
				sb.append(" ").append(data.poll());
			}
			System.out.println(sb.toString());
		}
	}
}
