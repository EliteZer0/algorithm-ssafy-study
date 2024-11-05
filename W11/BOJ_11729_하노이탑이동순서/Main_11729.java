package BOJ_11729_하노이탑이동순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//하노이탑 움직이는 횟수 점화식 : 2^n -1
//홀수는 1 3으로 시작 짝수는 1 2로 시작해야 두 번째 칸에 n-1개의 탑 생성 가능 -> 재귀로 풀 땐 고려사항이 아니었음.
//홀수는 본인 앞의 홀수의 이동을 그대로 시행한 이후 나머지 원판이 진행
public class Main_11729 {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		int N = Integer.parseInt(br.readLine());//원판의 개수
		int moving = (int)(Math.pow(2, N) - 1);//원판 움직인 횟수
		
		sb.append(moving).append('\n');
 
		Hanoi(N, 1, 2, 3);//원판의 개수, 시작 , 경유, 도착
		System.out.println(sb);
 
	}
	
	//재귀 함수는 다른 사람 로직 참고함.
	public static void Hanoi(int N, int fst, int snd, int trd) {
		// 원반이 1개일 때는 바로 목적지에 도착
		if (N == 1) {
			sb.append(fst + " " + trd + "\n");
			return;
		}
 
		//N-1개의 원판 2번 칸으로 이동
		Hanoi(N - 1, fst, trd, snd);
    
		//마지막 원판 3번 칸으로 이동
		sb.append(fst + " " + trd + "\n");
    
		//2번 칸에 있는 N-1개의 원판 3번 칸으로 이동
		Hanoi(N - 1, snd, fst, trd);
	}
}
