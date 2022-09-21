package algorithm.course;

import java.util.Scanner;
import java.util.Stack;

//#39 후위식 연산
// 후위 연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
// 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.

// 입력 
// 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
// 식은 1~9의 숫자와 +,-,*,/ 연산자로만 이루어집니다.

// 출력
// 연산한 결과를 출력합니다.

// 보통 이런 문제는 코테보다는 인터뷰에서 간단히 물어보는 문제

// 후위쉭
// 5-3 -> 53-
// 53- -> 5-3 
// 즉 연산자 바로 앞의 두 값을 연산하는 것

public class Postfix {
	
	public int solution(String str) {
		// stack을 이용해서 숫자이면 담아준다
		// 연산자를 만났을 때 2개의 숫자를 꺼내 연산해준다
		// 연산 결과를 stack에 담아준다
		// 이 행위를 반복하며 진행한다
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for(Character c : str.toCharArray()) {
			// 숫자인지 판별해서 stack에 넣어주기
			if(Character.isDigit(c)) stack.push(c-48); // 숫자와 문자는 아스키 코드 48의 차이
			else {
				int rt = stack.pop();
				int lt = stack.pop();
				if(c == '+') stack.push(lt+rt);
				else if(c == '-') stack.push(lt-rt);
				else if(c == '*') stack.push(lt*rt);
				else if(c == '/') stack.push(lt/rt);
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		Postfix T = new Postfix();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next();
		
		System.out.print(T.solution(str));
	}
}
