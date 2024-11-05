package SWEA_1926;

import java.util.Scanner;

public class Solution_1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {

            int hundreds = i / 100;
            int tens = i / 10;
            int unit = i % 10;

            if (hundreds == 3 || hundreds == 6 || hundreds == 9) {
                System.out.print("-");
            }

            if (tens == 3 || tens == 6 || tens == 9) {
                System.out.print("-");
            }

            if (unit == 3 || unit == 6 || unit == 9) {
                System.out.print("-");
            }

            if (hundreds != 3 && hundreds != 6 && hundreds != 9 && tens != 3 && tens != 6 && tens != 9 && unit != 3
                    && unit != 6 && unit != 9) {
                System.out.print(i);
            }
            System.out.print(" ");

        }
    }
}