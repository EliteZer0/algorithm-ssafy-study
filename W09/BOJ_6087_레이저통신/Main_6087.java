package BOJ_6087_레이저통신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6087 {
	//띵균쌤과 큐티뽀티 효쌤 코드에서 템플릿 가져옴...
	static int row, col;
	static char[][] map;
	static int[][][] visited;//수영대회랑 비슷하다고 생각해서 거울 사용 개수 저장
	static Node[] target = new Node[2];
	static class Node implements Comparable<Node> {
		int r, c, dir, mirrors;
		public Node(int r, int c, int dir, int mirrors) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.mirrors = mirrors;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.mirrors - o.mirrors;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		map = new char[row][col];
		
		int idx = 0;
		for (int i = 0; i < row; i++) {
        	map[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'C') {
                	target[idx] = new Node(i, j, -1, 0);
                    idx++;
                } 
            }
        }
		
		visited = new int[row][col][4];
		
		for (int first[][] : visited) {
			for (int second[] : first) {
				Arrays.fill(second, Integer.MAX_VALUE);
			}
		}
		
		int answer = bfs(target[0]);
		System.out.println(answer);
    }
    
    static int[] dr = {-1, 1, 0, 0};//상하좌우 
    static int[] dc = {0, 0, -1, 1};
    
    private static int bfs(Node start) {
        int min = Integer.MAX_VALUE;
        Node end = target[1];
        Queue<Node> que = new LinkedList<>();
        
        que.offer(start);

        while (!que.isEmpty()) {
            Node cur = que.poll();

            if (cur.r == end.r && cur.c == end.c) {
                min = Math.min(min, cur.mirrors);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                int nMirrors = cur.mirrors;
                // 방향을 꺾으려면 거울 필요함
                if(cur.dir != -1 && cur.dir != i) {
                	nMirrors += 1;
                }
                
                if (!check(nr, nc)) continue;
                if (map[nr][nc] == '*') continue;
                
                if (visited[nr][nc][i] > nMirrors) {
                    que.offer(new Node(nr, nc, i, nMirrors));
                    visited[nr][nc][i] = nMirrors;
                }
            }
        } 
        return min;
    }

    private static boolean check(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }
}
