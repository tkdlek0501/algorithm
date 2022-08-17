package algorithm.course;

import java.util.Scanner;

// #20 등수구하기
// N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요
// 같은 점수가 입력될 경우 높은 등수로 동일 처리한다. 즉 가장 높은 점수가 92점인데
// 92점이 3명이 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다 

// 입력
// 첫 줄에 N(3<=N<=100)이 입력되고, 두번째 줄에 국어점수를 의미하는 N 개의 정수가 입력된다 

// 출력 
// 입력된 순서대로 등수를 출력한다

public class Rank {
	
	public int[] solution(int n, int[] arr) {
		int[] answer = new int[n];
		
		// 2중 for문을 돌려서 arr[i]의 값이 다른 값보다 작은 경우 등수를 뒤로 미룬다
		
		for(int i=0; i<n; i++) { // i 번째 점수를
			int rank = 1;
			for(int j=0; j<n; j++) { // j번째 점수들과 비교
				if(arr[i] < arr[j]) {
					rank++;
				}
			}
			answer[i] = rank;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Rank T = new Rank();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int answer : T.solution(n, arr)) {
			System.out.print(answer + " ");
		}
		
	}
}
