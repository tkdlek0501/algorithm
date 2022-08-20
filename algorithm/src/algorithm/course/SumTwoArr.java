package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// Part3. Two pointers, Sliding window[효율성 : O(n^2)-->O(n)]
// #24 두 배열 합치기
// 오름차순으로 정렬이 된 두 배열
// 오름차순으로 합쳐 출력

// 입력
// 첫번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다
// 두번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다
// 세번째 줄에 두번째 배열의 크기 M(1<=M<=100)이 주어집니다
// 네번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다
// 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다
// 3
// 1 3 5
// 5
// 2 3 6 7 9

// 출력
// 오름차순으로 정렬된 배열을 출력합니디 
// 1 2 3 3 5 6 7 9

public class SumTwoArr {
	public ArrayList<Integer> solution(int[] arr1, int[] arr2) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		// 해결법
		// 배열1 과 배열2를 나란히 놓고 비교
		// 배열1의 0번째 인덱스 값과 배열2의 0번째 인덱스 값 부터 비교를 시작
		// 작은쪽을 answer에 넣고 작은 값이 있는 배열의 비교하려는 값의 인덱스를 높임
		// 더이상 추적할 인덱스가 없을 때까지 반복
		// 나머지 비교못하는 값들은 그대로 넣어줘야 함
		
		int p1 = 0, p2 = 0; // pointer
		
		// 1. 비교하면서 넣어주기
		while(p1 < arr1.length && p2 < arr2.length) { // 두 배열 모두 범위 안에 있는 조건하에
			if(arr1[p1] < arr2[p2]) answer.add(arr1[p1++]); // add 후 ++
			else answer.add(arr2[p2++]);
		}
		// 2. 아직 담기지 못한 값들 처리
		while(p1 < arr1.length) answer.add(arr1[p1++]);
		while(p2 < arr2.length) answer.add(arr2[p2++]);
		
		return answer;
	}
	
	public static void main(String[] args) {
		SumTwoArr T = new SumTwoArr();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int[] arr1 = new int[n];
		
		for(int i = 0; i < n; i++) { 
			arr1[i]=kb.nextInt();
		}
		
		int m = kb.nextInt();
		int[] arr2 = new int[m];
		
		for(int i = 0; i < m; i++) { 
			arr2[i]=kb.nextInt();
		}
			
		
		for(int x : T.solution(arr1, arr2)) {
			System.out.print(x+" ");
		}
		
	}
}
