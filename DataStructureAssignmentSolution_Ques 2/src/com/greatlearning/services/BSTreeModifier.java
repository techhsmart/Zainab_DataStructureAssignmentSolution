package com.greatlearning.services;

import java.util.PriorityQueue;
import java.util.Queue;

import com.greatlearning.models.*;

public class BSTreeModifier {

	public static void balancedToSkew(BST tree) {
		Node newRoot = null, ptr = null;
		Queue<Integer> nodeVal = inorderTraverse(tree);

		newRoot = new Node(nodeVal.remove());
		ptr = newRoot;
		while (!nodeVal.isEmpty()) {
			ptr.right = new Node(nodeVal.remove());
			ptr = ptr.right;
		}

		tree.root = newRoot;
	}

	public static Queue<Integer> inorderTraverse(BST tree) {
		Queue<Integer> nodeVal = new PriorityQueue<>();
		recursiveInorderTraverse(tree.root, nodeVal);

		return nodeVal;
	}

	private static void recursiveInorderTraverse(Node root, Queue<Integer> nodeVal) {
		if (root == null)
			return;

		recursiveInorderTraverse(root.left, nodeVal);
		nodeVal.add(root.data);
		recursiveInorderTraverse(root.right, nodeVal);
	}

}