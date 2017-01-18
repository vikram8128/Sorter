/*
 * File: SelectionSort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

import java.awt.Color;

public class SelectionSort{
	
	public SelectionSort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		for(int i = 0; i < g.currentnum; i++) {
			int min = r.getVal(g.nums, i);
			int id = i;
			for(int j = i; j < g.currentnum; j++) {
				int x = r.getVal(g.nums, j);
				if(x < min) {
					id = j;
					min = x;
				}
			}
			r.swap(g.nums, id, i);
			g.nums.get(i).r.setFillColor(Color.GREEN);
		}
	}
	
	private SortShell r;
	private Sorter g;
}
