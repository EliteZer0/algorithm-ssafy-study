package BOJ_2138_전구와스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138 {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		char[] pressFirst = br.readLine().toCharArray();
		char[] notPressFirst = Arrays.copyOf(pressFirst, n);
		char[] target = br.readLine().toCharArray();

		// 첫 번째 전구를 눌러서 변화
		pressFirst[0] = pressFirst[0] == '1' ? '0' : '1';
		pressFirst[1] = pressFirst[1] == '1' ? '0' : '1';

		int pressFirstCount = countSwitches(pressFirst, target, 1) + 1;//스위치 누르고 시작하니까 카운트 하나 +1
		int notPressFirstCount = countSwitches(notPressFirst, target, 1);//아무 생각 없이 0으로 둬서 런타임 에러 남.

		int result = -1;
		
		if (Arrays.equals(pressFirst, target)) {
			result = pressFirstCount;
		}
		
		if (Arrays.equals(notPressFirst, target)) {
			if (result == -1 || notPressFirstCount < result) {
				result = notPressFirstCount;
			}
		}

		System.out.println(result);
	}

	static int countSwitches(char[] bulbs, char[] target, int start) {
		int count = 0;
		for (int i = start; i < n; i++) {
			//i를 누르면 i-1, i, i+1이 바뀌니까 i-1의 상태를 확인.
			if (bulbs[i - 1] != target[i - 1]) {
				bulbs[i - 1] = bulbs[i - 1] == '1' ? '0' : '1';
				bulbs[i] = bulbs[i] == '1' ? '0' : '1';
				//n-1을 처리하기 위한 조건문
				if (i + 1 < n) {
					bulbs[i + 1] = bulbs[i + 1] == '1' ? '0' : '1';
				}
				count++;
			}
		}
		return count;
	}
}
