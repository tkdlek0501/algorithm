package algorithm.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//#42 교육과정 설계

// 1년 과정의 수업 계획을 짜는 프로그램 작성
// 수업 중에는 필수과목이 있고 이 필수과목은 반드시 이수해야 하고 순서도 정해져있다.
// 만약 총 과목이 A, B, C, D, E, F, G가 있고, 여기서 필수과목이 CBA로 주어지면
// 필수과목은 C,B,A 이며 이 순서대로 꼭 수업계획을 짜야한다.
// 연달아 계획할 필요는 없고 순서만 지키면 된다.
// 필수 과목 순서가 주어지면 N 개의 수업설계가 잘된 것이라면 "YES"
// 잘못된 것이면 "NO"를 출력

// 입력
// 첫 줄에 한 줄의 필수과목의 순서가 주어지고 모든 과목은 영문 대문자이다.
// 두 번째 줄부터 설계한 교육과정이 주어진다 (길이는 30이하)
// CBA
// CBDAGE

// 출력
// 첫 줄에 수업설계가 잘된 것이면 "YES", 아니면 "NO"를 출력
// YES

public class DesignCurriculum {
	
	public String solution(String essential, String course) {
		String answer = "YES";
		
		// 1. 필수과목은 queue에 넣어둔다.
		// 2. 설계한 과목들이 queue에 담겨있는지 확인
		// 3. 순서에 맞게 돼있으면 queue에서 제거
		// 4. queue의 모든 과목이 없어져야 만족
		
		Queue<Character> Q = new LinkedList<>();
		for(Character e : essential.toCharArray()) Q.offer(e);
		
		for(Character c : course.toCharArray()) {
			if(Q.contains(c)) {
				if(Q.poll() != c) return "NO";
			}
		}
		if(!Q.isEmpty()) return "NO";
		
		return answer;
	}
	
	public static void main(String[] args) {
		DesignCurriculum T = new DesignCurriculum();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String essential = kb.next();
		String course = kb.next();
		
		System.out.print(T.solution(essential, course));
	}
}
