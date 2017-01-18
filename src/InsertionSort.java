/*
 * File: InsertionSort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

import java.awt.Color;

public class InsertionSort{
	
	public InsertionSort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		for(int i = 1; i < g.currentnum; i++) {
			int j = i; 
			while(j > 0 && r.getValNoPause(g.nums, j) < r.getValNoPause(g.nums, j - 1)) {
				r.swap(g.nums, j, j-1);
				j--;
			}
		}
	}
	
	private SortShell r;
	private Sorter g;
}
