package algorithm.course;

import java.util.Scanner;

// #17 소수
// 자연수 N 이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램 작성
// 만약 20이 입력되면  2, 3, 5, 7, 11, 13, 17, 19  8개 (숫자 1은 소수 아님)
// 제한시간은 1초 

// 입력
// 첫 줄에 자연수의 개수 N(2<=N<=200,000)

// 출력
// 첫 줄에 소수의 개수를 출력

public class PrimeNumber {
	public int solution(int n) {
		// 2부터 배수들을 걸러준다
		// 0 : 소수, 1 : 소수가 아님 
		int answer = 0; // 숫자 1을 포함
		
		int[] ch = new int[n+1]; // 모두 0으로 초기화, N까지니까 n+1
		
		for(int i = 2; i <= n; i++) { // 숫자 2부터 체크
			if(ch[i] == 0) { // i가 소수(0)이면 
				answer++;
				for(int j=i; j<=n; j=j+i) ch[j] = 1; // i의 배수이면 소수가 아님
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		PrimeNumber T = new PrimeNumber();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 

		// 출력
		System.out.print(T.solution(n));
	}
}
