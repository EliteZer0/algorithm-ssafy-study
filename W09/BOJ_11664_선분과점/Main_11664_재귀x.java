package BOJ_11664_선분과점;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//14476kb 104ms
public class Main_11664_재귀x {
	static double min = Double.MAX_VALUE;
	static coordinate A;
	static coordinate B;
	static coordinate C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ax = Integer.parseInt(st.nextToken());
		int ay = Integer.parseInt(st.nextToken());
		int az = Integer.parseInt(st.nextToken());
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());
		int bz = Integer.parseInt(st.nextToken());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());
		int cz = Integer.parseInt(st.nextToken());
		
		A = new coordinate(ax, ay, az);
		B = new coordinate(bx, by, bz);
		C = new coordinate(cx, cy, cz);
		
		Search(A, B);
		//제곱근 연산 최소화. 정답 출력시에만 사용.
		System.out.println(Math.sqrt(min));		
	}
	
	static void Search(coordinate start, coordinate end) {
		//재귀 호출 대신 반복문으로 변경
		while(true) {
			double temp = Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2) + Math.pow(start.z - end.z, 2);		
			//0으로 두면 무한루프 돌아서 오차범위 체크하는 로직 추가
			if(-1*1e-12 <= temp && temp <= 1e-12) return;
			//mid 설정
			coordinate key = new coordinate((start.x+end.x)/2, (start.y+end.y)/2, (start.z+end.z)/2);
			double length = Math.pow(key.x - C.x, 2) + Math.pow(key.y - C.y, 2) + Math.pow(key.z - C.z, 2);
			
			min = Math.min(min, length);
			
			//left right 설정
			double startC = Math.pow(start.x - C.x, 2) + Math.pow(start.y - C.y, 2) + Math.pow(start.z - C.z, 2);
			double endC = Math.pow(end.x - C.x, 2) + Math.pow(end.y - C.y, 2) + Math.pow(end.z - C.z, 2);
		
			if(startC > endC) {
				start = key;
			}else {
				end = key;
			}
		}
	}
}

class coordinate {
	double x;
	double y;
	double z;
	public coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
