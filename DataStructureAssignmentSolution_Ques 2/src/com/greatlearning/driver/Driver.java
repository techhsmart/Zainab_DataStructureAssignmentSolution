package com.greatlearning.driver;

import com.greatlearning.models.*;
import com.greatlearning.services.BSTreeModifier;

public class Driver {

	public static void main(String[] args) {
		BST tree = new BST();
		tree.root = new Node(55);
		tree.root.left = new Node(30);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(10);
		tree.root.left.right = new Node(50);

		BSTreeModifier.balancedToSkew(tree);
		Node ptr = tree.root;
		while (ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.right;
		}
	}

}