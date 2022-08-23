package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #26 최대 매출
// N 일 동안의 매출 기록을 줬을 때
// 연속된 K 일 똥안 최대 매출액이 얼마인지 구하는 프로그램 작성하세요
// 만약 N = 10 이고 10일 간의 매출 기록이 아래와 같을 때 연속된 일수 K = 3이면
// 12 15 11 20 25 10 20 19 13 15
// 에서 연속 3일 최대 매출액 : 11 + 20 +25 입니다

// 입력 
// 첫 줄에 N(5<=N<=100,000) 과 K(2<=K<=N)이 주어집니다
// 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다
//	10 3
//	12 15 11 20 25 10 20 19 13 15

// 출력
// 첫 줄에 연속된 일 수 최대 매출액을 출력합니다
// 56

public class SlidingWindow {
	
	public int solution(int n, int k, int[] arr) {
		int answer = 0;
		int tmp = 0;
		// 연속된 3일 이라고 가정하면
		// 0, 1, 2 / 1, 2, 3 / 2, 3, 4 ... 의 합을 구해서 비교해야 한다
		// 단순히 2중 for문으로 작성하면 O(n^2)의 시간 복잡도 -> O(n) 으로 작성해야 한다
		// k 범위를 옆으로 밀면서 합을 구하는 식으로 계산
		// 맨 좌쪽 값은 제거하고 맨 우측 값은 추가하는 방법으로 계산 
		for(int i = 0; i < k; i++) {
			tmp += arr[i];
		}
		answer = tmp;
		
		for(int i = k; i < n; i++) { // (0) 1 2 3 
			tmp += (arr[i] - arr[i-k]);
			//if(answer < tmp) answer = tmp;
			answer = Math.max(answer, tmp);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		SlidingWindow T = new SlidingWindow();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		int k = kb.nextInt();
		
		for(int i = 0; i < n; i++) { 
			arr[i]=kb.nextInt();
		}	
		
		System.out.print(T.solution(n, k, arr));
		
	}
}
