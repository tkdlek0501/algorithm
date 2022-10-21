package algorithm.course;

import java.util.Scanner;

//#52 뮤직비디오

public class MusicVideo {
	
	public int solution(int n, int m, int[] arr) {
		return 0;
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
