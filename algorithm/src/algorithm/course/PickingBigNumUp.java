package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// Part2. Array
// #13 큰 수 출력하기 
// N(1<=N<=100) 개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
// 첫번째 수는 무조건 출력

// 입력
// 첫 줄에 개수인 자연수 N이 주어지고 그 다음 줄에 N개의 정수 입력
// 예시
// 6
// 7 3 9 5 6 12

// 출력 
// 자신의 바로 앞 수보다 큰 수만 한 줄로 출력
// 예시
// 7 9 6 12

public class PickingBigNumUp {
	
	public ArrayList<Integer> solution(int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(arr[0]); // 첫번째 수
		
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] < arr[i+1]) {
				answer.add(arr[i+1]);
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		PickingBigNumUp T = new PickingBigNumUp();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		for(int x : T.solution(arr)) {
			// 출력
			System.out.println(x+" ");
		}
		
		
	}
}
