package algorithm.course;

import java.util.HashMap;
import java.util.Scanner;

// #32 아나그램
// 두 문자열이 알파벳의 나열 순서를 따르지만, 그 구성이 일치하면 두 단어는 아나그램이라고 한다
// 예를들어 AbaAeCe 와 baeeACA 는 알파벳 나열 순서는 다르지만 구성요소와 각 구성요소의 수가 같다
// 즉 재배열 했을 때 서로 같아질 수 있을 경우에 아나그램이라고 한다
// 아나그램임을 판별하는 프로그램을 작성하세요

// 입력
// 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력된다 (두 단어의 길이는 같다)

// 출력
// 두 단어가 아나그램이면 "YES"를 출력하고 아니면 "NO"를 출력한다


public class Anagram {
	
	public String solution(String a, String b) {
		String answer = "YES";
		
		HashMap<Character, Integer> mapA = new HashMap<>();
		for(char x : a.toCharArray()) {
			mapA.put(x, mapA.getOrDefault(x, 0) + 1);
		}
		
		// mapA를 기준으로 비교를 한다
		// 1. a의 key값이 b에도 존재하지 않으면 NO
		// 2. a의 Key값과 동일하면 개수를 1개씩 감소시키다 0이 되면 NO
		
		for(char x : b.toCharArray()) {
			if(!mapA.containsKey(x) || mapA.get(x) == 0) return "NO";
			mapA.put(x, mapA.get(x) - 1);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Anagram T = new Anagram();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String a = kb.next();
		String b = kb.next();
		
		System.out.print(T.solution(a, b));
		
	}
}
