package BOJ_19236_청소년상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
//Fish 이차원 배열로 이동시키다가 터질 것 같아서 클래스에 좌표저장하는 걸로 바꿈
//6시간동안 구현해봤지만 도무지 답이 안 나와요...
public class Main_19237_List {
	static class Fish{
		int no;
		int dir;
		int r;
		int c;
		boolean isAlive = true;
		
		public Fish(int no, int dir, int r, int c, boolean isAlive) {
			this.no = no;
			this.dir = dir;
			this.r = r;
			this.c = c;
			this.isAlive = isAlive;
		}

		Fish() {
			
		}		
	}
	
	static class Shark{
		int dir;
		int r;
		int c;
		int eat;
		
		public Shark(int dir, int r, int c, int eat) {
			this.dir = dir;
			this.r = r;
			this.c = c;
			this.eat = eat;
		}
		
		Shark() {
			
		}
	}
	
	static int maxEat;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map = new int[4][4];
		//static으로 선언했다가 dfs 돌릴 때 머리 아파서 그냥 인자로 넣음
		List<Fish> fishList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				Fish fish = new Fish();
				fish.no = Integer.parseInt(st.nextToken());
				fish.dir = Integer.parseInt(st.nextToken()) -1;
				fish.r = i;
				fish.c = j;
				
				fishList.add(fish);
				map[i][j] = fish.no;
			}
		}
		
		Collections.sort(fishList, new Comparator<Fish>() {
			public int compare(Fish f1, Fish f2) {
				return f1.no - f2.no;
			}
		});
			
		Fish start = fishList.get(map[0][0]-1);//map의 0,0을 찾았어야했는데 인덱스 0을 찾아서 망...
		int startNo = start.no;
		int startDir = start.dir;
		Shark shark = new Shark(startDir, 0, 0, startNo);
		start.isAlive = false;
		map[0][0] = -1;
		maxEat = 0;
		moveShark(map, shark, fishList);
		System.out.println(maxEat);
	}
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; //북 북서 서 남서 남 남동 동 북동
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	
	private static void moveShark(int[][] map, Shark shark, List<Fish> fishList) {
		maxEat = Math.max(maxEat, shark.eat);
		for (Fish fish : fishList) {
			moveFish(fish, map, fishList);
		}
		
		for (int move = 1; move < 4; move++) {//상어는 끝까지 이동할 수 있음. 최대 3칸 더 감
			int nr = shark.r + (dr[shark.dir]*move);
			int nc = shark.c + (dc[shark.dir]*move);
			
			if(!check(nr, nc)) continue;
			if(map[nr][nc] == 0) continue;
			
			int[][] copyMap = copyArr(map);
			List<Fish> copyFish = copyList(fishList);
			
			Fish fish = copyFish.get(map[nr][nc] - 1);//물고기 번호는 1부터 시작!!!
			Shark curShark = new Shark(fish.dir, fish.r, fish.c, shark.eat+fish.no);
			
			copyMap[shark.r][shark.c] = 0;//상어 자리 빈칸
			copyMap[fish.r][fish.c] = -1;//물고기 먹은 자리가 현재 상어 위치
			fish.isAlive = false;
			
			moveShark(copyMap, curShark, copyFish);
		}
	}

	private static void moveFish(Fish fish, int[][] map, List<Fish> fishList) {
		if(!fish.isAlive) return;
		for (int d = 0; d < 8; d++) {
			int newDir = (fish.dir + d) % 8;
			int nr = fish.r+dr[newDir];
			int nc = fish.c+dc[newDir];
			
			if(!check(nr, nc)) continue;
			if(map[nr][nc] == -1) continue;
			
			if (map[nr][nc] == 0) {//빈칸일 때
				map[fish.r][fish.c] = 0;
				fish.r = nr;
				fish.c = nc;
			}else {//자리교환
				Fish temp = fishList.get(map[nr][nc] - 1);//인덱스 번호 하나 작음. 실수하지 말자..
				temp.r = fish.r;
				temp.c = fish.c;
				
				map[fish.r][fish.c] = temp.no;
				
				fish.r = nr;
				fish.c = nc;
			}
			
			map[nr][nc] = fish.no;
			fish.dir = newDir;
			return;
		}
	}
	
	private static int[][] copyArr(int[][] arr){
		int[][] temp = new int[4][4];
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		
		return temp;
	}
	
/*	addAll이 깊은 복사가 된다고 해서 이렇게 메서드 만들었는데 스택오버플로우 맞음
	static List<Fish> copyList(List<Fish> f){
		List<Fish> temp = new ArrayList<>();
		temp.addAll(f);
		return temp;
	}
*/
	private static List<Fish> copyList(List<Fish> fishList) {
	    List<Fish> temp = new ArrayList<>();
	    for (Fish fish : fishList) {
	    	temp.add(new Fish(fish.no, fish.dir, fish.r, fish.c, fish.isAlive));
	    }
	    return temp;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<4 && c>=0 && c<4;
	}

}