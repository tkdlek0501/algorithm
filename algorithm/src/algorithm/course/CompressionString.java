package algorithm.course;

import java.util.Scanner;

// #11 문자 압축 

// 입력
// 첫 줄에 문장이 주어진다. 문자열의 길이는 100을 넘지 않는다

// 출력
// 첫 줄에 압축된 문자열을 출력한다 (중복 제거하고 개수로 환산)

// 예제
// KKHSSSSSSSE

public class CompressionString {
	
	public String solutionMine(String str) {
		String answer = "";
		
		// 반복문을 돌면서
		// 만약 이전 문자와 동일한 문자이면
		// 숫자 증가
		// 그렇지 않다면 지금까지 누적된 숫자 붙여주고, 현재 문자 붙여주고 숫자 초기화
		
		answer = String.valueOf(str.charAt(0));
		int num = 1;
		char tmp = str.charAt(0);
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i)==tmp) {
				num++;
			}else {
				if(num != 1) answer += num;
				answer += str.charAt(i);
				// 갱신
				num = 1;
				tmp = str.charAt(i); 
			}
		}
		
		return answer;
	}
	
	public String solution(String str) {
		String answer = "";
		str = str + " "; // 맨 마지막 문자의 다음 인덱스를 빈 문자로 추가 
		int cnt = 1;
		
		// 반복하면서
		// 현재 인덱스와 다음 인덱스를 비교
		// 만약 같으면 count 증가
		// 달라질 때 현재 문자와 count를 순서대로 문자열에 추가하고
		// 다시 처음으로 갱신
		
		for(int i = 0; i < str.length()-1; i++) { // 빈문자 전까지
			if(str.charAt(i)==str.charAt(i+1)) cnt++;
			else {
				answer += str.charAt(i);
				if(cnt>1) answer+=String.valueOf(cnt);
				cnt = 1;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		CompressionString T = new CompressionString();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String str = kb.next(); // 입력 받은 값 넣어주기
		
		// 출력
		System.out.println(T.solution(str));
		
	
	}
}
