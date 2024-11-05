package SWEA_1984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1984 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		int n = 10;
		
		for(int tcNum = 1; tcNum<testcase+1; tcNum++) {
			int[] inputNums = new int[n];
			double sum = 0;
			double avg = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<10; i++) {
				inputNums[i] = Integer.parseInt(st.nextToken());
			}
				
			Arrays.sort(inputNums);
			
			for(int i=1; i<9; i++) {
				sum += inputNums[i];
			}
			
			avg = Math.round(sum/8);
			
			System.out.printf("#%d %.0f\n", tcNum, avg);
		}
	}
}
