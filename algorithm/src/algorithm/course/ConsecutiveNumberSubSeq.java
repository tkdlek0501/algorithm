package algorithm.course;

import java.util.Scanner;

// #27 연속 부분수열
// N 개의 수로 이루어진 수열이 주어지면
// 이 수열에서 연속 부분 수열의 합이 특정 숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램 작성
// 만약 N=8, M=6이고 수열이 
// 1 2 1 3 1 1 1 2 이면
// 합이 6이 되는 연속 부분 수열은 {2,1,3}, {1,3,1,1}, {3,1,1,1} 로 총 3가지

// 입력 
// 첫쨰 줄에 N(1<=N<=100,000), M(1<=M<=100,000,000) 이 주어진다
// 수열의 원소값은 1,000 을 넘지 않는 자연수이다

// 출력
// 첫째 줄에 경우의 수를 출력한다


public class ConsecutiveNumberSubSeq {
	
	public int solutionNN(int n, int m, int[] arr) {
		// n개의 수열에서 합이 M이 되는지 구하려면
		// 2중 for문을 이용하면 된다
		// i = 0 일때 부터 시작해서 j(i+1) 을 ++ 하면서 더하다가 M이 되는지를 판단하면 된다
		// O(n^2) 으로 풀기 보다는 O(n) 으로 풀어내야 한다
		int answer = 0;
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = i; j < n; j++) {
				sum += arr[j];
				if(sum == m) {
					answer++;
					break;
				}
			}
		}
		return answer;
	}
	
	public int solution(int n, int m, int[] arr) {
		// O(n) 으로 푸는 방법
		// two pointer 알고리즘을 활용
		// lt와 rt를 만들어서 구현
		// rt까지의 합에서 lt가 rt를 따라오게 하면서 더하는 범위를 좁혀 나가는 방법
		int answer = 0, sum = 0, lt = 0;
		for(int rt = 0; rt < n; rt++) {
			sum += arr[rt]; // rt까지의 합
			if(sum == m) answer++;
			while(sum > m) { // rt까지의 합인 sum에서 기존 lt를 빼주고 lt를 증가시킨다
				 sum -= arr[lt++]; // lt가 다음 rt 반복에도 반영돼있게 한다 (범위를 좁힘)
				 if(sum == m) answer++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		ConsecutiveNumberSubSeq T = new ConsecutiveNumberSubSeq();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		int m = kb.nextInt();
		
		for(int i = 0; i < n; i++) { 
			arr[i]=kb.nextInt();
		}	
		
		System.out.print(T.solution(n, m, arr));
		
	}
}
