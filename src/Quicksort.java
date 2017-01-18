/*
 * File: Quicksort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

import java.awt.Color;

public class Quicksort{
	
	public Quicksort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		sort(0, g.nums.size()-1);
	}
	
	private void sort(int lo, int hi) {
		if (lo < hi) {
			int p = partition(lo, hi);
			g.nums.get(p).r.setFillColor(Color.GREEN);
			sort(p+1, hi);
			sort(lo, p-1);		
		}
	}
	
	private int partition(int lo, int hi) {
		int pid = lo;
		int pval = r.getValNoPause(g.nums, pid);
		r.swap(g.nums, pid, hi);
		for (int i = lo; i < hi; i++) {
			if(r.getValNoPause(g.nums, i) < pval) {
				r.swap(g.nums, i, pid);
				pid++;
			} else r.extraPause(g.nums, i);
		}
		r.swap(g.nums, pid, hi);
		return pid;
	}
	
	private SortShell r;
	private Sorter g;
}
