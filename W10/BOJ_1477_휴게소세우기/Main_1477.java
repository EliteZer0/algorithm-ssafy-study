package BOJ_1477_휴게소세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//이분탐색
public class Main_1477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken()); 
		int l = Integer.parseInt(st.nextToken());
		
		int[] rest = new int[n+2];
		rest[0]= 0;
		rest[n+1]= l;
		
		st = new StringTokenizer(br.readLine());
		
		if(n>0) {			
			for (int i = 1; i <= n; i++) {
				rest[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(rest);
		
		int left = 1;
		int right = l-1;
		int ans = 0;
		
		while(left<=right) {
			 int mid = (left+right)/2;
			 int cnt = count(mid,rest);
			 if(cnt>m) {
				 left = mid+1;
			 }else {
				 right = mid-1;
				 ans = mid;
			 }
		}
		System.out.println(ans);
	}

	private static int count(int mid, int[] rest) {
		int cnt = 0;
		for(int i = 0; i<rest.length-1; i++) {
			int temp = rest[i+1]-rest[i];
			// temp 안에서 mid 간격으로 몇개 설치할 수 있는지 temp/mid를 통해 몫으로 측정
			cnt += temp/mid;
			// 나누어 떨어지는 경우 휴게소가 마지막에 중복 설치되지 않도록 1개 감소.
			if(temp%mid == 0) {
				cnt--;
			}
		}
		return cnt;
	}
}
