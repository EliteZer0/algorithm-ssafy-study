package SWEA_1926;

import java.util.Scanner;

public class Solution_1926_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {

            int hundreds = i / 100;
            int tens = i / 10;
            int unit = i % 10;

            boolean hundredsClap = (hundreds == 3 || hundreds == 6 || hundreds == 9);
            boolean tensClap = (tens == 3 || tens == 6 || tens == 9);
            boolean unitClap = (unit == 3 || unit == 6 || unit == 9);
            boolean clap = (hundredsClap || tensClap || unitClap);

            if (hundredsClap) {
                System.out.print("-");
            }

            if (tensClap) {
                System.out.print("-");
            }

            if (unitClap) {
                System.out.print("-");
            }

            if (!clap) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}