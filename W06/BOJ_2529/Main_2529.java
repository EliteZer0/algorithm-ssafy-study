package BOJ_2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2529 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        char[] inequality = br.readLine().replace(" ", "").toCharArray();
        
        int[] maxArr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] minArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //max 값 정렬 로직
        for (int i = 0; i < k; i++) {
            if (inequality[i] == '<') {
                for (int j = i + 1; j <= k; j++) {
                    if (j == k || inequality[j] == '>') {
                        Arrays.sort(maxArr, i, j + 1);
                        break;
                    }
                }
            }
        }
        //min 값 정렬 로직
        for (int i = 0; i < k; i++) {
            if (inequality[i] == '>') {
                for (int j = i + 1; j <= k; j++) {
                    if (j == k || inequality[j] == '<') {
                    	int temp = minArr[j];
						for (int l = i; l <=j; l++) {
							minArr[l] = temp--;
						}
						i = j;
                        break;
                    }
                }
            }
        }
        StringBuilder max = new StringBuilder();
        for (int i = 0; i <= k; i++) {
            max.append(maxArr[i]);
        }
        System.out.println(max.toString());
        
        StringBuilder min = new StringBuilder();
        for (int i = 0; i <= k; i++) {
            min.append(minArr[i]);
        }
        System.out.println(min.toString());
    }
}
/*
 * 로직 설명 
 * 최댓값 : 내림차순으로 정렬된 배열에서 <을 만나면 >을 만날 때까지 오름차순으로 정렬.
 * 9 8 7 6 5 4 3 2 1 0
 * 	> < < < > > > < <
 * 9 5 6 7 8 4 3 0 1 2
 * 최솟값 : 오름차순으로 정렬된 배열에서 >을 만나면 <을 만날 때까지 내림차순으로 정렬.
 * 0 1 2 3 4 5 6 7 8 9
 * 	> < < < > > > < <
 * 1 0 2 3 7 6 5 4 8 9
 * 이런식으로 정렬된 배열을 k+1 개만큼 뽑아내면 최대 최소 성립.
 * 
 * 후위연산식처럼 스택 써서 풀 수도 있지 않을까..? 스터디 문제 다 풀면 시도해보는 걸로.
 */