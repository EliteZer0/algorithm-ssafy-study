package SWEA_1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tcNum = 1; tcNum < t+1; tcNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] wordPuzzle = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer row = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    wordPuzzle[i][j] = Integer.parseInt(row.nextToken());
                }   
            }
            int count = 0;
            int wordLength = 0;

            for (int i = 0; i < n; i++) {
                wordLength = 0;
                for (int j = 0; j < n; j++) {
                    if(wordPuzzle[i][j] == 1){
                        wordLength ++;
                    }
                    if(j==n-1 || wordPuzzle[i][j] !=1){
                        if (wordLength == k){
                            count ++;
                        }
                        wordLength = 0;
                    }
                }

                wordLength = 0;
                for (int j = 0; j < n; j++) {
                    if(wordPuzzle[j][i] == 1){
                        wordLength ++;
                    }
                    if(j == n-1 || wordPuzzle[j][i] != 1){
                        if (wordLength == k){
                            count ++;
                        }
                        wordLength = 0;
                    }
                }
            }

            System.out.printf("#%d %d\n",tcNum,count);
        }
    }
}
