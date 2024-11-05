package BOJ_2922_즐거운단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//시간초과
public class Main_2922_1_timeout {
	static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
	static char[] consonants = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
	static char[] word;
	static int count;
	static ArrayList<Integer> underscorePositions;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        word = input.toCharArray();
        underscorePositions = new ArrayList<>();
        
        for (int i = 0; i < word.length; i++) {
			if(word[i] == '_') {
				underscorePositions.add(i);
			}
		}
        count = 0;
        
        find(0, false);
        
        System.out.println(count);
    }
	private static void find(int idx, boolean hasL) {
		if (idx == underscorePositions.size()) {
            if (isValid(word) && hasL) {
                count++;
            }
            return;
        }
		
		int pos = underscorePositions.get(idx); // 현재 채울 밑줄 위치
        
        // 모음으로 채우기
        for (char v : vowels) {
            word[pos] = v;
            find(idx + 1, hasL);
        }

        // 자음으로 채우기
        for (char c : consonants) {
            word[pos] = c;
            find(idx + 1, hasL || c == 'L');
        }

        word[pos] = '_';
	}
	
	private static boolean isValid(char[] word2) {
		int vCnt = 0;
		int cCnt = 0;
		for(char c : word) {
			if(isVowel(c)) {
				vCnt++;
				cCnt = 0;
			}else {
				cCnt++;
				vCnt = 0;
			}
			if(vCnt >= 3 || cCnt >= 3) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isVowel(char c) {
		for (char v : vowels) {
            if (v == c) {
                return true;
            }
        }
        return false;
	}
}
