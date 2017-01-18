/*
 * File: SortObj.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

import acm.program.*;
import acm.graphics.*;

import java.awt.Color;


public class SortObj {
	
	public SortObj(GraphicsProgram gp, int v, int th, int l, double h) {
		w = gp;
		width = th;
		value = (int) (v*h);
		location = l;
		r = new GRect(location*width, (w.getHeight()-50) - value, width, value+h);
		r.setFilled(true);
		r.setFillColor(Color.GRAY);
		w.add(r);
		
	}
	
	public void update(int newLocation) {
		r.setLocation(newLocation*width, (w.getHeight()-50) - value);
		location = newLocation;
	}
	
	public void update(int newLocation, Color c) {
		r.setLocation(newLocation*width, (w.getHeight()-50) - value);
		location = newLocation;
		r.setFillColor(c);
	}
	
	private int location;
	private int width;
	public GRect r;
	public int value;
	private GraphicsProgram w;
	
}
