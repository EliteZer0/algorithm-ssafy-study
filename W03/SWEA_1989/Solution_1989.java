package SWEA_1989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tcNum = 1; tcNum < t+1; tcNum++) {
            boolean isPalindrome = true;
            char[] input = br.readLine().toCharArray();
            for (int i = 0; i < input.length/2; i++) {
                if (input[i] != input[input.length-1-i]){
                    isPalindrome = false;
                }
            }

            System.out.printf("#%d %d",tcNum, isPalindrome? 1 : 0);
        }
    }
}
