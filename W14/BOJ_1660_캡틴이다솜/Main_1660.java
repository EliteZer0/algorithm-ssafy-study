
package BOJ_1660_캡틴이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1660 {
	static int[] tetrahedralNum;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		tetrahedralNum = new int [121]; //121에서 300000 넘어감
		
		for (int i = 0; i < tetrahedralNum.length; i++) {
			tetrahedralNum[i] = i*(i+1)*(i+2)/6;
		}
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < tetrahedralNum.length; j++) {
				if(i>= tetrahedralNum[j]) {
					dp[i] = Math.min(dp[i], dp[i-tetrahedralNum[j]]+1);//자기자신이상 사면체수[j] 뺀 dp 배열 값 +1 중 최소로 저장
				}
			}
		}
		
		System.out.println(dp[N]);
	}
}