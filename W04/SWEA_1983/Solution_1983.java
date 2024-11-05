package SWEA_1983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1983 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int performance = 3;
		
		for (int tcNum = 1; tcNum <T+1; tcNum++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int studentNum = Integer.parseInt(st.nextToken());
			
			int[][] studentsScores = new int[N][performance];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < performance; j++) {
					studentsScores[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			double [] studentsScoreAvg = new double[N];
			
			for (int i = 0; i < N; i++) {
				double sum = 0.35*studentsScores[i][0] + 0.45*studentsScores[i][1] + 0.20*studentsScores[i][2];
				studentsScoreAvg[i] = sum;
			}
			double[] scoreRanking = studentsScoreAvg.clone();
			
			Arrays.sort(scoreRanking);			
			
			String[] score = new String[N];
			int count = 0;
			int getRank = N/10;
			
			while(count<N) {
				
				for (int i = 0; i < getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "D0";
							count++;
						}
					}
				}
				
				for (int i = getRank; i < 2*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "C-";
							count++;
						}
					}
				}
				
				for (int i = 2*getRank; i < 3*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "C0";
							count++;
						}
					}
				}
				
				for (int i = 3*getRank; i < 4*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "C+";
							count++;
						}
					}
				}
				
				for (int i = 4*getRank; i < 5*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "B-";
							count++;
						}
					}
				}
				
				for (int i = 5*getRank; i < 6*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "B0";
							count++;
						}
					}
				}
				
				for (int i = 6*getRank; i < 7*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "B+";
							count++;
						}
					}
				}
				
				for (int i = 7*getRank; i < 8*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "A-";
							count++;
						}
					}
				}
				
				for (int i = 8*getRank; i < 9*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "A0";
							count++;
						}
					}
				}
				
				for (int i = 9*getRank; i < 10*getRank; i++) {
					for (int j = 0; j < N; j++) {
						if(scoreRanking[i] == studentsScoreAvg[j]) {
							score[j] = "A+";
							count++;
						}
					}
				}
			}
			System.out.printf("#%d %s\n",tcNum, score[studentNum-1]);
		}
	}	
}
