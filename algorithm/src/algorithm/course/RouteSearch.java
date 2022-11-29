package algorithm.course;

import java.util.Scanner;

//#65 경로탐색
// 인접 행렬

// 방향 그래프가 주어지면 1번 정점에서 N번 정점으로 가는 
// 모든 경로의 가지수를 출력

// 입력
// 첫째줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다
// 그 다음부터 M줄에 걸쳐 연결정보가 주어진다
// 5 9
// 1 2
// 1 3
// 1 4
// 2 1
// 2 3
// 2 5
// 3 4
// 4 2 
// 4 5

// 출력 
// 총 가지수를 출력


public class RouteSearch {
	// 경로란 중복된 노드가 있으면 안된다
	// 즉 이전에 방문한 노드는 체크를 해놔야 한다
	// 체크를 하려면 배열을 사용해서 0 -> 1로 값을 바꿔놓는다
	// N번 정점으로 도착했을 때 count를 해준다
	// N번 정점을 찍으면 되돌아가면서 경로 탐색을 한다
	// 이 때 현재 노드는 체크를 풀어줘야 한다
	static int n, m, answer = 0;
	static int[][] graph;
	static int[] ch;
	public void DFS(int v) {
		if(v==n) answer++;
		else {
			for(int i = 1; i <= n; i++) {
				if(graph[v][i]==1 && ch[i]==0) { // v에서 i를 갈 수 있는지 + 이미 간 노드가 아닌지
					ch[i] = 1; // i를 체크하고 
					DFS(i); // v에서 i로 이동
					ch[i] = 0; // 끝점 갔다가 되돌아오는 시점에 체크 풀기
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		RouteSearch T = new RouteSearch();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt(); // 노드의 개수
		m = kb.nextInt(); // 간선의 개수
		graph = new int[n+1][n+1]; // 0을 제외한 인접 행렬
		ch = new int[n+1]; // 노드 체크용 배열
		for(int i = 0; i < m; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			graph[a][b]=1; // 갈수 있는 방법들을 체크
		}
		ch[1] = 1; // 출발점
		T.DFS(1); // 출발점으로 부터 시작
		System.out.println(answer);
	}
}
