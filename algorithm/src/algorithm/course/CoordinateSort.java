package algorithm.course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//#50 좌표 정렬
// N개의 평면상의 좌표 (x,y) 가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성
// 정렬기준은 먼저 x값이 우선되고 x값이 같을 경우 y값에 의해 정렬

// 입력
// 첫째줄에 좌표의 개수인 N(3<=N<=100,000) 이 주어진다
// 두번째 줄부터 N개의 좌표가 x, y순으로 주어진다
// x,y값은 양수만 입력된다
// 5
// 2 7
// 1 3
// 1 2
// 2 5
// 3 6

// 출력
// N개의 좌표를 정렬
// 1 2
// 1 3
// 2 5
// 2 7
// 3 6

// TODO: 좌표를 정렬하는 방법 : Comparable 클래스를 상속
class Point implements Comparable<Point> { // 비교해서 정렬해주는 클래스를 상속; 좌표 등을 정렬할 때 자주 씀
	
	public int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if(this.x==o.x) return this.y - o.y; // this.y 가 앞, o.y가 뒤에 있으려면 음수값을 return 해야 한다
		else return this.x - o.x;
	}
}

public class CoordinateSort {
	
	public static void main(String[] args) {
		//CoordinateSort T = new CoordinateSort();
		Scanner kb = new Scanner(System.in);
		
		// 입력
		int n = kb.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr.add(new Point(x,y)); 
		}
		Collections.sort(arr); // 위에 상속받은 Comparable 에 의해 sort 기준이 잡힌다
		for(Point o : arr) System.out.println(o.x + " " + o.y);
	}
}
