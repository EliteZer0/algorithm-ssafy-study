package BOJ_20040_사이클게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//양방향 그래프
//사이클 판단 -> 크루스칼은 안됨
//유니온 파인드
//DFS로도 가능함 -> 시간 초과
public class Main_20040_1_dfs {
	static int node;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[node];

		for (int i = 0; i < node; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		int result = 0;

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			addEdge(u, v);
			visited = new boolean[node];
			if (hasCycle(u, -1)) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}

	private static boolean hasCycle(int cur, int parent) {
		visited[cur] = true;

		for (int next : adjList[cur]) {
			if (!visited[next]) {
				if (hasCycle(next, cur))
					return true;
			} else if (next != parent) {
				return true;
			}
		}
		return false;
	}

	private static void addEdge(int u, int v) {
		// 양방향
		adjList[u].add(v);
		adjList[v].add(u);
	}
}
