package algorithm.course;

//#56 팩토리얼
// 자연수 N이 입력되면 N! 을 구하는 프로그램을 작성

// 입력
// 첫번째 줄에 자연수 N(1<=N<=100)
// 5

// 출력
// 첫번째 줄에 N! 값을 출력
// 120

public class Factorial {
	
	public int DFS(int n) {
		if(n==1) return 1;
		else return n * DFS(n-1);
	}
	
	public static void main(String[] args) {
		Factorial T = new Factorial();
		System.out.println(T.DFS(5));
	}
}
