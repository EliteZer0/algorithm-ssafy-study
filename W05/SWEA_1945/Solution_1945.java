package SWEA_1945;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1945 {
	static int count;
	static int exponent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			primeFactorization(n, 2);
			sb.append("#").append(tcNum).append(" ").append(exponent);
			primeFactorization(n, 3);
			sb.append(" ").append(exponent);
			primeFactorization(n, 5);
			sb.append(" ").append(exponent);
			primeFactorization(n, 7);
			sb.append(" ").append(exponent);
			primeFactorization(n, 11);
			sb.append(" ").append(exponent);
			System.out.println(sb.toString());
		}
	}
	//재귀를 사용해보려고 시도.
	static void primeFactorization(int n, int q) {
		if(n%q==0) {
			count++;
			primeFactorization(n/q, q);
		}else {
			exponent = count;//count 변수 밖에서 초기화하기 싫어서 exponent 변수에 저장하고 초기화함.
			count = 0;
			return;
		}
	}
}
