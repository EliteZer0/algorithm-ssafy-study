package SWEA_1974;

import java.util.Scanner;

public class Solution_1974 {

    static int[][] sudokuMap = new int[9][9];
    static boolean isColUnique = false;
    static boolean isRowUnique = false;
    static boolean isSquareUnique = false;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    	int testcase = sc.nextInt();
    	
    	for (int i = 0; i<testcase; i++) {
    		makeSudokuMap();
    		
    		checkSqure();
	    	checkRow();
	        checkCol();
	        
	        if(isColUnique && isRowUnique && isSquareUnique) {
	        	System.out.printf("#%d %d\n", i+1, 1);
	        }else {
	        	System.out.printf("#%d %d\n", i+1, 0);
	        }
    	}
    }
    
    public static void makeSudokuMap() {
    	for(int i = 0; i<9; i++) {
    		for(int j = 0; j<9; j++) {
    			sudokuMap[i][j] = sc.nextInt();
    		}
    	}
    }
    
    public static void checkRow() {
        for(int i =0; i<9; i++) {
        	int[] count = new int[10];
        	for(int j =0; j<9; j++) {
        		int num = sudokuMap[i][j];
        		if (count[num] > 0) {
                    isRowUnique = false;
                    return;
                }
        		count[num] ++;
        	}
        }
        isRowUnique = true;
    }

    public static void checkCol() {
        for(int i =0; i<9; i++) {
        	int[] count = new int[10];
        	for(int j =0; j<9; j++) {
        		int num = sudokuMap[j][i];
        		if (count[num] > 0) {
                    isColUnique = false;
                    return;
                }
        		count[num] ++;
        	}
        }
        isColUnique = true;
    }
 
    public static void checkSqure(){
	    for(int location = 0; location<9; location++) {
	    	int[] count = new int[10];
	        for(int i =0; i<3; i++) {
	        	for(int j =0; j<3; j++) {
	        		int row = 3*(location/3)+i; //(0-2,3-5,6-8)
	        		int col = 3*(location/3)+j; //(0-2,3-5,6-8)
	        		
	        		int num = sudokuMap[row][col];
	        		if (count[num] > 0) {
                        isSquareUnique = false;
                        return;
                    }
	        		count[num] ++;
	        	}
	        }
	    }
        isSquareUnique = true;
    }
}

