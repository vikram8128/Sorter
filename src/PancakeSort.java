/*
 * File: PancakeSort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */
import java.awt.Color;
public class PancakeSort{
	public PancakeSort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		int c = 0;
		for(int i = 0; i < g.currentnum; i++) {
			int max = r.getVal(g.nums, 0);
			int id = 0;
			for(int j = 1; j < g.currentnum-c; j++) {
				int x = r.getVal(g.nums, j);
				if(x > max) {
					id = j;
					max = x;
				}
			}
			r.reverse(g.nums, 0, id, Color.CYAN, Color.BLUE);
			r.reverse(g.nums, 0, g.nums.size()-(1+c));
			g.nums.get(g.nums.size()-(1+c)).r.setFillColor(Color.GREEN);
			c++;
		}
	}
	
	private SortShell r;
	private Sorter g;
}
