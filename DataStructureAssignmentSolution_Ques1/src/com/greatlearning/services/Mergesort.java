package com.greatlearning.services;

public class Mergesort {
	public static void merge(int[][] arr, int left, int right, int mid) {
		int len1 = mid - left + 1;
		int len2 = right - mid;

		int i = 0, j = 0, k;
		int[][] leftArr = new int[len1][2];
		int[][] rightArr = new int[len2][2];

		for (i = 0; i < len1; i++) {
			leftArr[i][0] = arr[left + i][0];
			leftArr[i][1] = arr[left + i][1];
		}

		for (j = 0; j < len2; j++) {
			rightArr[j][0] = arr[mid + 1 + j][0];
			rightArr[j][1] = arr[mid + 1 + j][1];
		}

		i = 0;
		j = 0;
		k = left;

		while (i < len1 && j < len2) {
			if (leftArr[i][0] > rightArr[j][0]) {
				arr[k][0] = leftArr[i][0];
				arr[k][1] = leftArr[i][1];
				i++;
			} else {
				arr[k][0] = rightArr[j][0];
				arr[k][1] = rightArr[j][1];
				j++;
			}
			k++;
		}

		while (i < len1) {
			arr[k][0] = leftArr[i][0];
			arr[k][1] = leftArr[i][1];
			i++;
			k++;
		}

		while (j < len2) {
			arr[k][0] = rightArr[j][0];
			arr[k][1] = rightArr[j][1];
			j++;
			k++;
		}
	}

	public static void mergesort(int[][] arr, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;

		mergesort(arr, left, mid);
		mergesort(arr, mid + 1, right);

		merge(arr, left, right, mid);
	}

	public static void sort(int[][] arr) {
		mergesort(arr, 0, arr.length - 1);
	}
}