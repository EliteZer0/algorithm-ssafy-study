package SWEA_1859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859_too_slow {
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
            int purchase = 0;
            int sale = 0;

            for (int i = 0; i < days; i++) {
                sale = 0;
                purchase = 0;
                maxPrice = 0;

                for (int j = 1; j < days; j++) {
                    if (prices[i] < prices[j]) {
                        purchase = prices[i];
                        continue;
                    }
                }

                // System.out.println(purchase);

                for (int j = i; j < days; j++) {
                    if (maxPrice < prices[j]) {
                        maxPrice = prices[j];
                    }
                }

                // System.out.println(maxPrice);

                if (purchase != 0 && maxPrice != 0) {
                    sale = (maxPrice - purchase);
                }

                // System.out.println(sale);

                profit += sale;
            }
            System.out.printf("#%d %d\n", trys + 1, profit);
        }
    }
}
