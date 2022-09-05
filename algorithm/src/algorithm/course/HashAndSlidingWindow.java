package algorithm.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// #33 매출액의 종류
// N일 동안의 매출 기록을 주고
// 연속된 k일 동안의 매출액의 종류를 각 구간별로 구하라고 한다면
// 만약 N=7 이고 7일간의 매출 기록이 아래와 같고
// 이때 K=4이면 
// 20 12 20 10 23 17 10
// 각 연속 4일 간의 구간의 매출 종류(중복으 제외하고 같은 매출액의 개수)는
// 20 12 20 10 -> 3 
// 12 20 10 23 -> 4
// 20 10 23 17 -> 4
// 10 23 17 10 -> 3
// N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫번째 구간부터 각 구간별 매출액의 종류를 출력하는 프로그램을 작성하세요

// 입력
// 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N) 이 주어진다
// 두번째 줄에 N개의 숫자열이 주어진다. 각 숫자는 500이하의 음이 아닌 정수

// 출력
// 첫 줄에 각 구간의 매출액의 종류를 순서대로 출력

public class HashAndSlidingWindow {
	
	public ArrayList<Integer> solution(int n, int k, int[] arr) {
		// two pointers 를 사용하며 진행하면서
		// K만큼의 반복을 돌려야 한다
		ArrayList<Integer> answer = new ArrayList<>();
		
		// 0. 처음 k만큼 rt를 세팅 해준다
		// 1. rt 가 증가하며 해당 인덱스의 값을 hashMap에 저장
		// 2. 이후 hashMap의 size() 를 answer에 담는다
		// 3. rt를 1증가시키고 lt도 1 따라간다 기존 hashMap에 담긴 첫번째 인덱스 값에 해당 하는 key의 value를 1감소시킨다
		// 4. 감소시켰을 때 value가 0이면 그 key-value는 제거한다
		
		HashMap<Integer, Integer> map = new HashMap<>();
		// 1. 처음 K 만큼 세팅
		for(int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		answer.add(map.size());
		
		// 2. two pointers 돌면서 answer 넣어주기
		int lt = 0;
		for(int rt = k; rt < n; rt++, lt++) {
			// 기존 lt 감소 및 제거 
			map.put(arr[lt], map.get(arr[lt]) - 1);
			if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
			
			// rt 증가 후 map에 담기
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			
			// answer 담기
			answer.add(map.size());
		}
		
		return answer;
	}
	
	public ArrayList<Integer> solution1(int n, int k, int[] arr) {
		
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		int lt = 0;
		for(int rt = k-1; rt < n; rt++) {
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			answer.add(map.size());
			map.put(arr[lt], map.get(arr[lt]) - 1);
			if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		HashAndSlidingWindow T = new HashAndSlidingWindow();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		int k = kb.nextInt();
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int answer : T.solution(n, k, arr)) {
			System.out.print(answer + " ");
		}
		
	}
}
