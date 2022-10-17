package algorithm.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// #51 이분검색
// 임의의 N개의 숫자가 입력으로 주어진다
// N개의 수를 오름차순으로 정렬한 다음 N개의 수중 한 개의 수인 M이 주어지면
// 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성
// 단 중복값은 없다

// 입력
// 첫 줄에 자연수 N(3<=N<=1,000,000) 과 M이 주어집니다
// 두번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다
// 8 32
// 23 87 65 12 57 32 99 81

// 출력
// 첫 줄에 정렬 후 M의 값의 위치 번호를 출력
// 3

public class BinarySearch {
	
	// 이분 검색이므로 반으로 나누면서 검색
	// 양 쪽 끝점 lt, rt를 두고
	// 가운데 점으로 부터 오른쪽에 있는지 왼쪽에 있는지에 따라
	// lt또는 rt값을 갱신해준다
	
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		Arrays.parallelSort(arr);
		int lt=0, rt=n-1;
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			if(arr[mid] == m) {
				answer = mid + 1;
				break;
			}
			if(arr[mid] > m) rt = mid - 1;
			else lt = mid + 1;
		}
				
		return answer;
	}
	
	public static void main(String[] args) {
		BinarySearch T = new BinarySearch();
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
