package algorithm.course;

import java.util.Scanner;

//#45 버블 정렬
// N개의 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요
// 정렬하는 방법은 버블정렬입니다. 

// 입력
// 첫번째 줄에 자연수 N (1<=N<=100)이 주어집니다
// 두번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.
// 각 자연수는 정수형 범위 안에 있습니다.
// 6
// 13 5 11 7 23 15

// 출력
// 오름차순으로 정렬된 수열을 출력합니다.
// 5 7 11 13 15 23

public class BubbleSort {
	
	public int[] solution(int n, int[] arr) {
		// 버블정렬 : 이웃한 전, 후 숫자를 비교해서 스왑 반복
		// 한 번의 턴을 통해 맨 뒷자리 수를 정할 수 있다
		for(int i = 0; i < n-1; i++) { // 총 반복 횟수 (0 ~ n-1번)
			for(int j = 0; j < n-1-i; j++) { // 반복 1회당 비교 횟수 (0 ~ n-1-i 번)
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		
		return arr;
	}
		
	
	public static void main(String[] args) {
		BubbleSort T = new BubbleSort();
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
