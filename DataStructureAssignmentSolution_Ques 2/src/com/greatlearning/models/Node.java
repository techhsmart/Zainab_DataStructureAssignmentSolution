package com.greatlearning.models;

public class Node {

	public int data;
	public Node left, right;

	public Node() {
		data = 0;
		left = right = null;
	}

	public Node(int num) {
		data = num;
		left = right = null;
	}
}