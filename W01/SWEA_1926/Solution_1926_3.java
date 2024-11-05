package SWEA_1926;

import java.util.Scanner;

public class Solution_1926_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n + 1; i++) {

            String num = String.valueOf(i);
            boolean clap = false;

            char[] nums = num.toCharArray();

            for (char c : nums) {
                if (c == '3' || c == '6' || c == '9') {
                    System.out.print("-");
                    clap = true;
                }
            }

            if (!clap) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}