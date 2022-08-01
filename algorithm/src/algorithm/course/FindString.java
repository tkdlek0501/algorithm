package algorithm.course;

import java.util.Scanner;

// 1. 문자 찾기
// 한 개의 문자열을 입력 받고,
// 특정 문자열을 입력받아
// 해당 특정 문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
// (대소문자 구분 x , 문자열 길이 100 넘지 않음)

// 입력: 첫 줄에 문자열, 두번째 줄에 문자, 영어 알파벳으로만 구성
// 출력: 첫 줄에 해당 문자의 개수를 출력

class FindString { // class 이름을 Main 으로 해야 백준 or 채점 사이트에서 채점 가능
	
	// 프로그래머스 형식
	public int solution(String str, char t) {
		int answer = 0;
		str = str.toUpperCase(); // 모두 대문자로
		t = Character.toUpperCase(t); // 대문자로 (char 타입은 이렇게)
//		for(int i=0; i < str.length(); i++) {
//			if(str.charAt(i) == t) answer += 1;
//		}
		for(char x : str.toCharArray()) { // 문자열을 배열로 만들기
			if(x == t) answer += 1;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		//Main T = new Main();
		FindString T = new FindString(); // 인스턴스 메서드인 solution 호출하기 위해
		
		Scanner kb = new Scanner(System.in); // 콘솔 입출력
		
		System.out.println("문자열을 입력해주세요.");
		String str = kb.next(); // 콘솔창에서 문자열 읽어오기
		
		System.out.println("문자를 입력해주세요.");
		char c = kb.next().charAt(0);// 문자열 중 문자 하나 읽어오기
		
		System.out.print(T.solution(str, c));
		kb.close();
	}

}
