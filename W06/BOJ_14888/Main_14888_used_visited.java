package BOJ_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
// 246180 KB 724 ms
public class Main_14888_used_visited {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static char[] newOperators;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());	
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		int[] operatorsCnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operatorsCnt[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Character> operators = new ArrayList<>();
		for (int i = 0; i < operatorsCnt[0]; i++) {
			operators.add('+');
		}
		for (int i = 0; i < operatorsCnt[1]; i++) {
			operators.add('-');
		}
		for (int i = 0; i < operatorsCnt[2]; i++) {
			operators.add('*');
		}
		for (int i = 0; i < operatorsCnt[3]; i++) {
			operators.add('/');
		}
		visited = new boolean[operators.size()];
		newOperators = new char[nums.length - 1];
		permutation(nums, operators, 0, operators.size(), nums.length - 1);
		System.out.println(max);
    	System.out.println(min);
	}
	
	static void permutation(int[] nums, ArrayList<Character> operators, int depth, int n, int r) {
		if(depth == r) {
			calculrator(nums, newOperators);
			return;
		}
		
		for(int i = 0; i< n; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			newOperators[depth] = operators.get(i);
			permutation(nums, operators, depth+1, n, r);
			newOperators[depth] = 0;
			visited[i] = false;
		}
	}
	 
	static void calculrator(int[] nums, char[] operators) {
		int[] claNums = Arrays.copyOf(nums, nums.length);
    	for (int i = 0; i < newOperators.length; i++) {
			if(newOperators[i] == '+') {
				claNums[i+1] = claNums[i]+claNums[i+1];
			}
			if(newOperators[i] == '-') {
				claNums[i+1] = claNums[i]-claNums[i+1];
			}
			if(newOperators[i] == '*') {
				claNums[i+1] = claNums[i]*claNums[i+1];
			}
			if(newOperators[i] == '/') {
				if(claNums[i] < 0) {
					claNums[i+1] = -((-claNums[i])/claNums[i+1]);
				}else {
					claNums[i+1] = claNums[i]/claNums[i+1];
				}
			}
		}
    	max = Math.max(max, claNums[operators.length]);
    	min = Math.min(min, claNums[operators.length]);
	}
}
