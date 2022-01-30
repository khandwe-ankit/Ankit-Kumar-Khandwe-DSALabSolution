package LongestPathToLeafNode;

import java.util.ArrayList;

public class FindLongestPathToLeafNodeSolution {

	static class Node {
		Node leftNode;
		Node rightNode;
		int nodeData;
	}

	static Node newNode(int nodeData) {
		Node temp = new Node();
		temp.leftNode = null;
		temp.rightNode = null;
		temp.nodeData = nodeData;
		return temp;

	}

	public static void main(String[] args) {
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.leftNode.leftNode.leftNode = newNode(5);
		root.rightNode.leftNode = newNode(110);
		root.rightNode.rightNode = newNode(140);

		ArrayList<Integer> result = findLongestPath(root);
		int size = result.size();
		for (int i = size - 1; i >= 0; i--) {
			System.out.print(result.get(i) + " ");
		}
	}

	private static ArrayList<Integer> findLongestPath(Node root) {
		if (root == null) {
			ArrayList<Integer> result = new ArrayList<Integer>();
			return result;
		}
		ArrayList<Integer> rightNodeData = findLongestPath(root.rightNode);
		ArrayList<Integer> leftNodeData = findLongestPath(root.leftNode);

		if (leftNodeData.size() > rightNodeData.size())
			leftNodeData.add(root.nodeData);
		else
			rightNodeData.add(root.nodeData);

		return leftNodeData.size() > rightNodeData.size() ? leftNodeData : rightNodeData;
	}

}
