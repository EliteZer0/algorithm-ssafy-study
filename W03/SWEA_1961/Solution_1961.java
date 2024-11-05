package SWEA_1961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        for (int tcNum = 1; tcNum < t+1; tcNum++) {
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
    
            int[][] matrix90 = new int[n][n];
            for(int i = 0; i<n; i++){
                for (int j = 0; j < n; j++) {
                    matrix90[j][n-1-i] = matrix[i][j];
                }
            }
            
            int[][] matrix180 = new int[n][n];
            for(int i = 0; i<n; i++){
                for (int j = 0; j < n; j++) {
                    matrix180[j][n-1-i] = matrix90[i][j];
                }
            }
            int[][] matrix270 = new int[n][n];
            for(int i = 0; i<n; i++){
                for (int j = 0; j < n; j++) {
                    matrix270[j][n-1-i] = matrix180[i][j];
                }
            }
            
            System.out.println("#"+tcNum);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix270[i][j]);
                }                    
                System.out.println();
            }            
        }
    }
}