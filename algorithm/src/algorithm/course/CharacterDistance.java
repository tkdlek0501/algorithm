package algorithm.course;

import java.util.Scanner;

// #10 문자거리 
// 한 개의 문자열 s 와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요

// 입력
// 첫번째 줄에 문자열 s와 문자 t가 주어짐
// 문자열과 문자는 소문자로만 구성
// 문자열의 길이는 100을 넘지 않는다

// 출력
// 첫번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다

public class CharacterDistance {
	
	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		
		// 사이 거리
		int distance = 1000;
		// 왼쪽으로부터
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==t) { // 기준 문자를 발견하면
				distance = 0; // 거리를 0으로 초기화
				answer[i] = distance;
			}else {
				distance++; // 다르면 1씩 증가
				answer[i] = distance;
			}
		}
		
		distance = 1000;
		// 오른쪽으로부터 (왼쪽부터 센 다음 오른쪽으로도 세서 더 낮은 거리를 계산)
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i)==t) 
				distance = 0;
			else {
				distance++;
				answer[i]=Math.min(answer[i], distance); // 둘중 작은 값으로
			}
		}
		
		return answer;
	}
	
	// teachermode e
	// 1 0 1 2 1 0 1 2 2 1 0
	
	public static void main(String[] args) {
		CharacterDistance T = new CharacterDistance();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next(); // 입력 받은 값 넣어주기
		char t = kb.next().charAt(0);
		
		// 출력
		for(int x : T.solution(str, t)) {
			System.out.println(x + " ");
		}
	
	}
}
