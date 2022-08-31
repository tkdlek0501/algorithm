package algorithm.course;

import java.util.HashMap;
import java.util.Scanner;

// #31 학급 회장 선거
// A, B, C, D, E 후보가 등록
// 투표용지에 반 학생들이 자기가 선택한 후보의 기호를 작성
// 가장 많은 투표를 받은 후보를 회장으로 선출
// 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정

// 입력
// 첫 줄에는 반 학생수 N(5<=N<=50) 이 주어진다
// 두 번째 줄에는 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 발표한 순서대로 문자열로 입력된다

// 출력
// 학급 회장으로 선택된 기호를 출력

// TODO: HashMap 의 getOrDefault() 활용 방법 익히기
// keySet 도 활용 연습하기
// A는 몇개, B는 몇개 .... 가장 많은 수의 value에 해당하는 key를 구하려면 이 방법을 활용

public class HashMap1 {
	
	public char solution(int n, String str) {
		char answer = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char x : str.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1); // getOrDefault ; key에 해당하는 value가 있으면 가져오고 존재하지 않으면 default 설정
			// 즉 없으면 0 + 1 이 되고 있으면 value + 1이 된다
		}
		
		System.out.println(map.containsKey('A')); // key의 존재 유무에 대해 boolean으로 return
		
		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()) { // map에 있는 key(Character 타입) 를 Set으로
			if(map.get(key) > max) {
				max = map.get(key);
				answer = key;
			}
		}
		
		return answer;
	}
	
	// 나는 getOrDefault() 라는 메서드를 몰랐어서 예전에는
	// map.put 으로 들어올 수 있는 key 모두에 대해 value를 먼저 0으로 세팅을 해주고
	// 1씩 더해주는 방법을 사용했었다.
	
	public static void main(String[] args) {
		HashMap1 T = new HashMap1();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		String str = kb.next();
		
		System.out.print(T.solution(n, str));
		
	}
}
