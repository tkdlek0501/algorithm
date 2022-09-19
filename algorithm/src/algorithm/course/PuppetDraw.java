package algorithm.course;

import java.util.Scanner;
import java.util.Stack;

// #38 인형 뽑기 (카카오)
// 게임 개발자 죠르디는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
// 죠르디는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.

// 게임화면은 1x1 크기의 칸들로 이루어진 N x N 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다.
// 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.

// 모든 인형은 1x1 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다. 
// 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다.
// 집어 올린 인형은 바구니에 쌓이게 되는데,
// 이때 바구니의 가장 아래칸부터 인형이 순서대로 쌓이게 됩니다. 

// 바구니에 같은 모양의 인형 두개가 연속해서 쌓이면 두 인형은 사라집니다.

// 입력
// 첫 줄에 자연수 N(5<=N<=30)이 주어집니다.
// 두번째 줄부터 N*N board 배열이 주어집니다.
// board의 각 칸에는 0이상 100이하인 정수가 담겨있습니다.
// 0은 빈 칸을 나타냅니다
// 1 ~ 100 의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
// 마지막 줄에는 moves 배열이 주어집니다.
// moves 배열의 크기는 1이상 1000 이하로 주어집니다.
// moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

// 출력
// 첫 줄에 사라진 인형의 개수를 출력합니다.

// 예시 입력
// 5
// 0 0 0 0 0
// 0 0 1 0 3
// 0 2 5 0 1
// 4 2 4 4 2
// 3 5 1 3 1
// 8
// 1 5 3 5 1 2 1 4

// 예시 출력 
// 4

public class PuppetDraw {
	
	public int solution(int n, int[][] board, int k, int[] moves) {
		// 바구니는 stack의 형태
		// moves 가 의미하는 것은 인형이 담긴 틀의 가로 길이 (1부터 시작하므로 index는 -1로 계산)
		// board[i][position - 1] 
		// 0 인 값들은 거르며 인형을 뽑는다
		// 뽑았으면 틀에서 제거 된다
		// 바구니에 넣을 때 바구니 가장 상단의 값과 같은지 비교해서 같으면 둘다 제거
		// ( stack에서 꺼내지 않고 비교하는 방법 : peek() )
		// answer 은 조건이 성립하면 += 2
		int answer = 0;
		
		Stack<Integer> basket = new Stack<>();
		for(int pos : moves) { // moves에 맞게 board에서 꺼내서 바구니에 담는다
			for(int i = 0; i < board.length; i++) { // moves 열에 해당하는 곳에서
				if(board[i][pos-1] != 0) { //  0인 값을 피해서 인형을 건진다
					int tmp = board[i][pos-1]; // 건진 인형
					board[i][pos-1] = 0; // 뽑은 자리 0으로 
					if(!basket.isEmpty() && tmp == basket.peek()) { // 바구니가 비어있지 않을 때 가장 마지막 인형과 잡은 인형 비교
						basket.pop();
						answer += 2; 
					}else { // 같지 않다면 바구니에 들어감
						basket.push(tmp);
					}
					break; // 인형을 건졌다면 다음 moves로 
				}
			}
		}
		
		// 순서
		// 1. moves에 해당하는 열에 위치
		// 2. 비어있는 곳을 피해 인형을 꺼냄
		// 3. 꺼낸 자리는 빈자리로 만들어줌
		// 4. 꺼낸 인형과 바구니에 마지막으로 담긴 인형을 같은지 비교
		// 5-1. 같으면 마지막으로 담긴 인형 제거하고 answer에 2 증가
		// 5-2. 다르면 바구니에 담아줌
		// 6. 해당 move에서 인형을 건졌으므로 다음 move로 진행 (break)
		
		return answer;
	}
	
	public static void main(String[] args) {
		PuppetDraw T = new PuppetDraw();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = kb.nextInt();
			}
		}
		
		int k = kb.nextInt();
		int[] moves = new int[k];
		for(int i = 0; i < k; i++) {
			moves[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, board, k, moves));
		
	}
}
