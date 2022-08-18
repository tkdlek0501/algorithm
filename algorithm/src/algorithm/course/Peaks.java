package algorithm.course;

import java.util.Scanner;

// #21 봉우리
// 지도 정보가 N x N 격자판에 주어지고 
// 각 칸에는 그 지역의 높이가 적혀있습니다
// 각 격자판의 숫자 중 기준칸의 숫자가 상하좌우 숫자보다 크면 그 지역은 봉우리입니다
// 봉우리가 몇개 있는지 알아내는 프로그램을 작성하세요
// 격자의 가장자리는 0으로 초기화 되었다고 가정한다

// 입력
// 첫 줄에 자연수 N이 주어진다 (2<=N<=50)
// 두번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다
// 각 자연수는 100을 넘지 않는다
//	5
//	5 3 7 2 3
//	3 7 1 6 1
//	7 2 5 3 4
//	4 3 6 4 1
//	8 7 3 5 2

// 출력
// 모든 봉우리의 개수를 출력
// 10

public class Peaks {
	
	int[] dx = {-1, 0, 1, 0}; // 행
	int[] dy = {0, 1, 0, -1}; // 열
	
	public int solution(int n, int[][] arr) {
		// 2차원 배열에서 기준 값으로부터 상하좌우 값을 알아내려면
		// 기준점 행과 열 (x, y) 가 (0, 0) 일 때 
		// 상 : (-1, 0)
		// 하 : (1, 0)
		// 좌 : (0, -1)
		// 우 : (0, 1)
		int answer = 0;
		
		for(int i = 0; i < n; i++) { // 행
			for(int j = 0; j < n; j++) { // 열
				boolean flag = true;
				for(int k = 0; k < 4; k++) { // 4방향
					int nx = i+dx[k];
					int ny = j+dy[k];
					if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[i][j] <= arr[nx][ny]) {
						// N x N 배열 범위 내여야 하므로 0 보다 크고 N 보다 작은 범위 조건
						// 상하좌우 각각의 값과 비교
						// 격자의 가장자리는 0으로 초기화 되었다고 가정하므로 범위 내가 아니면 0이라고 보고 계산
						flag = false; 
						break;
					}
				}
				if(flag) answer++;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Peaks T = new Peaks();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j]=kb.nextInt();
			}
		}
		System.out.print(T.solution(n, arr));
		
	}
}
