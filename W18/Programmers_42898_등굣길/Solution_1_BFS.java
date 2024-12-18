package Programmers_42898_등굣길;

import java.util.LinkedList;
import java.util.Queue;
// timeout
class Node {
    int row, col, path;
    
    Node(int row, int col, int path) {
        this.row = row;
        this.col = col;
        this.path = path;
    }
}

public class Solution_1_BFS {
	private int[] dr = {-1, 1, 0, 0};
	private int[] dc = {0, 0, -1, 1};
	
    public int solution(int m, int n, int[][] puddles) {
    	boolean[][] isPuddle = new boolean[n+1][m+1];
        
        for(int[] puddle : puddles) {
            isPuddle[puddle[1]][puddle[0]] = true;
        }
    	
    	Queue<Node> que = new LinkedList<>();
    	que.offer(new Node(1, 1, 0));
    	
    	int minPath = Integer.MAX_VALUE;
    	int answer = 0;
    	
    	while(!que.isEmpty()) {
    		Node cur = que.poll();
    		int cr = cur.row;
    		int cc = cur.col;
    		int curPath = cur.path;
    		
    		if(curPath > minPath) continue;
    		
    		if(cr == n && cc == m) {
                if(curPath < minPath) {
                    minPath = curPath;
                    answer = 1;
                } else if(curPath == minPath) {
                    answer++;
                }
                continue;
            }
    		
    		if(curPath >= minPath) continue;
    		
    		for (int d = 0; d < 4; d++) {
				int mr = cr+dr[d];
				int mc = cc+dc[d];
				
				if(mr>n || mr<1 || mc>m || mc<1) continue;
				if(isPuddle[mr][mc]) continue;
				
				que.offer(new Node(mr, mc, curPath+1));
			}
    	}
        return answer%1000000007;
    }
}
