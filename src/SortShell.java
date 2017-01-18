/*
 * File: SortShell.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */



import java.awt.Color;
import java.util.*;

import acm.io.IODialog;


public class SortShell implements Runnable {
	
	public SortShell(Sorter g, String alg) {
		this.g = g;
		this.alg = alg;
	}
	
	public void run() {
		for(int i = 0; i < g.currentnum;i++) {
			swap(g.nums, i, g.rgen.nextInt(i, g.currentnum-1), 5);
			if(g.stopped) {
				return;
			}
		}
		startTimer();
		if (alg.equals("Pancake sort")) {
			PancakeSort s = new PancakeSort(g, this);
			s.sort();
		} else if (alg.equals("Bogo sort")) {
			Bogosort s = new Bogosort(g, this);
			s.sort();
		} else if (alg.equals("Quicksort")) {
			Quicksort s = new Quicksort(g, this);
			s.sort();
		} else if (alg.equals("Bubble sort")) {
			BubbleSort s = new BubbleSort(g, this);
			s.sort();
		} else if (alg.equals("Cocktail shaker sort")) {
			CocktailShakerSort s = new CocktailShakerSort(g, this);
			s.sort();
		} else if (alg.equals("Insertion sort")) {
			InsertionSort s = new InsertionSort(g, this);
			s.sort();
		} else if (alg.equals("Heap sort")) {
			Heapsort s = new Heapsort(g, this);
			s.sort();
		} else if (alg.equals("Merge sort")) {
			Mergesort s = new Mergesort(g, this);
			s.sort();
		} else if (alg.equals("Selection sort")) {
			SelectionSort s = new SelectionSort(g, this);
			s.sort();
		} else {
			IODialog dialog = g.getDialog();
			dialog.println("Unknown Sort " + alg);
		}
		if(sorted(g.nums)) {
			for (int i = 0; i < g.nums.size();i++) {
				g.nums.get(i).r.setFillColor(Color.GREEN);
			}
		}
		g.reset();
	}
	
	public void startTimer() {
		startTime = System.nanoTime();
		timing = true;
	}
	
	public void updateTimer() {
		if(timing) {
			long time = System.nanoTime() - startTime;
			time /= 1000000;
			long mod = time % 1000;
			String zeros = "";
			if (mod < 10) zeros += "00";
			else if (mod < 100) zeros += "0";
			g.timer.setText(Long.toString(time/1000) + "." + zeros + Long.toString(time % 1000) + "s");
		}
	}

	public int getVal(ArrayList<SortObj> list, int i) {
		return getVal(list, i, g.ptime);
	}

	
	public int getVal(ArrayList<SortObj> list, int i, int ptime) {
		SortObj x = list.get(i);
		if (ptime > 0) {
			Color c = x.r.getFillColor();
			x.r.setFillColor(Color.MAGENTA);
			extraPause(ptime);
			x.r.setFillColor(c);
		}
		if (g.stopped) g.t.stop();
		return x.value;
	}
	
	public int getValNoPause(ArrayList<SortObj> list, int i) {
		return getVal(list, i, 0);
	}
	
	public boolean sorted(ArrayList<SortObj> list) {
		for(int i = 0; i < list.size()-1;  i++) {
			if(list.get(i).value > list.get(i+1).value) return false;
		}
		return true;
	}
	
	public void reverse(ArrayList<SortObj> list, int start, int end) {
		reverse(list, start, end, Color.ORANGE, Color.YELLOW);
	}
	
	public void reverse(ArrayList<SortObj> list, int start, int end, Color c1, Color c2) {
		while (start < end) {
			swap(list, start, end, g.ptime, c1, c2);
			start++;
			end--;
		}		
	}

	public void swap(ArrayList<SortObj> list, int l, int h, int ptime) {
		swap(list, l, h, ptime, Color.ORANGE, Color.YELLOW);
	}
	
	public void swap(ArrayList<SortObj> list, int l, int h) {
		swap(list, l, h, g.ptime, Color.ORANGE, Color.YELLOW);
	}
	
	public void swap(ArrayList<SortObj> list, int l, int h, Color c1, Color c2) {
		swap(list, l, h, g.ptime, c1, c2);
	}

	public void swap(ArrayList<SortObj> list, int l, int h, int ptime, Color c1, Color c2) {
		SortObj a = list.get(l);
		SortObj b = list.get(h);
		a.r.setFillColor(c1);
		b.r.setFillColor(c2);
		list.set(l, b);
		list.set(h, a);
		a.update(h);
		b.update(l);
		extraPause(ptime);
		a.r.setFillColor(Color.PINK);
		b.r.setFillColor(Color.PINK);
		if(g.stopped) g.t.stop();
	}
	
	public void extraPause(int ptime) {
		try {
			Thread.sleep(ptime);
		} catch (InterruptedException e) {}
		updateTimer();
	}
	public void extraPause(ArrayList<SortObj> list, int i) {
		SortObj obj = list.get(i);
		Color c = obj.r.getFillColor();
		obj.r.setFillColor(Color.MAGENTA);
		extraPause(g.ptime);
		obj.r.setFillColor(c);
	}
	public void extraPause() {
		extraPause(g.ptime);
	}
	
	private boolean timing = false;
	private long startTime;
	private String alg;
	private Sorter g;
}
