package algorithm.course;

//#57 피보나치 수열
// **메모이제이션

// 1) 피보나치 수열을 출력, 앞의 2개 수의 합이 다음 숫자가 되는 수열
// 2) 입력은 피보나치 수열의 총 항의 수, 만약 7이 입력되면 1 1 2 3 5 8 13 출력

// 입력
// 첫 줄에 총 항수 N(3<=N<=45)이 입력된다
// 10

// 출력 
// 첫 줄에 피보나치 수열을 출력
// 1 1 2 3 5 8 13 21 34 55 

public class Memoization {
	static int[] fibo;
	
	// 재귀보다는 for문이 더 빠르다 stackFrame이 쌓이는 것은 메모리 소모가 크다
	// 배열을 이용해서 출력하는 방법 (DFS를 main 함수에서 한번만 호출)
	public int DFS_1(int n) {
		if(n==1) return fibo[n] = 1; // 1, 2는 앞의 수가 2개가 되지 않음
		else if(n == 2) return fibo[n] = 1;
		else return fibo[n] = DFS(n-2)+DFS(n-1); // 앞의 2개 합
	}
	
	// 메모이제이션을 활용해 속도 개선
	// 이미 계산된 값들은 바로 출력할 수 있게
	// 배열의 값들은 0으로 초기화 돼있음
	public int DFS(int n) {
		if(fibo[n] > 0) return fibo[n];
		if(n==1) return fibo[n] = 1; // 1, 2는 앞의 수가 2개가 되지 않음
		else if(n == 2) return fibo[n] = 1;
		else return fibo[n] = DFS(n-2)+DFS(n-1); // 앞의 2개 합
	}
	
	
	public static void main(String[] args) {
		Memoization T = new Memoization();
		int n = 10;
		fibo = new int[n + 1]; // 배열 생성
		T.DFS(n);
		
		for(int i = 1; i <= n; i++) {
			System.out.print(fibo[i] + " ");
		}
	}
}
