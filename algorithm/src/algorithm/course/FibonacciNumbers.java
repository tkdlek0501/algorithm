package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #16 피보나치 수열
// 앞의 2개의 수를 합하여 다음 숫자가 되는 수열

// 입력
// 첫 줄에 총 항수 N(3<=N<=45)가 입력
// 7이 입력되면 1 1 2 3 5 8 13 출력

// 출력
// 첫 줄에 피보나치 수열을 출력


public class FibonacciNumbers {
	
	public int[] solution(int n) {
		int[] answer = new int[n];
		answer[0] = 1;
		answer[1] = 1;
		
		for(int i = 2; i < n; i++) {
			answer[i] = answer[i-1] + answer[i-2];
		}
		
		return answer;
	}
	
	// 배열을 쓰지 않고 풀이 
	public void solution1(int n) {
		int a = 1, b = 1, c;
		System.out.print(a+" "+b+" ");
		for(int i = 2; i < n; i++) {
			c=a+b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
	}
	
	
	public static void main(String[] args) {
		FibonacciNumbers T = new FibonacciNumbers();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 

		// 출력
		for(int answer : T.solution(n)) {
			System.out.print(answer + " ");
		}
		T.solution1(n);
	}
}
