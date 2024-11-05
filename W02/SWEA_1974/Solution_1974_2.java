package SWEA_1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1974_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] sudokuMap = new int[9][9];
    static boolean isColUnique = false;
    static boolean isRowUnique = false;
    static boolean isSquareUnique = false;
    
    public static void main(String[] args) throws IOException {
        

    	int testcase = Integer.parseInt(br.readLine());
    	
    	for (int i = 0; i<testcase; i++) {

    		makeSudokuMap();
    		
    		checkSqure();
	    	checkRow();
	        checkCol();
	        
            printing(i);
	        
    	}
    }
    
    public static void makeSudokuMap() throws IOException {
    	for(int i = 0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j<9; j++) {
    			sudokuMap[i][j] = Integer.parseInt(st.nextToken());
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

    public static void printing(int i){
        if(isColUnique && isRowUnique && isSquareUnique) {
            System.out.printf("#%d %d\n", i+1, 1);
        }else {
            System.out.printf("#%d %d\n", i+1, 0);
        }
    }
}

