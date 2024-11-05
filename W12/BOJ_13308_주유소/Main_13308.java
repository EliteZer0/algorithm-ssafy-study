package BOJ_13308_주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13308 {
	
	static class Edge {
		int to, cost;//목적지, 이동 시 소요되는 기름
		
		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static class Node implements Comparable<Node> {
		int cur, minCost;//현재 위치, 가장 싼 주유소 가격
		long totalCost;
		
		Node (int cur, int minCost, long totalCost) {
			this.cur = cur;
			this.minCost = minCost;
			this.totalCost = totalCost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.totalCost, o.totalCost);
		}
	}
	
	static int N, M;
	static int[] oilPrice;//각 도시 기름 가격 저장 배열
	static List<Edge>[] edges;//연결된 도로 리스트
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oilPrice = new int[N + 1];
		edges = new ArrayList[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			oilPrice[i] = Integer.parseInt(st.nextToken());
			edges[i] = new ArrayList<>();
		}
            
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());//시작도시
			int end = Integer.parseInt(st.nextToken());//도착도시
			int distance = Integer.parseInt(st.nextToken());//거리
			//양방향임
			edges[start].add(new Edge(end, distance));
			edges[end].add(new Edge(start, distance));
		}
            
		sb.append(dijkstra());
		System.out.println(sb);
	}
	
	public static long dijkstra() {
    	//dp : i에 minCost를 가지고 방문했을때의 최소 비용 저장
		long[][] dp = new long[N + 1][2501];
		for (int i = 0; i <= N; i++) Arrays.fill(dp[i], Long.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, oilPrice[1], 0));
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			//도착도시가 N이면 리턴
			if (n.cur == N) return n.totalCost;
			
			for (Edge e : edges[n.cur]) {
				//시간초과 방지용 : 최소비용보다 크거나 같으면 패스
				if (dp[e.to][n.minCost] <= n.totalCost + (e.cost * n.minCost)) continue;
				dp[e.to][n.minCost] = n.totalCost + (e.cost * n.minCost);
				pq.offer(new Node(e.to, Math.min(n.minCost, oilPrice[e.to]), dp[e.to][n.minCost]));	
			}
		}
		return -1;
	}
}