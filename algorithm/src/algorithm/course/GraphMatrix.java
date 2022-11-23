package algorithm.course;

//#64 그래프와 인접행렬
// 이론 

// 1. 무방향 그래프
// 이동하는 방향이 없음 (양방향)
// 점과 모서리를 가지고 G(V, E) 라는 함수로 표현
// 2차원 배열로 만들 수 있음
// a b   graph[a][b] , graph[b][a]
// 1 2   =>  graph[1][2] = 1;  graph[2][1] = 1;
// 1 3   =>  ...

// 2. 방향 그래프
// 이동하는 방향이 있음
// a b    graph[a][b] = 1
// 1 2    => graph[1][2] = 1;

// 3. 가중치 방향그래프
// ex. 가는 비용이 각각 다를때
// a b c
// 1 2 2(가중치 2) graph[a][b] = c  
// 2 5 5(가중치 5)


public class GraphMatrix {
	
	
	public static void main(String[] args) {
		
		
	}
}
