/*
 * File: BubbleSort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

import java.awt.Color;

public class BubbleSort{
	
	public BubbleSort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		int c = 0;
		for(int i = 0; i < g.currentnum; i++) {
			for(int j = 0; j < g.currentnum-c-1;j++) {
				if(r.getValNoPause(g.nums, j) > r.getValNoPause(g.nums, j+1)) {
					r.swap(g.nums, j, j+1);
				} else r.extraPause(g.nums, j);
			}
			g.nums.get(g.currentnum-c-1).r.setFillColor(Color.GREEN);
			c++;
		}
	}
	
	private SortShell r;
	private Sorter g;
}
