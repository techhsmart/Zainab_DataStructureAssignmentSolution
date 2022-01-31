package com.greatlearning.models;

public class Queue {
	int[] arr;
	int size, front, end;

	public Queue() {
		size = 100;
		arr = new int[size];
		front = -1;
		end = -1;
	}

	public Queue(int cap) {
		size = cap;
		arr = new int[size];
		front = -1;
		end = -1;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return (front + 1) % size == end;
	}

	public void insert(int data) {
		if (isFull())
			return;

		if (isEmpty()) {
			front = end = 0;
			arr[front] = data;
		} else {
			front = (front + 1) % size;
			arr[front] = data;
		}
	}

	public int remove() {
		if (isEmpty())
			return -1;

		int temp = arr[end];
		if (front == end)
			front = end = -1;
		else
			end = (end + 1) % size;

		return temp;
	}

	public void display() {
		System.out.println("The Queue elements are: ");
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}