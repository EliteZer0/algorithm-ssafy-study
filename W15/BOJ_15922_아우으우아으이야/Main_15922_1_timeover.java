package BOJ_15922_아우으우아으이야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
//중복되는 선분 길이 생각하기 귀찮아서 두가지 방법을 고민함
//1. boolean 배열로 있니 없니 체크 -> 음수가 나올 수도 있어서 고려해야하는 요소가 많음.
//2. 셋으로 받아서 중복값 제거 -> 이 경우 정렬이 필요해서 트리셋 사용
//연결이 끊어지면 우선 길이를 1 줄임. 앞 선분의 마지막 수와 뒷 선분의 시작하는 수를 빼서 전체 길이에서 빼면 됨
//이렇게 진행하니 수의 범위가 커버가 안됨.
public class Main_15922_1_timeover {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Integer> cordinate = new TreeSet<>();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			while(start<=end) {
				cordinate.add(start);
				start++;
			}
		}
		
		int start = cordinate.first();
		int end = cordinate.last();
		int length = end - start;
		if(cordinate.size()-1 != length) {
			for (int i = start; i <= end; i++) {
				if(!cordinate.contains(i)) {
					length--;
					start = cordinate.lower(i);
					end = cordinate.higher(i);
					i = end;
					length -= (end-start);
				}
			}
		}
		
		System.out.println(length);
		System.out.println(cordinate);
	} 
}
