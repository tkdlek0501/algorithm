package algorithm.course;

import java.util.Scanner;

// 3. 문장 속 단어 찾기
// 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
// 각 단어는 공백으로 구분됩니다.

// 입력: 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 알파벳으로만 구성되어 있습니다.
// 출력 : 첫 줄에 가장 긴 단어를 출력합니다. 가장 길이가 긴 단어가 여러개이면 가장 앞 쪽에 위치한 단어를 답으로 합니다.

public class FindLongestWordInContext {
	
	public String solution1(String str) {
		String answer = "";
		//int m = Integer.MIN_VALUE; // 가장 최소값으로 초기화 ; 굳이?
		int m = 0;
		
		// 1. 문장을 공백을 기준으로 잘라서 배열로 만든다
		String[] s = str.split(" ");
		
		// 2. 배열 안에 담은 단어들을 길이로 비교해서 크면 갱신 해준다
		for(String x : s) {
			System.out.println("배열 : " + x);
			int len = x.length();
			if(len > m) {
				m = len;
				answer = x;
			}
		}
		
		return answer;
	}
	
	public String solution(String str) {
		String answer = "";
		int m = 0, pos;
		// 띄어쓰기를 찾기, 못찾으면 -1
		while((pos = str.indexOf(" ")) != -1) {
			String tmp = str.substring(0, pos); // first ~ last-1 까지 잘라냄
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos + 1); // 그 다음 단어의 시작부터
		}
		if(str.length() > m) answer = str; // 마지막 단어까지 처리해줘야됨
		
		return answer;
	}
	
	public static void main(String[] args) {
		FindLongestWordInContext T = new FindLongestWordInContext();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.nextLine();
		System.out.print(T.solution(str));
	}
}
