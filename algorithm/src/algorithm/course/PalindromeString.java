package algorithm.course;

import java.util.Scanner;

// #7 회문 문자열
// 앞에서 읽을 때나 뒤에서 읽을 때가 동일한 문자열
// 문자열이 입려되면 해당 문자열이 회문 문자열이면 "YES", 아니면 "NO"를 출력하는 프로그램을 작성하세요
// 단 회문을 검사할 때 대소문자 구분은 안해도 됨

// 입력 
// 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어짐

// 출력
// 첫번쨰 줄에 회문 문자열인지의 결과를 출력

public class PalindromeString {
	
	// 거울 대칭이 되는지 확인
	public String solution(String str) {
		str = str.toUpperCase();
		String answer = "YES";
		for(int i = 0; i < str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) return "NO";
		}
	
		return answer;
	}
	
	// 문자열을 거꾸로 돌려서 같은지 확인 (이게 더 유용할 듯)
	public String solution1(String str) {
		String answer = "YES";
		str = str.toUpperCase();
		if(!new StringBuilder(str).reverse().toString().equals(str)) return "NO";
		
		// 또는 대소문자 비교 무시하려면 아래와 같은 방법도 있다
		// str1.equalsIgnoreCase(str2);
		
		return answer;
	}
		
	public static void main(String[] args) {
		PalindromeString T = new PalindromeString();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next(); // 입력 받은 값 넣어주기
		
		// 출력
		System.out.println(T.solution1(str));
	
	}
	
}
