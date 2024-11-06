package BOJ_10986_나머지합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 처음에는 부분집합의 개수만큼 배열을 만들어서 원소의 합을 전부 저장하려고 생각함.
// 시간, 메모리 측면에서 불가능할 것 같아서 고민 -> 어차피 나누는 거면 나머지가 같은 부분집합의 개수를 알면 됨.
// 누적합문제로 접근
public class Main_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        long[] count = new long[m]; // 나머지가 같은 값의 개수를 저장
        long sum = 0;
        long result = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
            int remainder = (int)(sum % m);
            if (remainder == 0) result++; //1부터 i까지의 합이 3으로 나눈 나머지가 0인 경우 바로 결과에 반영
            count[remainder]++;
        }
        
        // 나머지가 같은 값들 중 2개를 선택하는 조합을 계산
        // 예를 들어 3으로 나눈 나머지가 같은 {1,2,3} {1,2} 를 선택했을 때 둘의 차집합인 {3}도 3으로 나눈 나머지가 0이기 때문
        for (int i = 0; i < m; i++) {
            if (count[i] > 1) {
                result += (count[i] * (count[i] - 1)) / 2;
            }
        }
        
        System.out.println(result);
    }
}
