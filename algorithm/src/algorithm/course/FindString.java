package algorithm.course;

import java.util.Scanner;

// 1. ���� ã��
// �� ���� ���ڿ��� �Է� �ް�,
// Ư�� ���ڿ��� �Է¹޾�
// �ش� Ư�� ���ڰ� �Է¹��� ���ڿ��� �� �� �����ϴ��� �˾Ƴ��� ���α׷��� �ۼ��ϼ���.
// (��ҹ��� ���� x , ���ڿ� ���� 100 ���� ����)

// �Է�: ù �ٿ� ���ڿ�, �ι�° �ٿ� ����, ���� ���ĺ����θ� ����
// ���: ù �ٿ� �ش� ������ ������ ���

class FindString { // class �̸��� Main ���� �ؾ� ���� or ä�� ����Ʈ���� ä�� ����
	
	// ���α׷��ӽ� ����
	public int solution(String str, char t) {
		int answer = 0;
		str = str.toUpperCase(); // ��� �빮�ڷ�
		t = Character.toUpperCase(t); // �빮�ڷ� (char Ÿ���� �̷���)
//		for(int i=0; i < str.length(); i++) {
//			if(str.charAt(i) == t) answer += 1;
//		}
		for(char x : str.toCharArray()) { // ���ڿ��� �迭�� �����
			if(x == t) answer += 1;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		//Main T = new Main();
		FindString T = new FindString(); // �ν��Ͻ� �޼����� solution ȣ���ϱ� ����
		
		Scanner kb = new Scanner(System.in); // �ܼ� �����
		
		System.out.println("���ڿ��� �Է����ּ���.");
		String str = kb.next(); // �ܼ�â���� ���ڿ� �о����
		
		System.out.println("���ڸ� �Է����ּ���.");
		char c = kb.next().charAt(0);// ���ڿ� �� ���� �ϳ� �о����
		
		System.out.print(T.solution(str, c));
		kb.close();
	}

}
