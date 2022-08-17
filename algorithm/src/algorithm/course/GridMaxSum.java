package algorithm.course;

import java.util.Scanner;

// #21 격자판 최대합
// N * N 격자판의 각 칸마다 숫자가 적혀있고
// 각 행의 합, 각 열의 합, 두 대각선의 합 중 가장 큰 것을 출력

// 입력 
// 첫 줄에 자연수 N이 주어진다 (2<=N<=50)
// 두번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다 (각 자연수는 100을 넘지 않는다)
// 5
//	10 13 10 12 15
//	12 39 30 23 11
//	11 25 50 53 15
//	19 27 29 37 27
//	19 13 30 13 19

// 출력 
// 최대합을 출력
// 155

public class GridMaxSum {
	
	public int solution(int n, int[][] arr) {
		int answer = 0;
		int sum1, sum2; // 행과 열의 합
		
		for(int i = 0; i < n; i++) { // 첫번째 행 or 열 부터 
			sum1=sum2=0;
			for(int j = 0; j < n; j++) { // 해당 행 or 열 줄의 합
				sum1+=arr[i][j]; 
				sum2+=arr[j][i];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);	
		}
		sum1=sum2=0; // 왼쪽 대각선, 오른쪽 대각선의 합
		for(int i = 0; i<n; i++) { // 대각선 합 구하기
			sum1+=arr[i][i];
			sum2+=arr[i][n-i-1];
		}
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);
		
		return answer;
	}
	
	public static void main(String[] args) {
		GridMaxSum T = new GridMaxSum();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
		
	}
}
