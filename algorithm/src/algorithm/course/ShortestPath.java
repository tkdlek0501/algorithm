package algorithm.course;

import java.util.Scanner;

//#62 Tree 말단 노드까지 최단 경로

// 이진 트리에서 
// 루트 노드 1부터 말단 노드까지의 길이 중 가장 짧은 길이를 구하는 프로그램 작성
// 각 경로의 길이는 루트에서 말단노드 까지 가는데 이동하는 횟수를 
// 즉 간선의 개수를 길이로 한다

public class ShortestPath {
	Node root;
	public int DFS(int L, Node root){
		if(root.lt==null && root.rt==null) return L; // 자식 노드 없으면 말단
		else return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt)); // 자식 노드 재귀
	}
	
	
	public static void main(String[] args) {
		ShortestPath tree = new ShortestPath();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		System.out.println(tree.DFS(0, tree.root));
	}
}
