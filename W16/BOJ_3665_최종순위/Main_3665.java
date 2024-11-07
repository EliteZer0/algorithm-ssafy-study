package BOJ_3665_최종순위;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3665 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            int[] inDegree = new int[N+1];
            int[] lastY = new int[N+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<N+1; i++) {
            	lastY[i] = Integer.parseInt(st.nextToken());
            }
            
            List<Integer>[] list = new ArrayList[N+1];
            for(int i=1; i<N+1; i++)
                list[i] = new ArrayList<>();
            
            // 작년 순위를 바탕으로 각 선수보다 낮은 순위의 선수들과의 관계
            for(int i=1; i<N+1; i++) {
                int from = lastY[i];
                for(int j=i+1; j<N+1; j++) {
                    list[from].add(lastY[j]);  // from -> array[j] 방향으로 간선 추가
                    inDegree[lastY[j]]++;      // 진입차수 증가
                }
            }
            
            int M = Integer.parseInt(br.readLine());
            for(int i=0; i<M; i++) {
            	st = new StringTokenizer(br.readLine());
                int up = Integer.parseInt(st.nextToken());
                int down = Integer.parseInt(st.nextToken());
                
                // 기존 간선의 방향을 반대로 변경
                if(list[up].contains(down)) {
                    list[up].remove((Integer)down);
                    list[down].add(up);
                    inDegree[up]++;
                    inDegree[down]--;
                } else {
                    list[down].remove((Integer)up);
                    list[up].add(down);
                    inDegree[down]++;
                    inDegree[up]--;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            Queue<Integer> queue = new LinkedList<>();
            
            // 진입차수가 0인 정점 찾기 (시작점)
            int cnt=0;
            for(int i=1; i<=N; i++) {
                if(inDegree[i]==0) {
                    cnt++;
                    queue.add(i);
                }
            }
            
            // 시작점이 여러 개인 경우 순위를 확실히 알 수 없음
            if(cnt>1) {
                System.out.println("?");
                continue;
            }
            
            int result=0;
            boolean isFinished = false;
            
            // 위상정렬
            for(int i=1; i<=N; i++) {
                // 큐가 비어있다면 사이클이 존재한다는 의미
                if(queue.isEmpty()) {
                    System.out.println("IMPOSSIBLE");
                    isFinished=true;
                    break;
                }
                
                int from = queue.poll();
                result++;
                sb.append(from).append(" ");
                
                // 현재 정점과 연결된 정점들의 진입차수 감소
                for(int to : list[from]) {
                    inDegree[to]--;
                    if(inDegree[to]==0) queue.add(to);
                }
            }
            if(isFinished==true) continue;
            
            System.out.println(sb.toString());
        }
    }
}
