package algorithm.course;

import java.util.Scanner;
import java.util.Stack;

//#40 쇠막대기
// 여러 개의 쇠막대기를 레이저로 절단하려고 한다.
// 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고,
// 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다.
// 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.

// 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
// 쇠막대기를 단른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
// 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
// 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.

// 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 '()'으로 표현된다.
// 또한 모든 '()'는 반드시 레이저를 표현한다.

// 쇠막대기의 왼쪽 끝은 여는 괄호, 오른쪽 끝은 닫는 괄호 표현된다.

// 쇠막대기 레이저에 의해 몇 개의 조각으로 잘려지는데, 위 예에서 가장 위에 있는 두 개의
// 쇠막대기는 각각 3개와 2개의 조각으로 잘려지고, 이와 같은 방식으로 주어진 쇠막대기들은
// 총 17개의 조각으로 잘려진다.

// 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 
// 총 개수를 구하는 프로그램을 작성하시오.

// 입력
// 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다.
// 괄호 문자의 개숭는 최대 100,000이다

// 출력
// 잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.

// 입력예제
//()(((()())(())()))(())

// (((()(()()))(())()))(()())

// 출력예제
// 17

// 24

public class IronStick {
	
	public int solution(String str) {
		// 괄호 문제니까 stack을 이용
		// 들어오는 순서에 따라 막대기와 레이저가 어떻게 구분되는지, 잘려서 조각이 어떻게 생기는지 파악 : 
		// 여는 괄호는 stack에 담는다
		// 닫는 괄호를 만났을 경우 레이저인가를 판단하기 위해 바로 앞의 괄호가 여는 괄호인지 확인한다
		// 레이저라면 stack에서 레이저에 해당하는 여는 괄호를 제외해주고 남은 여는 괄호의 개수가 잘린 쇠막대기의 수가 된다
		// 이를 반복하여 answer에 합산해준다
		// 만약 레이저가 아닌 막대기라면 그 막대기의 마지막 조각이 나온 것이므로 answer += 1 해주고 stack에서 pop() 해준다.
		int answer = 0;
		Stack<Character> stack = new Stack<>();	
		
//		for(Character c : str.toCharArray()) {
//			if(c == '(') stack.push(c);
//			else { // c == ')'
//				if(stack.peek() == '(') { // 레이저
//					stack.pop();
//					answer += stack.size();
//				}else { // 막대기 끝
//					stack.pop();
//					answer += 1;
//			}
//		}
		for(Character c : str.toCharArray()) {
			if(c == '(') stack.push(c);
			else { // c == ')'
				stack.pop();
				if(c == '(') answer += stack.size();
				else answer++;
			}
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		IronStick T = new IronStick();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next();
		
		System.out.print(T.solution(str));
	}
}
