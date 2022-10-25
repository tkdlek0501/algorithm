package algorithm.course;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

//#52 뮤직비디오
// 결정 알고리즘

// DVD에 총 N개의 곡이 들어가는데, 녹화할 떄는 라이브에서의 순서가 그대로 유지 되어야 한다
// 순서가 바뀌는 것은 안된다. 
// 즉 1번 노래와 5번 노래를 같은 DVD에 녹화하기 위해서는 1번과 5번 사이의 모든 노래도 같은 DVD에 녹황해야 한다
// 또한 한 노래를 쪼개서 두 개의 DVD에 녹화하면 안된다
// M개의 DVD에 모든 동영상을 녹화하기로 하였고 
// 이떄 DVD의 크기를 최소로 하려고 한다
// 그리고 M개의 DVD는 모두 같은 크기여야 제조원가가 적기 때문에 꼭 같은 크기로 해야 한다

// 입력
// 첫째 줄에 자연수 N(1<=N<=1000), M(1<=M<=N) 이 주어진다 
// 다음 줄에는 곡이 순서대로 분 단위로 주어진다
// 부른 곡의 길이는 10000분을 넘지 않는다

// 출력
// 첫째줄부터 DVD의 최소 용량 크기를 출력

// 입력
// 9 3
// 1 2 3 4 5 6 7 8 9

// 출력 
// 17


public class MusicVideo {
	
	// 주어진 M 카운팅에 맞게 용량이 되는지 확인하는 메서드
	public int count(int[] arr, int capacity) {
		// arr은 각 곡들의 용량(분)
		// capacity는 dvd 하나의 용량
		
		int cnt = 1; // dvd 장 수
		int sum = 0; // 한 장에 들어가는 용량
		for(int x : arr) {
			if(sum + x > capacity) {
				cnt++; // 다음 dvd
				sum = x; // 다음 dvd에 용량 넣기
			}
			else sum+=x; // 현재 dvd에 용량 넣기
		}
		return cnt;
	}
	
	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		
		// M개로 묶을 수 있는 가장 작은 값에 담아야 한다
		// 이분 검색을 이용한다
		// 결정 알고리즘은 lt, rt 사이에 내가 찾고자 하는 답이 확실할 때 사용 가능하다
		// 최솟값은 가장 큰 수, 최댓값은 모든 크기의 합
		
		int lt = Arrays.stream(arr).max().getAsInt();
		// stream 은 반복자를 의미
		
		int rt = Arrays.stream(arr).sum();
		
		while(lt <= rt) {
			int mid = (lt+rt)/2; // 범위의 가운데 값
			// 이 mid 값이 문제의 답으로 가능한지 체크
			if(count(arr, mid) <= m) { // ex. 2개로 묶을 수 있으면 3개는 당연히 되므로
				answer = mid;
				rt = mid - 1; // 가장 큰 범위의 값을 mid보다 작은 값으로 갱신
			}else {
				lt = mid + 1; 
			}
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		MusicVideo T = new MusicVideo();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, m, arr));
		
	}
}
