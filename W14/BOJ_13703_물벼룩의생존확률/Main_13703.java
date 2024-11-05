package BOJ_13703_물벼룩의생존확률;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//파스칼의 삼각형 활용
/*
 2 3
 0   0   0   1   0   0   0 
 0   0   1   0   1   0   0 
 0   1   0   2   0   0   0 
 1   0   3   0   2   0   0 
 6
 */
public class Main_13703 {
	static int time;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int distance = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());
		
		if(distance == 0) {
        	System.out.println(0);
            return;
        }
        
        if (time < distance) {
            System.out.println((int)Math.pow(2, time));
            return;
        }
		
		long[][] dp = new long[time+1][time*2 +1];//count만 long처리 하고 dp 배열을 int 처리해서 틀림.
		
		//시작위치 방법 1개로 설정
		dp[0][time] = 1;
		
		for(int i = 1; i<time+1; i++) {
			for(int j = 0; j < time*2 + 1; j++) {
				//수면에 도달하면 방법 0으로 처리
				if(j == time+distance) {
					dp[i][j] = 0;
				}
				//시작 열에 걸리면 방법의 개수는 우상단
				else if(j == 0) {
					dp[i][j] = dp[i-1][j+1];
				}
				// 마지막 열에 걸리면 방법의 개수는 좌상단
				else if(j == time*2) {
					dp[i][j] = dp[i-1][j-1];
				}
				//경계에 물리지 않으면 방법의 개수는 좌상단 + 우상단
				else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
			}
		}
		
//		for (int i = 0; i < time+1; i++) {
//			for (int j = 0; j < time*2+1; j++) {
//				System.out.printf("%3d ", dp[i][j]);
//			}
//			System.out.println();
//		}
		
		long count = 0;
		//수면 전까지 dp 배열 합
		for (int j = 0; j < time+distance; j++) {
			count += dp[time][j];
		}
		
		System.out.println(count);
	}
}
