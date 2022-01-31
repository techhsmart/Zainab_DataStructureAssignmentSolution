package com.greatlearning.services;

import com.greatlearning.models.*;

public class FloorBuilder {

	public static Queue[] build(int[] floorSizeArr) {
		int numDays = floorSizeArr.length;
		Queue[] buildOrder = new Queue[numDays];
		int[][] floorPlan = new int[numDays][2];

		for (int i = 0; i < numDays; i++) {
			floorPlan[i][0] = floorSizeArr[i];
			floorPlan[i][1] = i + 1;
			buildOrder[i] = new Queue(numDays);
		}

		Mergesort.sort(floorPlan);
		/*
		 * System.out.println("The sorted out floor sizes with day of arrival: "); for
		 * (int i = 0; i < numDays; i++) System.out.println(floorPlan[i][0] + " | " +
		 * floorPlan[i][1]);
		 */

		int index = 0;
		for (int i = 0; i < numDays; i++) {
			if (floorPlan[index][1] < i + 1)
				continue;

			while (index < numDays && floorPlan[index][1] <= i + 1) {
				buildOrder[i].insert(floorPlan[index][0]);
				index++;
			}
		}

		return buildOrder;
	}
}