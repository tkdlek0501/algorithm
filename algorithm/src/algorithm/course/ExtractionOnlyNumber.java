package algorithm.course;

import java.util.Scanner;

//#9 숫자만 추출
// 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하고 그 순서대로 자연수를 만듦
// 추출하여 만들어지는 자연수는 100,000,000 을 넘지 않습니다

// 입력 
// 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다

// 출력
// 첫 줄에 자연수를 출력합니다


public class ExtractionOnlyNumber {
	
	// 아스키 넘버로 조건
	public Integer solution1(String str) {
		Integer answer = 0;
		
		// 1. 아스키번호 '0' ~ '9' : 48 ~ 57; 문자 '0' 은 숫자 48 이다
		// 2. 자리수가 올라가야 한다 
		// x >= 48 && x <= 57 조건 하에
		// answer = answer * 10 + (x - 48)
		for(int i = 0; i < str.length(); i++) { // or char x : str.toCharArray()
			if(str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				answer = (answer * 10) + (str.charAt(i) - 48);
			}
		}
		
		return answer;
	}
	
	// 아스키 넘버 없이 구현 
	public int solution(String str) {
		String answer = "";
		for(char x : str.toCharArray()) {
			if(Character.isDigit(x)) answer += x; // Character.isDigit()으로 숫자인지 확인
		}
		
		return Integer.parseInt(answer); // 문자가 아닌 숫자로 변환해야 맨 앞자리 0을 피할 수 있다
	}
	
	public static void main(String[] args) {
		ExtractionOnlyNumber T = new ExtractionOnlyNumber();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next(); // 입력 받은 값 넣어주기
		
		// 출력
		System.out.println(T.solution(str));
	
	}
}
