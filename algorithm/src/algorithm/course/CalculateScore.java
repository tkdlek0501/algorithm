package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #19 점수 계산
// ox 문제는 맞거나 틀린 두 경우의 답을 가지는 문제 
// 여러개의 ox 문제들 중 연속적으로 답을 맞히는 경우에는 가산점을 주기 위해 다음과 같은 방법을 사용하기로 하였다
// 1번 문제가 맞는 경우에는 1점, 연속으로 답을 맞히는 경우에는 1점씩 추가 (문제 당 2점, 3점..)
// 문제를 틀렸을 경우에는 0점으로 계산한다

// 입력
// 첫째 줄에 문제의 개수 N (1<= N <= 100) 이 주어진다
// 둘째 줄에는 N개의 문제의 채점 결과 (틀렸을 때 0, 맞았을 때 1)가 빈 칸으로 구분해서 주어진다

// 출력 
// 가산점을 고려한 총 점수를 출력

public class CalculateScore {
	
	public Integer solution(int n, int[] arr) {
		int answer=0, cnt=0;
		for(int i=0; i<n; i++) {
			if(arr[i]==1) { // 정답이면
				cnt++; // cnt(점수)의 값 1 증가
				answer+=cnt; // cnt를 누적
			} else cnt = 0; // 답이 아닌 경우 갱신
		}
		return answer;
	}
	
	public static void main(String[] args) {
		CalculateScore T = new CalculateScore();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, arr));
	}
}
