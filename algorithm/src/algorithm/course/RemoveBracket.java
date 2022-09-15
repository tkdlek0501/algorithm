package algorithm.course;

import java.util.Scanner;
import java.util.Stack;

// #37 괄호 제거

// 입력
// 닫는 괄호와 여는 괄호의 개수가 동일한 문자열 입력

// 출력
// 괄호를 포함하여 괄호 안에 있는 문자를 제거한 문자열 출력

//(A(BC)D)EF(G(H)(IJ)K)LM(N)
//EFLM

public class RemoveBracket {
	
	public String solution(String s) {
		String answer = "";
		// stack에다가 문자들을 push한다
		// 닫는 괄호를 만나면 그 전 여는 괄호까지 pop해준다
		Stack<Character> stack = new Stack<>();
		for(Character c : s.toCharArray()) {
			if(c.equals(')')) {
				while(!stack.pop().equals('(')); // pop() 은 마지막 하나를 꺼내면서 해당값을 return 해준다
			} else stack.push(c);
		}
		for(Character c : stack) answer += c;
	
		return answer;
	}
	
	public static void main(String[] args) {
		RemoveBracket T = new RemoveBracket();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String s = kb.next();
		
		System.out.print(T.solution(s));
		
	}
}
