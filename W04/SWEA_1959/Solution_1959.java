package SWEA_1959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//maxArr minArr로 받는게 더 빠르지 않을까 했는데 이게 메모리 1500kb 시간 5ms 더 적게걸림.
public class Solution_1959 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aLength = Integer.parseInt(st.nextToken());
			int bLength = Integer.parseInt(st.nextToken());
			
			int[] a = new int[aLength];
			int[] b = new int[bLength];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < aLength; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < bLength; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxLength = Math.max(aLength, bLength);
			int minLength = Math.min(aLength, bLength);
			int sum = 0;
			int maxSum = 0;
		
			for (int i = 0; i < maxLength - minLength + 1; i++) {
				
				if(aLength>bLength) {
					sum = 0;
					for (int j = 0; j < minLength; j++) {
						sum += a[j+i]*b[j];
					}
				}
				
				maxSum = Math.max(maxSum, sum);
				
				if(aLength<bLength) {
					sum = 0;
					for (int j = 0; j < minLength; j++) {
						sum += a[j]*b[j+i];
					}
				}
				
				maxSum = Math.max(maxSum, sum);
			}
			
			System.out.printf("#%d %d\n", tcNum, maxSum);
				
		}
	}
}
