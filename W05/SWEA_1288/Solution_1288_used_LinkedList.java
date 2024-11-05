package SWEA_1288;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
//import java.util.Arrays;

public class Solution_1288_used_LinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tcNum = 1; tcNum < T+1; tcNum++) {
            int[] count = new int[10];
            int n = Integer.parseInt(br.readLine());
            
            LinkedList<Integer> sheep = new LinkedList<>();
            int trys = 1;
            int newNums = n;
            
            while(true) {
                boolean isZero = false;
                newNums = n*trys;
                String input = String.valueOf(newNums);

                for (int i = 0; i < input.length(); i++) {
                    sheep.add(input.charAt(i) - '0');
                    count[sheep.poll()]++;
                }
                //System.out.println("int[] count "+trys+" : " + Arrays.toString(count));
                for (int j = 0; j < 10; j++) {
                    if(count[j]==0){
                        isZero = true;
                        continue;
                    }
                }
                if(isZero){
//                    n /= trys;
                    trys++;
//                    n *= trys;
                }else{
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tcNum).append(" ").append(newNums);//마지막으로 보는 숫자를 출력하라고 했는데... trys를 출력하니 답이 안나오지...
            System.out.println(sb.toString());
        }
    }
}