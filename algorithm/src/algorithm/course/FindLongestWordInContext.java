package algorithm.course;

import java.util.Scanner;

// 3. ���� �� �ܾ� ã��
// �� ���� ������ �־����� �� ���� �ӿ��� ���� �� �ܾ ����ϴ� ���α׷��� �ۼ��ϼ���.
// �� �ܾ�� �������� ���е˴ϴ�.

// �Է�: ù �ٿ� ���̰� 100�� ���� �ʴ� �� ���� ������ �־����ϴ�. ���ĺ����θ� �����Ǿ� �ֽ��ϴ�.
// ��� : ù �ٿ� ���� �� �ܾ ����մϴ�. ���� ���̰� �� �ܾ �������̸� ���� �� �ʿ� ��ġ�� �ܾ ������ �մϴ�.

public class FindLongestWordInContext {
	
	public String solution1(String str) {
		String answer = "";
		//int m = Integer.MIN_VALUE; // ���� �ּҰ����� �ʱ�ȭ ; ����?
		int m = 0;
		
		// 1. ������ ������ �������� �߶� �迭�� �����
		String[] s = str.split(" ");
		
		// 2. �迭 �ȿ� ���� �ܾ���� ���̷� ���ؼ� ũ�� ���� ���ش�
		for(String x : s) {
			System.out.println("�迭 : " + x);
			int len = x.length();
			if(len > m) {
				m = len;
				answer = x;
			}
		}
		
		return answer;
	}
	
	public String solution(String str) {
		String answer = "";
		int m = 0, pos;
		// ���⸦ ã��, ��ã���� -1
		while((pos = str.indexOf(" ")) != -1) {
			String tmp = str.substring(0, pos); // first ~ last-1 ���� �߶�
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos + 1); // �� ���� �ܾ��� ���ۺ���
		}
		if(str.length() > m) answer = str; // ������ �ܾ���� ó������ߵ�
		
		return answer;
	}
	
	public static void main(String[] args) {
		FindLongestWordInContext T = new FindLongestWordInContext();
		Scanner kb = new Scanner(System.in);
		
		String str = kb.nextLine();
		System.out.print(T.solution(str));
	}
}
