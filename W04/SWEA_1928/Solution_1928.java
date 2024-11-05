package SWEA_1928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Solution_1928 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tcNum = 1; tcNum < T+1; tcNum++) {
			String input = br.readLine();
			byte[] targetBytes = input.getBytes();
			
			Decoder decoder = Base64.getDecoder();
			byte[] decodedBytes = decoder.decode(targetBytes);			
			
			System.out.printf("#%d %s\n",tcNum,new String(decodedBytes));
		}
	}
}
