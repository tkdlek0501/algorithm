package algorithm.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// #34 모든 아나그램 찾기
// S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요
// 아나그램 판별시 대소문자 구분, 부분문자열은 연속된 문자열이어야 한다

// 입력
// 첫 줄에 첫번째 S문자열이 입력되고, 두번째 줄에 T문자열이 입력된다
// S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다

// 출력
// S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력


public class FindAllAnagram {
	
	public int solution(String s, String t) {
		int answer = 0;
		
		// 1. t문자열을 map 으로 세팅한다 
		HashMap<Character, Integer> map1 = new HashMap<>();
		for(int i = 0; i < t.length(); i++) {
			map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
		}
		
		// 2. s문자열을 t길이 만큼 map 으로 세팅한다 
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(int i = 0; i < t.length() - 1; i++) {
			map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
		}
		
		// 3. two pointers 진행하며 비교
		int lt = 0;
		for(int rt = t.length() - 1; rt < s.length(); rt++, lt++) {
			// 1. rt 의 값을 map2에 담는다
			map2.put(s.charAt(rt), map2.getOrDefault(s.charAt(rt), 0) + 1);
			// 2. map1과 map2를 비교한다
			if(map1.equals(map2)) answer++;
			// 3. 기존 lt를 제거하한다
			map2.put(s.charAt(lt), map2.get(s.charAt(lt)) - 1);
			// 4. map의 value 값이 0이라면 제거한다
			if(map2.get(s.charAt(lt)) == 0) map2.remove(s.charAt(lt));
		}
		
		
		return answer;
	}
	
	public int solution1(String a, String b) {
		int answer = 0;
		HashMap<Character, Integer> am = new HashMap<>();
		HashMap<Character, Integer> bm = new HashMap<>();
		for(char x : b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
		int L = b.length() - 1;
		for(int i = 0; i < L; i++) am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
		
		int lt = 0;
		for(int rt = L; rt < a.length(); rt++) {
			am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);
			if(am.equals(bm)) answer++;
			am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
			if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
			lt++;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		FindAllAnagram T = new FindAllAnagram();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		String s = kb.next();
		String t = kb.next();
		
		System.out.print(T.solution(s, t));
		
	}
}
