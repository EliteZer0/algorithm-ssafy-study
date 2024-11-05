package BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;
//부분수열의 합
//첫째 줄에 합이 S가 되는 부분수열의 개수를 출력
public class Main_1182 {
	static int target;
	static int[] data;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		data = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(data));
		count = 0;
		powerset(0, 0);
		if(target == 0) count--;//아무 요소도 없을 때 합은 0이 되기 때문.
		System.out.println(count);
	}

	static void powerset(int idx, int sum) {
		if (idx == data.length) {
			if (sum == target) {
				count++;
			}
			return;
		}
		powerset(idx + 1, sum + data[idx]);
		powerset(idx + 1, sum);
	}
}