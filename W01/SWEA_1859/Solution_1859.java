package SWEA_1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        for (int trys = 0; trys < testcases; trys++) {
            int days = Integer.parseInt(br.readLine());
            int[] prices = new int[days];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < days; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            int maxPrice = 0;
            
            for (int i = days - 1; i >= 0; i--) {

                if (maxPrice < prices[i]) {
                    maxPrice = prices[i];
                }

                profit += maxPrice - prices[i];
            }
            System.out.printf("#%d %d\n", trys + 1, profit);
        }
    }
}
