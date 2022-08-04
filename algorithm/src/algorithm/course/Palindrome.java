package algorithm.course;

import java.util.Scanner;

// #8 유효한 펠린드롬 
// 앞에서 읽을 때나 뒤에서 읽을 때 같은 문자열
// 문자열이 입력되면 해당 문자열이 펠린드롬이면 YES, 아니면 NO를 출력
// 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하고 대소문자 구분하지 않음
// 알파벳 이외의 문자들은 무시

// 입력
// 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어짐

// 출력
// 첫 번째 줄에 펠린드롬인지의 결과를 출력

public class Palindrome {
	public String solution(String str) {
		String answer = "NO";
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		// 정규식을 이용, ^ : 부정
		if(str.equals(new StringBuilder(str).reverse().toString())) return "YES";
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		Palindrome T = new Palindrome();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next(); // 입력 받은 값 넣어주기
		
		// 출력
		System.out.println(T.solution(str));
	
	}
}
