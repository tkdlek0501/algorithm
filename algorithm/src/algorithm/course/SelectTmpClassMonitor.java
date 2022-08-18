package algorithm.course;

import java.util.Scanner;

// #22 임시 반장 정하기
// 초등학교 6학년 반장을 선출하기 위해
// 1 ~ 5학년 중 한 번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 선출하는 프로그램을 작성하세요
// 표  예시
// 		  1학년 2학년 3학년 4학년 5학년
// 1번  학생   2반    3반    1반 ... 
// 2번 학생
// ...

// 예시 입력
// 5
// 2 3 1 7 3
// 4 1 9 6 8
// 5 5 2 4 4
// 6 5 2 6 7
// 8 4 2 2 2

public class SelectTmpClassMonitor {
	
	public int solution(int n, int[][] arr) {
		int answer = 0, max=Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) { // i 학생 기준
			int cnt = 0; // 몇 명과 같은반이었는지
			for(int j = 0; j < n; j++) { // 자신을 포함한 학생들과 비교(자신을 포함해도 상관 없음)
				for(int k = 0; k < 5; k++) { // 학년을 돌리면서 비교
					if(arr[i][k] == arr[j][k]) { // i학생의 k학년 때 반과 j학생의 k학년 때 반 비교(같은 한년 때 반 비교)
						cnt++;
						break;
					}
				}	
			}
			if(cnt > max) {
				max = cnt;
				answer = i;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		SelectTmpClassMonitor T = new SelectTmpClassMonitor();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[][] arr = new int[n][5];
		for(int i = 0; i < n; i++) { // 학생 수
			for(int j = 0; j < 5; j++) { // ~5학년
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
		// 같은 수일 때는 가장 앞 번호의 학생 출력
	}
}
