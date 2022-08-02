package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #4 단어 뒤집기
// N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성

// 입력 : 첫 줄에 자연수 N(3<=N<=20) 이 주어짐
// 		두번쨰 줄부터 N개의 단어가 각 줄에 하나씩 주어짐, 단어는 영어로만 구성
// 출력 : N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력

// 예시 입력 
// 3
// good
// Time

// 예시 출력
// doog
// emiT

public class FlipOverWord {
	
	// StringBuilder 사용한 방법
	public ArrayList<String> solution(int n, String[] str) {
		ArrayList<String> answer = new ArrayList<>();
		
		for(String x : str) { // 굳이 n 안받고 배열 길이로 돌려도 됨
			String tmp = new StringBuilder(x).reverse().toString(); 
			// StringBuilder의 reverse 메서드를 이용해 뒤집기 가능
			// 자바 기본  tip : String은 불변임 새로운 값을 넣으면 새로 객체가 생성된다 -> StringBuilder는 하나의 객체로 가능
			answer.add(tmp);
		}
		
		return answer;
	}
	
	// 만약 전체 다 뒤집는게 아니라 특정 조건에 맞는 문자만 바꿔야 한다면?
	public ArrayList<String> solution1(int n, String[] str){
		ArrayList<String> answer = new ArrayList<>();
		for(String x : str) {
			char[] s = x.toCharArray(); // 문자 하나하나 배열로
			// 가장 처음 문자 <-> 가장 마지막 문자 식으로 변경하면 된다
			int lt = 0, rt = x.length()-1;
			while(lt < rt) { // 처음 문자의 index < 마지막 문자의 index 일때 
				char tmp = s[lt]; // lt -> tmp
				s[lt]=s[rt]; // rt -> lt
				s[rt]=tmp; // tmp -> rt
				lt++;
				rt--;
			}
			answer.add(String.valueOf(s));
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		FlipOverWord T = new FlipOverWord();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); // 처음 입력 받는 자연수 N 
		String[] str = new String[n]; // n개 만큼 배열 생성
		
		for(int i = 0; i < n; i++) { // 배열 길이만큼
			str[i] = kb.next(); // 입력 받은 값 넣어주기
		}
		
		// 출력
		for(String x : T.solution(n, str)) {
			System.out.println(x);
		}
	}
}
