package SWEA_1970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1970_2 {
	static int count;
	static int get;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tcNum);
			System.out.println(sb.toString());
			calChange(50000);
			
		}
	}

	static void calChange(int change) {
		int trys = 1;
		StringBuilder sb = new StringBuilder();
		while(change>=10) {
			if(trys%2 !=0) {
				if(change>=50) {
					count = N/change;
					sb.append(count).append(" ");
					count = 0;
					N = N%change;
					change = change/5;
					trys++;
				}
			}else {
				if(change>=10) {
					count = N/change;
					sb.append(count).append(" ");
					count = 0;
					N = N%change;
					change = change/2;
					trys++;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
