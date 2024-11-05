package SWEA_1204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        int students = 1000;
        int[] scores = new int[students];
        
        for(int i = 0; i<t; i++){
            int testcaseNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] counts = new int[101];
            int index = 0;
            int modeCount = 0;
            int modeScore = 0;

            for (int j = 0; j <students ; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }
    
            for (int j = 0; j < students; j++) {
                index = scores[j];
                counts[index]++;
            }
            
            for (int j = 0; j < 101; j++){
                if(modeCount<counts[j]){
                    modeCount = counts[j];
                    modeScore = j;
                }else if(modeCount == counts[j]){
                    modeScore = Math.max(modeScore,j);
                }
            }

            System.out.printf("#%d %d\n",testcaseNum, modeScore);
        }
        
    }
}
