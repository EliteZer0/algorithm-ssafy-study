package Programmers_150365_미로탈출명령어;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// timeout
class Node {
    int row, col;
    String path;
    
    Node(int row, int col, String path) {
        this.row = row;
        this.col = col;
        this.path = path;
    }
}

class Solution_1_BFS {
	private int[] dr = {-1, 1, 0, 0};
	private int[] dc = {0, 0, -1, 1};
	private char[] command = {'u', 'd', 'l', 'r'};
	
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        List<String> answerList = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(x, y, ""));
        
        while(!que.isEmpty()) {
        	Node current = que.poll();
            int cr = current.row;
            int cc = current.col;
            String path = current.path;
            
        	if(path.length()==k) {
        		if(cr == r && cc == c) answerList.add(path);
        		continue;
        	}
        	for (int d = 0; d < 4; d++) {
				int mr = cr+dr[d];
				int mc = cc+dc[d];
				
				if(mr>n || mr<1 || mc>m || mc<1) continue;
				
				que.offer(new Node(mr, mc, path + command[d]));
			}
        }
        
        Collections.sort(answerList);
        
        return answerList.isEmpty() ? "impossible" : answerList.get(0);
    }
}
