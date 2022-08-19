package algorithm.course;

import java.util.Scanner;

// #23 멘토링
// 멘토링 시스템
// M번의 수학테스트 등수를 가지고 멘토와 멘티를 정함 
// M번의 테스트를 했을 때 M번 모두 멘토는 멘티보다 등수가 앞서야 할 수 있다
// 멘토 - 멘티의 짝을 모두 몇 가지 만들 수 있는지 출력

// 입력
// 첫번째 줄에 학생수 N(1<=N<=20) 과 테스트 수 M(1<=M<=10) 이 주어진다
// 두번째 줄부터 M개의 줄에 거쳐 테스트 결과가 학생번호로 주어진다 (학생번호가 앞에서부터 1등, 2등 ,...)
// 4 3
// 3 4 1 2
// 4 3 2 1
// 3 1 4 2

// 출력
// 첫번째 줄에 짝을 만들 수 있는 총 경우를 출력
// 3 
// (3, 1), (3, 2), (4, 2)

public class Mentoring {
	
	// 학생수 x 테스트수 만큼 입력 받는다  (2차원 배열)
	// 모든 경우(짝)에 대해서 조건에 만족하는지 확인해야 한다 
	
	// 멘토-멘티 짝인지 판단할 학생 i와 j를 선정해두고,
	// 2차원 배열을 반복 돌리면서 찾아서 i와 j의 등수를 알아낸 뒤,
	// 이를 i등수 < j등수 조건에 맞는지 확인한다 
	// TODO: i학생과 j학생을 먼저 고른 뒤 1:1로 비교해야 등수를 뽑아낼 수 있다.
	
	public int solution(int n, int m, int[][] arr) {
		int answer = 0;
		
		for(int i = 1; i <= n; i++) { // i번 학생; 학생번호는 1번 부터 시작
			for(int j = 1; j <= n; j++) { // j번 학생
				
				int cnt = 0; // 등수가 조건에 맞는지 카운트
				for(int k = 0; k < m; k++) { // 테스트 수 
					int pi = 0, pj = 0; // 테스트 마다의 등수
					for(int l = 0; l < n; l++) { // 학생 수 (== 등수)
						if(arr[k][l] == i) pi = l; // 현재 반복에서 정해진 i번호 학생의 등수를 넣어준다
						if(arr[k][l] == j) pj = l;
					}
					if(pi < pj) cnt++;
				}
				if(cnt == m) answer++; // 모든 테스트에서 등수 조건이 맞으면 짝을 이룸
				
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Mentoring T = new Mentoring();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); // 열
		int m = kb.nextInt(); // 줄 (행)
		
		int[][] arr = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) { 
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, m, arr));
	}
}
