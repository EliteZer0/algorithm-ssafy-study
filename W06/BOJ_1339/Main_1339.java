package BOJ_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1339 {
	static int[] alphabetNum;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        alphabetNum = new int[26];//대문자 A가 인덱스 0
        int answer =0;
        int k=9;
        for(int i=0; i<n; i++){
            alphabetToNumber(br.readLine());
        }
        Arrays.sort(alphabetNum);

        for(int i=alphabetNum.length-1; i>=0; i--){
            if(alphabetNum[i] == 0) break;
            else{
                answer += alphabetNum[i]*k;
                k--;
            }
        }
        System.out.println(answer);
    }
    static void alphabetToNumber(String input){
        for(int i=0; i<input.length(); i++){
        	alphabetNum[(int)input.charAt(i)-65] += Math.pow(10,input.length()-(i+1));//대문자 A가 65.
        	//AAA 이면 A*100+A*10+A의 형태이므로 A*10^2 + A*10^1 + A*10^0 으로 이해할 수 있음. 10의 지수는 (길이-1)-- 형
        }
    }
}

/*
 * 주어지는 문자열이 2개인줄 착각하고 잤던 코드
 * 연결 리스트에 문자열을 자릿수대로 저장
 * ABC
 * DEFCA 의 경우
 * DEFACBAC로 저장
 * 98765465로 숫자 연결.
 * 여기까지 돌아가는 거 확인하고 테케 확인하다가 틀린거 보고 묻어둔 코드.
 */
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//
//public class Main_1339 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		char[][] strings = new char[n][];
//		for (int i = 0; i < n; i++) {
//			strings[i] = br.readLine().toCharArray();
//		}
//		LinkedList<Character> alphabet = new LinkedList<>();
//		for (int i = 0; i < n; i++) {
//			alphabet.add(strings[i][strings[i].length-1]);
//		}
//		
//		if(a.length>b.length) {
//			for(int i = 0; i<a.length - b.length; i++) {
//				alphabet.add(a[i]);
//			}
//			for(int i = 0; i<b.length; i++) {
//				alphabet.add(a[i+a.length - b.length]);
//				alphabet.add(b[i]);				
//			}
//		}
//		if(a.length==b.length) {
//			for(int i = 0; i<a.length; i++) {
//				alphabet.add(a[i]);
//				alphabet.add(b[i]);
//			}
//		}
//		if(a.length<b.length) {
//			for(int i = 0; i<b.length - a.length; i++) {
//				alphabet.add(b[i]);
//			}
//			for(int i = 0; i<a.length; i++) {
//				alphabet.add(b[i+b.length-a.length]);
//				alphabet.add(a[i]);				
//			}
//		}
//		
//		StringBuilder sb1 = new StringBuilder();
//		for (int i = 0; i < a.length + b.length; i++) {
//			sb1.append(alphabet.get(i));
//		}
//		System.out.println(sb1.toString());
//		
//		int[] alphabetNum = new int[a.length+b.length];
//		int num = 9;
//		for (int i = 0; i < alphabetNum.length; i++) {
//			if(alphabetNum[i] == 0) {
//				alphabetNum[i] = num--;
//			}
//			for (int j = 0; j < alphabetNum.length; j++) {
//				if(alphabet.get(i) == alphabet.get(j)) {
//					alphabetNum[j] = alphabetNum[i];
//				}
//			}
//		}
//		
//		StringBuilder sb2 = new StringBuilder();
//		for (int i = 0; i < alphabetNum.length; i++) {
//			sb2.append(alphabetNum[i]);
//		}
//		System.out.println(sb2.toString());
//		
//	}
//}
