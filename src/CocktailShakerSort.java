/*
 * File: CocktailShakerSort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

import java.awt.Color;

public class CocktailShakerSort{
	public CocktailShakerSort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		int begin = -1;
		int end = g.nums.size() - 1;
		boolean swapped = true;
		while(swapped) {
			begin++;
			swapped = false;
			for(int i = begin; i < end; i++) {
				if(r.getValNoPause(g.nums, i) 
						> r.getValNoPause(g.nums, i+1)) {
					r.swap(g.nums, i, i+1);
					swapped = true;
				} else r.extraPause(g.nums, i);
			}
			
			g.nums.get(end).r.setFillColor(Color.GREEN);
			if(!swapped) break;
			end--;
			swapped = false;
			for(int i = end-1; i >= begin; i--) {
				if(r.getValNoPause(g.nums, i) 
						> r.getValNoPause(g.nums, i+1)) {
					r.swap(g.nums, i, i+1);
					swapped = true;
				} else r.extraPause(g.nums, i+1);
			}
			g.nums.get(begin).r.setFillColor(Color.GREEN);
		}
		
	}
	
	private SortShell r;
	private Sorter g;
}
