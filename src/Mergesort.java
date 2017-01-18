/*
 * File: Mergesort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */
import java.awt.Color;
import java.util.ArrayList;

public class Mergesort{
	
	public Mergesort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
	public void sort() {
		sort(g.nums, 0, g.nums.size()-1);
	}

	private void sort(ArrayList<SortObj> A, int s, int e) {
		if (e-s < 1) return;

		int m = (e+s)/2;
		sort(A, m+1, e);
		sort(A, s, m);
		
		ArrayList<SortObj> SArray = new ArrayList<SortObj>();
		int lh = s;
		int rh = m+1;
		for(int i = s; i <= e; i++) {
			if (lh > m) {
				SArray.add(A.get(rh++));
			} else if (rh > e) {
				SArray.add(A.get(lh++));
			} else if (r.getValNoPause(A,lh) <= r.getValNoPause(A,rh)) {
				SArray.add(A.get(lh++));
			} else {
				SArray.add(A.get(rh++));
			}
			SArray.get(SArray.size()-1).r.setFillColor(Color.WHITE);
			r.extraPause();
		}
		copyArray(A, SArray, s);
	}
	
	private void copyArray(ArrayList<SortObj> dest, ArrayList<SortObj> src, int si) {
		for (int i = 0; i < src.size(); i++) {
			dest.set(si + i, src.get(i));
			dest.get(si + i).update(si + i, Color.PINK);
		}
	}
	
	private SortShell r;
	private Sorter g;
}
