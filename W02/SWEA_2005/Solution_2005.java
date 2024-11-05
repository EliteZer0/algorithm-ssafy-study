package SWEA_2005;

import java.util.Scanner;

public class Solution_2005 {
    static int n = 0;
    static int size = 1;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        int testcases = sc.nextInt();
        for(int i = 0; i<testcases; i++){
            System.out.printf("#%d\n", i+1);
            makeTriangle();
        }
    }
    
    public static void makeTriangle() {
        n = sc.nextInt();
        int[][] pascalTriangle = new int[n][n];
        for (int i = 0 ; i<n; i++){
        	for(int j= 0; j<i+1; j++) {
        		if(i>1 && j>0) {
        			pascalTriangle[i][j] = pascalTriangle[i-1][j-1]+pascalTriangle[i-1][j];
        		}else {
        			pascalTriangle[i][j] = 1;
        		}
        		
        	}
        }
        
        for (int i =0 ; i<n; i++){
        	for(int j = 0; j<i+1; j++) {
            System.out.printf("%d ", pascalTriangle[i][j]);
        	}
        	System.out.println();
        }
        
    }
}
