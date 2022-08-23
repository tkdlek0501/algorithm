package algorithm.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// #25 공통원소 구하기
// A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요

// 입력
// 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어진다
// 두 번째 줄에 N개의 원소가 주어진다. 원소가 중복되어 주어지지는 않는다
// 세 번째 줄에 집합 B의 크기  M(1<=M<=30,000)이 주어진다
// 네 번째 줄에 M개의 원소가 주어진다. 원소가 중복되어 주어지지는 않는다
// 5
// 1 3 9 5 2
// 5
// 3 2 5 7 8

// 출력
// 두 집합의 공통원소를 오름차순 정렬하여 출력한다
// 2 3 5

public class CommonElements {
	
	public ArrayList<Integer> solution(int[] arr1, int[] arr2) {
		// 1. 각 배열을 오름차순 정렬 한다
		// 2. two pointers 알고리즘을 사용하여 같은지 비교하며 넣어준다
		// 오름차순 정렬이니까 작은 수 쪽의 포인터를 증가시키며 진행한다
		ArrayList<Integer> answer = new ArrayList<>();
		Arrays.parallelSort(arr1);
		Arrays.parallelSort(arr2);
		int p1=0, p2=0;
		while(p1 < arr1.length && p2 < arr2.length) {
			if(arr1[p1]==arr2[p2]) {
				answer.add(arr1[p1]);
				p1++; p2++;
			}else if(arr1[p1] < arr2[p2]) p1++;
			else if(arr1[p1] > arr2[p2]) p2++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		CommonElements T = new CommonElements();
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
