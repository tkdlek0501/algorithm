package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #14 보이는 학생
// 일렬로 줄세웠을 때
// 자기 앞의 키보다 크면 보이고 작거나 같으면 보이지 않음

// 입력
// 첫 줄에 정수 N(5<=N<=100,000)
// 다음줄에 N명의 학생의 키가 차례대로 주어짐

// 출력
// 조건에 맞는 건의 수를 출력

public class VisibleStudent {
	public int solution(int[] arr) {
		int answer=1, max=arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				answer++;
				max = arr[i];
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		VisibleStudent T = new VisibleStudent();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		// 출력
		System.out.println(T.solution(arr));
	}
}
