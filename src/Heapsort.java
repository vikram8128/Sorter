/*
 * File: Heapsort.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */
import java.awt.Color;
import java.util.ArrayList;

public class Heapsort{
	
	public Heapsort(Sorter g, SortShell r) {
		this.g = g;
		this.r = r;
	}
	
    private int n;
    private int left;
    private int right;
    private int largest;

    
    public void heapify(){
        n = g.nums.size()-1;
        for(int i=n/2;i>=0;i--){
            siftDown(i);
        }
    }
    
    public void siftDown(int i){ 
        left = 2*i;
        right = 2*i+1;
        if(left <= n && r.getValNoPause(g.nums, left) > r.getValNoPause(g.nums, i)){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && r.getValNoPause(g.nums, right) > r.getValNoPause(g.nums, largest)){
            largest=right;
        }

        if(largest!=i){
            r.swap(g.nums, i, largest);
            g.nums.get(i).r.setFillColor(Color.CYAN);
            if (left <= n) g.nums.get(left).r.setFillColor(Color.CYAN);
            if (right <= n) g.nums.get(right).r.setFillColor(Color.CYAN);
            siftDown(largest);
        }
    }
    
    
    public void sort(){
        heapify();
        
        for(int i=n;i>0;i--){
            r.swap(g.nums, 0, i);
            g.nums.get(i).r.setFillColor(Color.GREEN);
            n=n-1;
            siftDown(0);
        }
    }
	
	private SortShell r;
	private Sorter g;
}
