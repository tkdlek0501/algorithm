package algorithm.course;

import java.util.Scanner;
import java.util.Stack;

// Stack, Queue

//#36 올바른 괄호
// 괄호 문제는 보통 stack으로 해결 한다

// 입력
// 첫번째 줄에 괄호 문자열이 입력된다. 문자열의 최대 길이는 30이다.

// 출력
// 첫 번째 줄에 YES, NO를 출력한다.

public class CompleteBracket {
	
	public String solution(String b) {
		// 여는 괄호와 닫는 괄호의 개수가 동일해야한다
		// stack을 이용해서 여는 괄호는 넣고 닫는 괄호는 뺀다
		// 결과 size가 0이어야 참
		String answer = "NO";
		Stack<Character> s = new Stack<>();
		
		for(Character c : b.toCharArray()) {
			if(c.equals('(')) s.push(c);
			else if(c.equals(')')) {
				if(s.isEmpty()) return answer;
				s.pop();
			}
		}
		if(s.isEmpty()) return "YES";
		
		return answer;
	}
	
	public static void main(String[] args) {
		CompleteBracket T = new CompleteBracket();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String b = kb.next();
		
		System.out.print(T.solution(b));
		
	}
}
