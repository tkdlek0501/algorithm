import java.util.Scanner;

import algorithm.course.EmergencyRoom;

// #44 선택 정렬
// N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
// 정렬하는 방법은 선택정렬입니다.

// 입력
// 첫번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
// 두번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
// 6
// 13 5 11 7 23 15

// 출력
// 오름차순으로 정렬된 수열을 출력합니다.
// 5 7 11 13 15 23

public class SortSelection {
	
	public int[] solution(int n, int[] arr) {
		// 받아온 숫자 중 가장 작은 숫자부터 넣어줘야 한다
		// 앞 자리부터 원래 숫자와 나머지 숫자들을 비교하며 스왑
		// 스왑에는 tmp를 이용
		// idx : 바꿀 index
		for(int i = 0; i < n-1; i++) {
			int idx = i; // 원래 자리
			for(int j = i+1; j < n; j++) {
				if(arr[j] < arr[idx]) idx = j; // 뒤에 더 작은 수가 있다면 해당 index 저장
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		SortSelection T = new SortSelection();
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
