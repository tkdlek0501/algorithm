package algorithm.course;

import java.util.Scanner;

// #12 암호

// "#*****#" 문자열은 
// 1. 일곱자리의 이진수로 변환
// #은 이진수의 1로 *은 이진수의 0으로
// 1000001

// 2. 바뀐 2진수를 10진수로 변환

// 3. 아스키 번호로 해석

// 입력
// 첫 줄에 보낸 문자의 개수 (10개 이하)
// 다음 줄에 문자의 개수의 7배 만큼의 #또는 *입력
// 항상 대문자로 해석할 수 있는 암호가 입력됨
// 4
// #****###**#####**#####**##**

// 출력
// 해석한 문자열 출력

public class Password {
	
	public String solution(int cnt, String str) {
		String answer = "";
		
		for(int i = 0; i < cnt; i++) {
			// 1.
			String tmp = str.substring(7*i, (7*i)+7).replace("#", "1").replace("*", "0");
			// 2.
			int num = Integer.parseInt(tmp, 2); // String의 형태가 2진수일 때 10진수로 변환
			System.out.println("num : " + num);
			// 3. 
			answer += (char)num; // char로 int를 형변환하면 아스키코드->문자로 변환
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Password T = new Password();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int cnt = kb.nextInt(); 
		String str = kb.next();
		
		// 출력
		System.out.println(T.solution(cnt, str));
	}
}
