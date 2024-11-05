package BOJ_2528_사다리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//메모리 초과
class Ladder{
	int s, e, d;

	public Ladder(int s, int e, int d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}
	
}
public class Main_2528_1 {
	static int N, L, time;
	static Ladder[] ladderList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		ladderList = new Ladder[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			if(l == L) {
				ladderList[i] = new Ladder(0, l-1, -1);
			}
			else if(d == 0) {
				ladderList[i] = new Ladder(0, l-1, d);
			}else {
				ladderList[i] = new Ladder(L-l, L-1, d);
			}
		}
		
		time = 0;
		
		for (int i = 0; i < N-1; i++) {
			int curS = ladderList[i].s;
			int curE = ladderList[i].e;
			int nextS = ladderList[i+1].s;
			int nextE = ladderList[i+1].e;
			while(!check(curS, nextS, nextE) && !check(curE, nextS, nextE)) {
				time++;
				move();
				curS = ladderList[i].s;
				curE = ladderList[i].e;
				nextS = ladderList[i+1].s;
				nextE = ladderList[i+1].e;
			}
		}
		
		System.out.println(time);
	}

	private static void move() {
		for (int i = 0; i < N; i++) {
			int s = ladderList[i].s;
			int e = ladderList[i].e;
			int d = ladderList[i].d;
			if(d==0) {
				int newS = s+1;
				int newE = e+1;
				int newD = d;
				if(atEdge(newS, newE)) {
					newD = 1;
				}
				ladderList[i] = new Ladder(newS, newE, newD);
			}
			if(d==1) {
				int newS = s-1;
				int newE = e-1;
				int newD = d;
				if(atEdge(newS, newE)) {
					newD = 0;
				}
				ladderList[i] = new Ladder(newS, newE, newD);
			}
		}
	}

	private static boolean atEdge(int s, int e) {
		return s==0 || e==L-1;
	}

	private static boolean check(int cur, int nextS, int nextE) {
		return cur>=nextS-1 && cur<=nextE+1;
	}
}