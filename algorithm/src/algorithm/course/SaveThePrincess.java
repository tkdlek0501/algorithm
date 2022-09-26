package algorithm.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// #41 공주구하기
// 정보 왕국에 왕자가 N명이 있다.
// 괴물에게 잡혀간 공주를 구하러 왕자들이 서로 가겠다고 한다.
// 다음과 같은 방법으로 공주를 구하러 갈 왕자를 결정하기로 했다.
// 나이 순으로 1번 부터 N번까지 차례로 번호를 매긴다.
// 1번 왕자부터 N번 왕자까지 순서대로 시계 방향으로 돌아가며 둥글게 않힌다.
// 1번 왕자부터 시계방향으로 돌아가며 1부터 시작하여 번호를 외치게 한다
// 한 왕자가 K(특정 임의의 숫자)를 외치면 그 왕자는 공주를 구하러 가는데서 제외되고
// 원 밖으로 나오게 된다.
// 그리고 다음 왕자부터 1부터 시작하여 똑같은 행위를 반복한다.
// 마지막에 남은 왕자가 공주를 구하러 가게 된다.

// 입력
// 첫 줄에 자연수 N(5<=N<=1,000) 과 K(2<=K<=9) 가 주어진다
// 8 3

// 출력
// 첫 줄에 마지막 남은 왕자의 번호를 출력한다.
// 7 

public class SaveThePrincess {
	
	public int solution(int n, int k) {
		// queue(선입선출의 자료구조) 를 이용한다.
		// queue에 1번 부터 N번 까지 왕자들의 번호를 담는다.
		// K 숫자를 부를 때까지 앞의 번호를 뺴고 뒤로 붙여준다.
		// K 숫자를 부르면 queue에서 제외 시켜주고 다음 반복을 진행한다.
		// 번호가 1개 남을 때 answer에 담아주고, Queue를 비워줄 때까지 위의 진행을 반복한다.
		int answer = 0;
		Queue<Integer> Q = new LinkedList<>();
		for(int i = 1; i <= n; i++) Q.offer(i);
		
		while(!Q.isEmpty()) { // 비어있지 않은 조건에서만 while문
			for(int i = 1; i < k; i++) Q.offer(Q.poll()); // K 전까지 맨앞 번호를 맨뒤로 넣어준다.
			Q.poll(); // K가 되는 순간 빼준다.
			if(Q.size()==1) answer = Q.poll(); // 1개 남으면 그 번호가 answer
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		SaveThePrincess T = new SaveThePrincess();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		System.out.print(T.solution(n, k));
	}
}
