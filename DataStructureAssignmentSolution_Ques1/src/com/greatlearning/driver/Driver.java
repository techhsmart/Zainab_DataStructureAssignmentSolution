package com.greatlearning.driver;

import java.util.Scanner;

import com.greatlearning.models.Queue;
import com.greatlearning.services.FloorBuilder;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the total number of floors in the building : ");
		int numFloors = in.nextInt();

		int[] floorSizeArr = new int[numFloors];
		for (int i = 1; i <= numFloors; i++) {
			System.out.println("Enter the floor size given on day : " + i);
			floorSizeArr[i - 1] = in.nextInt();
		}

		Queue[] solution = FloorBuilder.build(floorSizeArr);
		System.out.println("The order of construction is as follows: ");
		for (int i = 0; i < numFloors; i++) {
			int temp = i + 1;
			System.out.println("\nDay: " + temp);
			// solution[i].display();
			while (!solution[i].isEmpty()) {
				System.out.print(solution[i].remove() + " ");
			}
		}

		in.close();
	}

}