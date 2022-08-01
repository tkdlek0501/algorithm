package algorithm.course;

import java.util.Scanner;

// #2 대소문자 변환

class UpperLowerConverting { 

	public String solution(String str) {
		String answer = "";
		for(char x : str.toCharArray()) { // 한 문자씩 가져와서
			if(Character.isLowerCase(x)) {
				answer += Character.toUpperCase(x);
			} else {
				answer += Character.toLowerCase(x);
			}
		}
		return answer;
	}
	
	// 아스키 넘버로 구분하는 방법도 있다
	// 대문자는 65 ~ 90
	// 소문자는 97 ~ 122  
	// 소문자 - 대문자 = 32
	public String solution1(String str) {
		String answer = "";
		for(char x : str.toCharArray()) { // 한 문자씩 가져와서
			if(x>=97 && x<=122) { // (char는 자동 형변환으로 정수형 으로 반환됨) 소문자이면
				answer += (char)(x-32);
			} else {
				answer += (char)(x+32);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		UpperLowerConverting T = new UpperLowerConverting();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.print(T.solution(str));
	}

}
