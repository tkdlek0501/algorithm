package algorithm.course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//#43 응급실

// 환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자 목록을 꺼냅니다.
// 나머지 대기 목록에서 꺼낸 환자보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣습니다.
// 그렇지 않으면 진료를 받습니다.

// N명의 환자가 대기목록에 있을 때,
// N명의 대기목록 순서의 환자 위험도가 주어지면, 대기목록상의 M번째 환자는 
// 몇 번째로 진료를 받는지 출력하는 프로그램을 작성
// 대기목록 첫번째 환자는 0번째로 간주한다.

// 입력
// 첫 줄에 자연수 N(5<=N<=100) 과 M(0<=M<N) 이 주어진다.
// 두번째 줄에 접수한 순서대로 환자의 위험도 (50<=위험도<=100)가 주어진다.
// 위험도는 값이 높을 수록 더 위험하다는 뜻, 같은 값의 위험도가 존재할 수 있다.
// 5 2
// 60 50 70 80 90

// 출력
// M번째 환자가 몇 번째로 진료받는지 출력
// 3

public class EmergencyRoom {
	
	public int solution(int n, int m, int[] arr) {
		int answer = 1; // 순서
		
		// 1. 위험도가 동일할 수 있다 -> 위험도만을 가지고는 어떤 환자인지 구분 어렵다
		// Person 이라는 객체를 만들어 순서와 위험도를 필드로 가지게 한다
		// 2. 맨 앞의 환자가 위험도가 가장 큰 환자가 아니라면 뒤로 줄세워야 하기 때문에
		// Queue 자료구조를 활용한다
		// 3. 맨 앞의 환자를 꺼내고 나머지 대기 목록과 위험도를 비교하며 순번을 결정하는 로직을 작성
		// 위험도가 가장 높지 않다면 뒤로 보내주고 다음 첫번째 사람 체크
		// 위험도가 가장 높다면 m번째 사람인지 체크
		
		
		
		// Person 이라는 객체를 만들어
		// 환자의 번호와 위험도를 필드로 가지게 한다.
		// 이 Person을 Queue에 담아준다
		Queue<Person> Q = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++){
			Q.offer(new Person(i, arr[i]));
		}
		
		while(!Q.isEmpty()) {
			Person tmp = Q.poll(); // 맨 앞의 환자를 꺼내온다
			
			for(Person p : Q) { // 위 환자보다 위험도가 높은 환자가 있는지 체크
				if(tmp.emergency < p.emergency) {
					Q.offer(tmp); // 맨뒤로 담아준다
					tmp = null;
					break;
				}
			}
			
			if(tmp != null) { // tmp가 위험도가 가장 높은 환자일 때
				if(tmp.seq == m) return answer; // m번째 환자이면  answer
				else answer++; // 아니면 순번을 높여준다
			}
		}
		
		return answer;
	}
	
	class Person {
		int seq;
		int emergency;
		
		Person(int seq, int emergency) {
			this.seq = seq;
			this.emergency = emergency;
		}
	}
	
	
	public static void main(String[] args) {
		EmergencyRoom T = new EmergencyRoom();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		int m = kb.nextInt();
		
		int[] arr = new int[n];
		
		for(int i : arr) {
			arr[i] = kb.nextInt();
		}
		
		System.out.print(T.solution(n, m, arr));
	}
}
