package SWEA_1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for(int tcNum = 1; tcNum<t+1; tcNum++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); 
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            int aWBill = w*p;
            int bWBill = 0;

            //기본 사용량 초과시에만 초과 요금 적용
            if(w>r){
                bWBill = q + (w-r)*s;
            }else{
                bWBill = q;
            }
            
            int minBill = Math.min(aWBill,bWBill);

            System.out.printf("#%d %d\n",tcNum, minBill);
        }
    }
}
