package algorithm.course;

import java.util.LinkedList;
import java.util.Queue;

//#63 Tree 말단 노드까지 최단 경로

// 이진트리에서 루트 노드 1에서 말단 노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램을 작성
// 각 경로의 길이는 루트 노드에서 말단 노드까지 가는데 이동하는 횟수를 즉 간선의 개수를 길이로 한다

class Node{
	int data;
	Node lt, rt;
	public Node(int val) {
		data=val;
		lt=rt=null;
	}
}

public class ShortestPath2 {
	
	Node root;
	public int BFS(Node root) {
		Queue<Node> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i = 0; i < len; i++) {
				Node cur = Q.poll();
				if(cur.lt == null && cur.rt == null) return L;
				if(cur.lt != null) Q.offer(cur.lt);
				if(cur.rt != null) Q.offer(cur.rt);
			}
			L++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		
		ShortestPath2 tree = new ShortestPath2();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		System.out.println(tree.BFS(tree.root));
	}
}
