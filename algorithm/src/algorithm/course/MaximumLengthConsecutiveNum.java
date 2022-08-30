package algorithm.course;

import java.util.Scanner;

// #30 최대 길이 연속부분수열
// 0과 1로 구성된 길이가 N인 수열이 주어진다
// 이 수열에서 최대 k번을 0을 1로 변경할 수 있다
// 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속 부분 수열을 찾는 프로그램을 작성하세요
// ex) 1 1 0 0 1 1 0 1 1 0 1 1 0 1
// 8

// 입력
// 첫번째 줄에 수열의 길이인 자연수 N(5<=N<=100,000) 과 k가 주어진다
// 두번째 줄에 N 길이의 0과 1로 구성된 수열이 주어진다

// 출력
// 첫 줄에 최대 길이를 출력

//	14 2
//	1 1 0 0 1 1 0 1 1 0 1 1 0 1
//	8

public class MaximumLengthConsecutiveNum {
	
	public int solution(int n, int k, int[] arr) {
		// two pointer 알고리즘 이용
		// rt가 증가하면서 0을 1로 바꿔주고 연속된 길이를 구한다
		// cnt : 0을 1로 바꾼 횟수
		int answer = 0, cnt = 0, lt = 0;
		for(int rt = 0; rt < n; rt++) {
			if(arr[rt]==0) cnt++; // 가리키는 곳이 0이면 1로 바꿨다 생각하고 바꾼 횟수 증가
			while(cnt > k) { // cnt가 최대 횟수를 넘어선다면
				if(arr[lt]==0) cnt--; // lt가 가리키는 곳이 1로 변경된 곳이라면 0으로 다시 바꾼다 생각하고 바꾼 횟수 감소
				lt++;
			}
			answer = Math.max(answer, rt-lt+1);
		}
		
		return answer;
	}
	
	// rt가 증가하면서 0을 1로 바꾸고 
	// 단순히 answer을 갱신
	// 만약 바꾼 횟수가 k를 넘으면 
	// lt가 증가하기 시작하면서 0이 었던 곳을 찾아내서 되돌림
	// 이때 lt를 1 증가시키고 나서 answer을 비교하며 갱신
	
	public static void main(String[] args) {
		MaximumLengthConsecutiveNum T = new MaximumLengthConsecutiveNum();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i]=kb.nextInt();
		}
		
		System.out.print(T.solution(n, k, arr));
		
	}
}
