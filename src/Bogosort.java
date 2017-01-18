/*
 * File: Bogosort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

public class Bogosort{
	
	public Bogosort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		while(true) {
			r.swap(g.nums, g.rgen.nextInt(0, g.nums.size()-1), g.rgen.nextInt(0, g.nums.size()-1));
			if(r.sorted(g.nums)) {
				break;
			}
		}		
	}
	
	private SortShell r;
	private Sorter g;
}
