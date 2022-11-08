package algorithm.course;

//#59 부분집합 구하기
// DFS

// 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램

// 입력
// 첫번째 줄에 자연수 N(1<=N<=10)이 주어집니다
// 3

// 출력
// 첫번째 줄부터 각 줄에 하나씩 부분집합을 아래의 출력 예제와 같은 순서를 출력한다
// 단 공집합은 출력하지 않는다
// 1 2 3
// 1 2
// 1 3
// 1
// 2 3
// 2
// 3

public class GetSubset {
	static int n;
	static int[] ch; // 각 원소 사용 여부 체크
	
	public void DFS(int L) {
		if(L==n+1) { // 받아온 수가 n보다 커질 때 멈추기
			String tmp = "";
			for(int i = 1; i <= n; i++) {
				if(ch[i]==1) tmp += (i+ " ");
			}
			if(tmp.length() > 0) System.out.println(tmp);
		}else {
			ch[L]=1; // 사용
			DFS(L+1);
			
			ch[L]=0; // 사용안함
			DFS(L+1);
		}
	}
	
	// 각 원소들을 부분집합에 사용한다/ 사용하지 않는다 로 구분해서 넣어준다
	// 공집합은 포함하지 않아야 한다
	
	
	public static void main(String[] args) {
		GetSubset T = new GetSubset();
		n = 3;
		ch = new int[n+1];
		T.DFS(1); // 1부터
	}
}
