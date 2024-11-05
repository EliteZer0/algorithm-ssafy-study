package BOJ_3101_토끼의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2차원으로 맵 만들기 시도 -> 역시나 메모리 초과
public class Main_3101_1_use2DArray {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int num = 1;
        // 대각선 지그재그로 숫자 입력
		// sum은 대각선 r+c의 합
        for (int sum = 0; sum <= 2 * (N - 1); sum++) {
            if (sum % 2 == 0) {
                for (int i = 0; i <= sum; i++) {
                    int r = sum - i;
                    int c = i;
                    if (r < N && c < N) {
                        map[r][c] = num++;
                    }
                }
            } else {
                for (int i = 0; i <= sum; i++) {
                    int r = i;
                    int c = sum - i;
                    if (r < N && c < N) {
                        map[r][c] = num++;
                    }
                }
            }
        }

        // map 확인용 디버깅 코드
        /*
        for (int i = 0; i < N; i++) {
         
            System.out.println(Arrays.toString(map[i]));
        }
        */
        
        // 토끼 이동 커맨드 입력
        char[] move = br.readLine().toCharArray();
        
        int[] dr = {-1, 1, 0, 0};//상하좌우
        int[] dc = {0, 0, -1, 1};
        
        int r = 0;
        int c = 0;
        int sum = map[0][0];
        
        for (int i = 0; i < K; i++) {
			int cr = r;
			int cc = c;
        	if(move[i] == 'U') {
        		cr += dr[0];
        		cc += dc[0];
        		
        		sum += map[cr][cc];
        		
        		r = cr;
        		c = cc;
			} else if(move[i] == 'D') {
				cr += dr[1];
        		cc += dc[1];
        		
        		sum += map[cr][cc];
        		
        		r = cr;
        		c = cc;
			} else if(move[i] == 'L') {
				cr += dr[2];
        		cc += dc[2];
        		
        		sum += map[cr][cc];
        		
        		r = cr;
        		c = cc;
			} else if(move[i] == 'R') {
				cr += dr[3];
        		cc += dc[3];
        		
        		sum += map[cr][cc];
        		
        		r = cr;
        		c = cc;
			} 
		}
        
        System.out.println(sum);
	}
}
