package algorithm.course;

import java.util.Scanner;

// #6 중복문자제거
// 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요
// 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

// 입력 
// 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다

// 출력
// 첫 줄에 중복 문자가 제거된 문자열을 출력

public class RemovalOverlappingChar {
	
	public String solution(String str) {
		String answer="";
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i) + " " +i+" "+str.indexOf(str.charAt(i))); // 몇번째 문자인지, 처음 나오는 위치 출력
			// 즉 자기의 위치와 같은 문자로 처음 나오는 위치가 같을 때만 넣어주면 된다
			if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		RemovalOverlappingChar T = new RemovalOverlappingChar();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next(); // 입력 받은 값 넣어주기
		
		// 출력
		System.out.println(T.solution(str));
	
	}
}
