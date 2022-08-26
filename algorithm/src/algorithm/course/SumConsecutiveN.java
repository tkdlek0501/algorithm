package algorithm.course;

import java.util.Scanner;

// #28 연속된 자연수의 합

// N 입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수  N 을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요
// 만약 N=15 이면
// 7+8, 4+5+6, 1+2+3+4+5 로 3가지의 경우가 존재

// 입력
// 첫번째 줄에 양의 정수 N(7<=N<1000) 이 주어진다

// 출력
// 첫 줄에 총 경우수를 출력

public class SumConsecutiveN {
	
	public int solution(int n) {
		// two pointer 를 사용
		// lt와 rt를 사용
		// rt를 증가하며 sum을 구함
		// sum을 넘어서는 순간 lt를 증가하면서 기존 lt값 빼주기
		int answer = 0, sum=0, lt=0;
		int m = n/2+1; // n이 만약 15이면 8까지만 계산하면 된다 
		int[] arr = new int[m];
		for(int i = 0; i < m; i++) arr[i]=i+1; // 1부터 넣어준다
		
		for(int rt=0; rt < m; rt++) {
			sum += arr[rt]; // index 0(lt)부터 rt까지의 합
			if(sum == n) answer++;
			while(sum > n) { // sum을 넘어서는 순간부터는 lt를 증가
				sum-=arr[lt++];
				if(sum==n) answer++;
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		SumConsecutiveN T = new SumConsecutiveN();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		
		System.out.print(T.solution(n));
		
	}
}
