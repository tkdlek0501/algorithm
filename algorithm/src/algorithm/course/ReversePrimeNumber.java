package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #18 뒤집은 소수
// N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 
// 그 소수를 출력하는 프로그램을 작성하세요
// 예)
// 32를 뒤집으면 23이고 23은 소수이다 그러면 23을 출력
// 단 910을 뒤집으면 19로 숫자화 해야 한다 첫자리부터 연속된 0은 무시한다 

// 입력
// 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고
// 그 다음 줄에 N개의 자연수가 주어진다
// 각 자연수의 크기는 100,000을 넘지 않는다

// 출력
// 첫 줄에 뒤집은 소수를 출력



public class ReversePrimeNumber {	
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i = 0; i<n; i++) {
			// 숫자를 뒤집는 알고리즘 
			int tmp = arr[i]; // i번째 숫자 넣어줌
			int res = 0; // 뒤집은 결과 초기화
			while(tmp>0) { // 10으로 나눈 값이 0보다 클때만
				int t = tmp%10; // i번째 숫자를 10으로 나눈 나머지 (맨 마지막 자릿수 값)
				res = res * 10 + t; // res 갱신
				tmp = tmp/10; // 받은 숫자를 10으로 나누면 마지막 자릿수가 지워짐
			}
			// ex) 
			// tmp = 123 
			// t = 123 % 10 = 3
			// res = 0 * 10 + 3 = 3
			// tmp = 123/10 = 12
			// t = 12 % 10 = 2
			// res = 3 * 10 + 2 = 32
			// tmp = 12/10 = 1
			// t = 1 % 10 = 1
			// res = 32 * 10 + 1 = 321
			// tmp = 1/10 = 0
			// tmp > 0 이 아니므로 while문 종료
			// 요약: 123이라는 숫자를 3 -> 32 -> 321 로 만들어줌 
			// 마지막 자릿수를 넣어주고(%10) 마지막 자릿수를 제외(/10)하는 것을 반복
			if(isPrime(res)) answer.add(res);
		}
		
		return answer;
	}
	
	// 해당 숫자가 소수인지 판별
	public boolean isPrime(int num) {
		if(num==1) return false;
		for(int i=2; i<num; i++) {
			if(num%i==0) return false; // 나머지가 0이면 소수가 아님
		}
		return true;
	}
	
	public static void main(String[] args) {
		ReversePrimeNumber T = new ReversePrimeNumber();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(n, arr)) {
			System.out.println(x + " ");
		}
	}
}
