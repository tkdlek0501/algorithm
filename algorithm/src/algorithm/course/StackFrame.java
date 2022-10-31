package algorithm.course;

import java.util.Scanner;

//#54 재귀함수
// 스택 프레임

// 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램을 작성

// 입력
// 첫번째 줄은 정수 N(3<=N<=10)이 입력된다
// 3

// 출력
// 첫째줄에 출력
// 1 2 3 

public class StackFrame {
	
	// 자기 자신을 호출
	public void DFS(int n) {
		if(n == 0) return;
		else {
			// 여기서 sysout을 하면 3 2 1 로 출력된다
			DFS(n-1); // 여기서 호출이 된다; 현재 함수가 끝나기 전에 다음 함수가 진행된다
			System.out.print(n + " "); // 1 2 3 으로 출력된다
			// 재귀함수는 stackframe 이다
			// stack에 쌓이는 데이터는 매개변수, 지역변수, 복귀주소를 가지고 있다
			// stack에 DFS(3), DFS(2), DFS(1), DFS(0) 까지 쌓이고
			// 마지막부터 함수가 실행되게 된다
			
			// 조건에 의해 return 되는 순간
			// 자신을 호출했던 원래 함수로 돌아가게 된다
			// sysout이 이 시점에서 출력한다
		}
	}
	
	public static void main(String[] args) {
		StackFrame T = new StackFrame();
		
		T.DFS(3);
	}
}
