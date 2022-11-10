package algorithm.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//#61 송아지 찾기 1
// BFS : 상태 트리 탐색

// 송아지를 잃어버렸는데, 송아지에는 위치 추적기가 달려 있다
// 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현재 위치에서 송아지의 위치까지 다음 방법으로 이동한다
// 송아지는 움직이지 않고 제자리에 있다고 가정하에
// 한 번에 앞 1, 뒤 1, 앞 5 를 이동할 수 있다
// 최소 몇 번의 턴으로 송아지의 위치까지 갈 수 있는지 구하시오

// 입력
// 첫번째 줄에 본인의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000 까지 이다 
// 5 14

// 출력
// 점프의 최소 횟수를 구한다. 답은 1 이상이며 반드시 존재한다 
// 3


public class FindCalf {
	// 뒤로가기를 고려해야 한다 
	// 최소를 구해야 하므로 최단거리 알고리즘
	// 방법은 3가지 선택지가 있다
	// 3가지 선택지를 트리 구조로 내려가면서 목적지에 도달할 때 까지 늘려간다
	// 이 때 이전에 한 번 도달했던 점은 가지 않는다 
	// 가장 횟수가 적은 값을 출력한다?
	int answer = 0; // 답
	int[] dis = {1, -1, 5}; // 한 턴에 가는 방법 
	int[] ch; // 지나온 점들
	Queue<Integer> Q = new LinkedList<>();
	public int BFS(int s, int e) {
		ch = new int[10001]; // 1 ~ 10000 수직선상
		ch[s] = 1; // 지나온 점인지 체크
		Q.offer(s); // 노드
		int L = 0; // 턴 수
		while(!Q.isEmpty()) {
			int len = Q.size(); // 해당 레벨에 있는 노드 개수
			for(int i = 0; i < len; i++) { // 해당 레벨의 노드들
				int x = Q.poll();
				for(int j = 0; j < 3; j++) { // 3가지 방법
					int nx = x + dis[j]; // 다음 레벨 점 값
					if(nx == e) return L + 1;
					if(nx >= 1 && nx <= 10000 && ch[nx] == 0) { // 범위 내 방문 안한 값만 넣어준다
						ch[nx] = 1; // 지나온 점 체크
						Q.offer(nx); // 다음 레벨의 노드 넣어주기 
					}
				}
			}
			L++; // 해당 레벨 끝
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		FindCalf T = new FindCalf();
		Scanner kb = new Scanner(System.in);
		int s = kb.nextInt();
		int e = kb.nextInt();
		System.out.println(T.BFS(s, e));
	}
}
