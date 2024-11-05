package SWEA_2007;

import java.util.Scanner;

public class Solution_2007 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();

		int patternLength = 0;
		String patternStr = "";
		char[] patternArr = new char[30];

		for(int i = 0; i<testcase; i++){
			patternStr = sc.nextLine();
			patternArr = patternStr.toCharArray();
						
			patternLength = 1;
			while(patternLength<patternArr.length && patternArr[0]!=patternArr[patternLength]){
				patternLength++;
			}
			while(patternLength<patternArr.length && patternArr[patternLength]!=patternArr[patternLength*2]){
				patternLength++;
			}

			System.out.printf("#%d %d",i+1,patternLength);		
			System.out.println();
		}
	}
}