package algorithm.course;

import java.util.Scanner;

//#46 삽입 정렬
// N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요
// 정렬하는 방법은 삽입정렬입니다

// 입력
// 첫번째 줄에 자연수 N(1<=N<=100) 이 주어집니다
// 두번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다
// 각 자연수는 정수형 범위 안에 있습니다
// 6
// 11 7 5 6 10 9

// 출력
// 오름차순으로 정렬된 수열을 출력합니다
// 5 6 7 9 10 11

public class InsertSort {
	
	public int[] solution(int n, int[] arr) {
		// 삽입정렬
		// index 1번 부터
		// 앞의 수들과 비교해서 뒤로 밀면서 정렬
		for(int i = 1; i < n; i++) {
			int tmp = arr[i], j;
			for(j = i-1; j >= 0; j--) {
				if(tmp < arr[j]) arr[j+1] = arr[j];
				// tmp의 자리를 찾아가기 위해 뒤로 밀기
				else break; 
			}
			arr[j+1] = tmp; // 남은자리 tmp 넣어주기
			// j가 끝까지 돌면 j = -1 
		}
		
		return arr;
	}
	
	// break 거는 부분과
	// tmp 넣는 부분이 핵심
	
	public static void main(String[] args) {
		InsertSort T = new InsertSort();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(n, arr)) {
			System.out.print(x + " ");
		}
	}
}
