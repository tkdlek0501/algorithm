package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #5 특정 문자 뒤집기 (#4의 응용 문제)
// 영어와 특수문자로 구성된 문자열이 주어지면 영어는 뒤집고,
// 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

// 입력
// 첫 줄에 길이가 100을 넘지 않는 문자열이 주어짐

// 출력
// 첫 줄에 알파벳만 뒤집힌 문자열 출력함

public class FlipOverSpecificWord {
	
	public String solution(String str) {
		String answer = null;
		
		char[] s = str.toCharArray();
		int lt = 0, rt = str.length()-1;
		
		while(lt < rt) {
			if(!Character.isAlphabetic(s[lt])) lt++;
			else if(!Character.isAlphabetic(s[rt])) rt--;
			else {
				char tmp = s[lt];
				s[lt]=s[rt]; 
				s[rt]=tmp; 
				lt++;
				rt--;
			}
			
			answer = String.valueOf(s);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		FlipOverSpecificWord T = new FlipOverSpecificWord();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next(); // 입력 받은 값 넣어주기
		
		// 출력
		System.out.println(T.solution(str));
	
	}
}
