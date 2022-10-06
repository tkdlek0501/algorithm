package algorithm.course;

import java.util.Scanner;

//#47 LRU
// 카카오 변형
// 캐시메모리는 CPU와 주기억장치 사이의 고속의 임시 메모리로서 CPU가 처리할 작업을 저장해 놓았다가
// 필요할때 바로 사용해서 처리속도를 높이는 장치이다. 
// 캐시메모리 사용 규칙이 LRU 알고리즘을 따른다고 했을 때
// 이는 가장 최근에 사용하지 않은 것 이라는 의미로
// 캐시에서 작업을 제거할 때 가장 오랫동안 사용하지 않은 것을 제거하는 알고리즘이다.

// 만약 캐시의 사이즈가 5이고 작업이 2 3 1 6 7 순으로 저장되어 있다면,
// (맨 앞이 가장 최근에 쓰인 작업이고 맨 뒤는 가장 오랫동안 쓰이지 않은 작업)

// 1) cashe miss : 해야할 작업이 캐시에 없는 상태로 위 상태에서 만약 새로운 작업인
// 5번 작업을 CPU가 사용한다면 cashe miss가 되고 모든 작업이 뒤로 밀리고 5번 작업은 캐시의 맨 앞에
// 위치한다 5 2 3 1 6

// 2) cashe hit : 해야할 작업이 캐시에 있는 상태로 위 상태에서 만약 3번 작업을 CPU가 사용한다면
// cashe hit이 되고 3번 작업이 맨 앞으로 오게 되고 5, 2가 뒤로 밀리게 된다
// 3 5 2 1 6

// 캐시의 크기가 주어지고, 캐시가 비어있는 상태에서 N개의 작업을 CPU가 차례대로 처리한다면
// N개의 작업을 처리한 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례대로 출력하는 프로그램을 작성하라

// 입력
// 첫번째 줄에 캐시의 크기인 S(3<=S<=10)와 작업의 개수 N(5<=N<=1,000)이 입력된다
// 두번째 줄에 N개의 작업번호가 처리순으로 주어진다 (1~100)
// 5 9
// 1 2 3 2 6 2 3 5 7

// 출력
// 마지막 작업 후 캐시메모리의 상태를 가장 최근 사용된 작업부터 차례로 출력한다
// 7 5 3 2 6

public class LeastRecentlyUsed {
	
	// 캐시 메모리의 상태 변화
	// 1 0 0 0 0
	// 2 1 0 0 0
	// 3 2 1 0 0
	// ...
	// 5 3 2 6 1
	// 7 5 3 2 6
	
	// 내 풀이
	public int[] solution(int n, int k, int[] arr) {
		// 삽입정렬을 활용
		// 배열 안에 같은 작업이 없으면 맨 앞에 그 작업이 들어가고 나머지는 뒤로 밀려야 한다
		// -> 배열의 맨 뒤에서부터 밀어준다
		// 배열 안에 같은 작업이 있으면 그 작업을 맨 앞으로 옮기고 그 앞 작업부터 뒤로 밀려야 한다
		// -> 배열에서 같은 작업이 있는 순서의 앞부터 밀어준다
		int[] answer = new int[n];
		for(int i = 0; i < k; i++) {
			int hitIndex = n - 1; // hit 된 index or hit 되지 않았을 경우 맨 뒤 index
			
			for(int j = 0; j < n; j++) {
				if(answer[j] == arr[i]) { // 배열 안에 같은 작업이 있다면(hit) 인덱스 추출
					hitIndex = j;
				}
			}
			
			// 뒤 부터 돌면서 뒤로 하나씩 밀어주기
			for(int l = hitIndex; l > 0; l--) {
				answer[l] = answer[l-1];
			}
			
			// 맨 앞에 현재 작업 넣어주기
			answer[0] = arr[i];
		}
		return answer;
	}
	
	// 강의 풀이
	public int[] solution1(int size, int n, int[] arr) {
		int[] cache = new int[size];
		for(int x : arr) {
			int pos = -1;
			for(int i = 0; i < size; i++) if(x == cache[i]) pos = i;
			if(pos == -1) { // miss
				for(int i = size-1; i >= 1; i--) {
					cache[i] = cache[i-1];
				}
			}else { // hit
				for(int i = pos; i >= 1; i--) {
					cache[i] = cache[i-1];
				}
			}
			cache[0] = x;
		}
		
		return cache;
	}
	
	public static void main(String[] args) {
		LeastRecentlyUsed T = new LeastRecentlyUsed();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int[] arr = new int[k];
		
		for(int i = 0; i < k; i++) {
			arr[i] = kb.nextInt();
		}
		
		for(int x : T.solution(n, k, arr)) {
			System.out.print(x + " ");
		}
	}
}









