package algorithm.course;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

// #35 k번째 큰 수 찾기
// 1부터 100 사이의 자연수 N개
// 같은 숫자가 중복될 수 있다
// 3개의 수를 뽑아 합한 값을 기록
// 3장을 뽑을 수 있는 모든 경우의 수 기록
// 기록한 값 중 k번째로 큰 수를 출력
// 만약 큰 수 부터 만들어진 수가 25 25 23 23 22 20 19... 이고
// k값이 3이라면 k번째 큰 값은 22 

// 입력
// 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고 
// 그 다음 줄에 N개의 자연수가 입력된다

// 출력
// 첫 줄에 K번째 수를 출력한다
// k번째 수가 존재하지 않으면 -1을 출력

public class TreeSetProblem {
	
	public int solution(int[] arr, int n, int k) {
		// 중복을 제거하여 K번째 값을 나타내야 한다
		// 내림차순 정렬이 돼야한다
		// -> TreeSet 이용
		int answer = -1;
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j < n; j++) {
				for(int l = j+1; l < n; l++) {
					Tset.add(arr[i]+arr[j]+arr[l]);
				}
			}
		}
		int cnt = 0;
		for(int x : Tset) {
			cnt++;
			if(cnt == k) return x;
		}
		
		return answer;
	}
	
	// TreeSet method
	// remove(n)
	// size()
	// first() , last()
	
	public static void main(String[] args) {
		TreeSetProblem T = new TreeSetProblem();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(arr, n, k));
		
	}
}
