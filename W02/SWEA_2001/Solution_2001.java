package SWEA_2001;

import java.util.Scanner;

public class Solution_2001 {
    static int n = 0;
    static int m = 0;
    static int[][] flysMap;
    static Scanner sc = new Scanner(System.in);
    static int currentKills = 0;
    static int maxKills = 0;

    public static void main(String[] args) {
        
        int testCase = sc.nextInt();
        
        for(int i = 0; i<testCase; i++){
            n = sc.nextInt();
            m = sc.nextInt();
            makeFlysMap();
            countMaxKills();
            System.out.printf("#%d %d\n",i+1,maxKills);
            maxKills = 0;
        }
    }
    
    public static void makeFlysMap() {
        flysMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flysMap[i][j] = sc.nextInt();
            }
        }
    }

    public static void countMaxKills() {
        for (int i = 0; i <= n-m; i++) {
            for (int j = 0; j <= n-m; j++) {
                for(int p = 0; p<m; p++){
                    for(int q= 0; q<m; q++){
                        currentKills += flysMap[i+p][j+q];
                    }
                } 
                maxKills = Math.max(maxKills, currentKills);
                currentKills = 0;
            }
        }
    }
}
