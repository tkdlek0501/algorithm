package algorithm.course;

import java.util.LinkedList;
import java.util.Queue;

//#60 이진트리 순회
// 넓이 우선 탐색 : 레벨 탐색

class Node{
	int data;
	Node lt, rt;
	public Node(int val) {
		data = val;
		lt = rt = null;
	}
}

public class BinaryTreeWidth {
	Node root;
	public void BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			System.out.print(L + " : "); // 노드들의 레벨
			for(int i = 0; i < len; i++) {
				Node cur = Q.poll(); // Q에 넣은 값 꺼내기
				System.out.print(cur.data + " ");
				if(cur.lt != null) Q.offer(cur.lt); // 자식이 있으면 Queue에 넣어주기
				if(cur.rt != null) Q.offer(cur.rt);
			}
			L++;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeWidth tree = new BinaryTreeWidth();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		tree.BFS(tree.root); // 1부터
	}
}
