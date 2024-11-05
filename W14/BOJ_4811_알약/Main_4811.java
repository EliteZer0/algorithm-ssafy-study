package BOJ_4811_알약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4811 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		while((N = Integer.parseInt(br.readLine())) > 0) {
			long dp[][] = new long[N+1][N+1];
			
			for (int i = N; i >= 0 ; i--) {
				for (int j = N-i; j >=0 ; j--) {
					//Whole : N Half : 0 일때 1 설정
					dp [N][0] = 1;
					//시작점부터 우상단 대각선 전부 1로 설정
					//매 상황마다 온전한 알약 꺼내서 하프컷하고 넣는 경우는 1개니까
					if(N-i == j) {
						dp[i][j] = 1;
					}
					//좌하단 + 우측이 현 위치의 가짓수
					if(i<N && j<N-i && j>0) {
						dp[i][j] = dp[i+1][j-1] + dp[i][j+1]; 
					}
					//half컷이 0인 경우는 같은 열의 1인 경우랑 동일함
					dp[i][0] = dp[i][1];
				}
			}
			//알약 전부 소진하는 결과 출력			
			System.out.println(dp[0][0]);
		}
	}
}
