package algorithm.course;

import java.util.ArrayList;
import java.util.Scanner;

// #15 가위바위보
// A, B 두 사람이 가위바위보
// 총 N번의 게임을 해서 A가 이기면 A 출력
// B가 이기면 B를 출력
// 비길 경우에는 D를 출력
// 1:가위, 2:바위, 3:보

// 입력
// 첫 줄에 게임 횟수 자연수 N(1<=N<=100)
// 두번째 줄에 A가 낸 가위, 바위, 보가 N개 만큼
// 세번쨰 줄에 B가 낸 가위, 바위, 보가 N개 만큼 

public class RockScissorPaper {
	
	public ArrayList<Character> solution(int n, int[] arrA, int[] arrB) {
		ArrayList<Character> answer = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
//			if(arrA[i] == arrB[i]) {
//				answer.add('D');
//			}else if(arrA[i] == 1) {
//				if(arrB[i] == 2) {
//					answer.add('B');
//				}else {
//					answer.add('A');
//				}
//			}else if(arrA[i] == 2) {
//				if(arrB[i] == 3) {
//					answer.add('B');
//				}else {
//					answer.add('A');
//				}
//			}else if(arrA[i] == 3) {
//				if(arrB[i] == 1) {
//					answer.add('B');
//				}else {
//					answer.add('A');
//				}	
//			}
			if(arrA[i] == arrB[i]) answer.add('D');
			else if(arrA[i]==1 && arrB[i]==3) answer.add('A');
			else if(arrA[i]==2 && arrB[i]==1) answer.add('A');
			else if(arrA[i]==3 && arrB[i]==2) answer.add('A');
			else answer.add('B');
		}
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		RockScissorPaper T = new RockScissorPaper();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt(); 
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		
		for(int i = 0; i < n; i++) {
			arrA[i] = kb.nextInt();
		}
		for(int i = 0; i < n; i++) {
			arrB[i] = kb.nextInt();
		}
		
		// 출력
		for(char answer : T.solution(n, arrA, arrB)) {
			System.out.println(answer);
		}
	}
}
