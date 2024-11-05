package SWEA_1970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1970 {
	static int count;
	static int get;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tcNum).append("\n");
			calChange(50000);
			sb.append(get).append(" ");
			calChange(10000);
			sb.append(get).append(" ");
			calChange(5000);
			sb.append(get).append(" ");
			calChange(1000);
			sb.append(get).append(" ");
			calChange(500);
			sb.append(get).append(" ");
			calChange(100);
			sb.append(get).append(" ");
			calChange(50);
			sb.append(get).append(" ");
			calChange(10);
			sb.append(get);
			System.out.println(sb.toString());
		}
	}

	static void calChange(int change) {
		if((N/change) != 0) {
			count = N/change;
			get = count;
			N = N%change;
			count = 0;
		}else {
			get = count;
			N = N%change;
			count = 0;
			return;
		}
	}
}
