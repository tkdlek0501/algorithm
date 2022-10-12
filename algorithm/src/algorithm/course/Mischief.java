package algorithm.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// #49 장난꾸러기

// N 명의 학생이 주어지면
// 번호를 지정해주기 위해 
// 키가 가장 작은 학생부터 일렬로 키 순으로 세운다
// 제일 앞에 가장 작은 학생부터 번호를 1번 부터 부여한다
// 그 중 철수는 자신보다 앞 번호를 받고 싶어 몰래 자리를 바꾼다
// 철수와 바꾼 학생을 포함한 반 학생들의 일렬로 서있는 키 정보가 주어졌을 때
// 철수가 받은 번호와 바꾼 학생이 받은 번호를 차례로 출력하는 프로그램을 작성

// 입력
// 첫번째 줄에 자연수 N(5<=N<=100)
// 두번째 줄에 제일 앞에부터 일렬로 서있는 학생들의 키가 주어진다
// 키 값 H는 (120<=H<=180)의 자연수이다 
// 9
// 120 125 152 130 135 135 143 127 160

// 출력
// 첫번째 줄에 철수의 반 번호와 바꾼 학생의 반 번호를 차례로 출력
// 3 8 (두 순서가 바뀌었다)

public class Mischief {
	
	public ArrayList<Integer> solution(int n, int[] arr) {
		// 정렬을 생각
		// 제대로 된 정렬을 만들고 비교
		// 다르면 바뀐 index
		ArrayList<Integer> answer = new ArrayList<>();
		
		int[] tmp = new int[n];
		tmp = arr.clone();
		Arrays.parallelSort(tmp);
		
		for(int i = 0; i < n; i++) {
			if(arr[i] != tmp[i]) answer.add(i + 1);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Mischief T = new Mischief();
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
