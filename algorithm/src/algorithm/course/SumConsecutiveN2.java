package algorithm.course;

import java.util.Scanner;

// #29 연속된 자연수의 합 (수학)
// N입력으로 양의 정수 N 이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요
// 만약 N = 15 이면
//  7 + 8 = 15
// 4+5+6 = 15
// 1+2+3+4+5 = 15
// 위 3가지 존재 

// 입력
// 첫번째 줄에 양의 정수 N(7<=N<=1000) 이 주어진다

// 출력
// 첫 줄에 총 경우수를 출력한다

public class SumConsecutiveN2 {
	
	public int solution(int n) {
		// 2가지 숫자로 만드는 방법 
		// 처음 두 수 (1, 2)의 합을 N에서 빼준 뒤, 2로 나눠서 나머지 없이 딱 떨어지면
		// 그 몫을 1, 2 각각에 더해준 값이 연속된 자연수의 합 == N 을 만든다
		// 처음 3가지 수 (1, 2, 3)도 마찬가지로 1, 2, 3의 합을 N에서 뺀 값을 
		// 3으로 나눠서 딱 떨어지면 그 수를 각각에 더해준 값들이 연속된 자연수의 합 == N 을 만든다
		int answer = 0, cnt = 1;
		n--; // n에서 먼저 1을 빼주고 시작 (처음 두 수를 뽑아야 하니까)
		while(n > 0) {
			cnt++;
			n = n - cnt;
			if(n % cnt == 0) answer++; // 나눈 값이 딱 떨어지면 answer에 해당
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		SumConsecutiveN2 T = new SumConsecutiveN2();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		
		System.out.print(T.solution(n));
		
	}
}
