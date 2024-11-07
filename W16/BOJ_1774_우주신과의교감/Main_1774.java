package BOJ_1774_우주신과의교감;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//최소 간선의 개수를 활용하는 크루스칼 계열
//간선 길이는 피타고라스 활용해서 구하기
//크루스칼 템플릿은 블로그 참고
class Point {
	int num;
	double x;
	double y;

	Point(int num, double x, double y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
}

class Edge implements Comparable<Edge> {
    int start;
    int end; 
    double distance;

    Edge(int start, int end, double distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
        if (distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main_1774 {
	static int[] parent;
	static ArrayList<Edge> edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        Point[] points = new Point[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            points[i] = new Point(i, x, y);
        }
        
        // 이미 연결된 통로들에 대해 union 연산 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start, end);
        }
        
        edgeList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double distance = calDis(points[i], points[j]);
                edgeList.add(new Edge(points[i].num, points[j].num, distance));
            }
        }
        
        // 간선을 거리 기준으로 오름차순 정렬
        Collections.sort(edgeList);

        double ans = 0;

        // 거리가 짧은 간선부터 선택하면서 사이클이 생기지 않도록 연결
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (find(edge.start) != find(edge.end)) {  // 사이클이 생기지 않는 경우
                ans += edge.distance;  // 해당 간선의 거리 추가
                union(edge.start, edge.end);  // 두 정점 연결
            }
        }

        System.out.println(String.format("%.2f", ans));
	}

	private static int find(int n) {
		if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);
	}

	private static double calDis(Point p, Point q) {
		// 피타
		return Math.sqrt(Math.pow(p.x - q.x, 2) + Math.pow(p.y - q.y, 2));
	}

	private static void union(int s, int e) {
		s = find(s);
		e = find(e);
		if(s != e) {
			parent[e] = s;
		}
	}
}
