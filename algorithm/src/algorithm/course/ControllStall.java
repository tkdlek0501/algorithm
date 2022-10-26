package algorithm.course;

import java.util.Arrays;
import java.util.Scanner;

//#53 마구간 정하기
// 결정 알고리즘

// N개의 마구간이 수직선상에 있고
// 각 마구간은 x1, x2, x3, .... xN의 좌표를 가지며
// 좌표가 중복되는 일은 없다
// C마리의 말을 가지고 있을때
// 각 마구간에 한 마리의 말만 들어갈 수 있고
// 가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하려고 한다
// C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그때의 최대값을 출력하는 프로그램을 작성

// 입력
// 첫 줄에 자연수 N(3<=N<=200000), C(2<=C<=N)이 공백을 사이에 두고 주어진다
// 둘째 줄에 마구간의 좌표 xi(0<=xi<=1000000000) 가 주어진다
// 5 3
// 1 2 8 4 9

// 출력
// 첫 줄에 가장 가까운 두 말의 최대 거리를 출력
// 3

public class ControllStall {
	
	public int count(int[] arr, int dist) {
		// dist(=mid) 가 맞는 답인지 확인
		int cnt = 1; // 말의 마리수
		int ep = arr[0]; // 제일 왼쪽 좌표부터 넣어주기
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - ep >= dist) { // 좌표와 좌표 사이의 거리가 받아온 거리보다 긴지
				cnt++; // 해당 좌표에 말을 넣어주고
				ep = arr[i]; // 가장 왼쪽 좌표 갱신
			}
		}
		return cnt; // 받아온 거리에 맞게 넣은 말의 마리수
	}
	
	public int solution(int n, int c, int[] arr) {
		int answer = 0;
		
		Arrays.parallelSort(arr);
		
		int lt = 1; // 가능한 거리의 최소값
		int rt = arr[n-1]; // 가장 큰 값
//		int rt = Arrays.stream(arr).max().getAsInt() - 1; // 가장 큰 값
		while(lt <= rt) {
			int mid = (lt+rt) / 2;
			if(count(arr, mid) >= c) {
				answer = mid;
				lt = mid + 1;
			}else rt = mid - 1;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		ControllStall T = new ControllStall();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, m, arr));
		
	}
}
