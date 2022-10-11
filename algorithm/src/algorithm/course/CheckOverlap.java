package algorithm.course;

import java.util.Arrays;
import java.util.Scanner;

// #48 중복확인
// N 명이 있을 때
// 1부터 1000만 까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 하면
// 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D를 출력하고
// N명이 모두 각자 다른 숫자를 적어냈다면 U를 출력하는 프로그램을 작성하세요

// 입력
// 첫번째 줄에 자연수 N(5<=N<=100,000) 이 주어진다
// 두번째 줄에 N개의 자연수가 입력된다
// 8
// 20 25 52 30 39 33 43 33


// 출력
// 첫번째 줄에 D또는 U를 출력한다
// D

public class CheckOverlap {
	
	public String solution(int n, int[] arr) {
		// hashMap이 아닌 정렬로도 풀 수 있지만 nlogn 이다
		// 
		String answer = "U";
		Arrays.parallelSort(arr); // 순서대로 정렬 후에
		for(int i = 0; i < n-1; i++) { // 앞 뒤로 비교
			if(arr[i] == arr[i+1]) return "D";
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		CheckOverlap T = new CheckOverlap();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();

		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, arr));
	}
}
