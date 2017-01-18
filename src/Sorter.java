/*
 * File: Sorter.java
 * Name: Vikram Singh (c) 2015
 * This project is licensed under the terms of the MIT license.
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import acm.gui.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Sorter extends GraphicsProgram {
	public static void main(String[]args) {
		new Sorter().start(args);
	}
	
	public static final int APPLICATION_WIDTH = 1440;
	public static final int APPLICATION_HEIGHT = 850;
	
	public void init() {
		timer.setText("0.000s");
		add(timer, NORTH);
		add(new JLabel("Algorithm: "), SOUTH);
		sorts.addItem("Pancake sort");
		sorts.addItem("Bogo sort");
		sorts.addItem("Quicksort");
		sorts.addItem("Bubble sort");
		sorts.addItem("Cocktail shaker sort");
		sorts.addItem("Insertion sort");
		sorts.addItem("Selection sort");
		sorts.addItem("Heap sort");
		sorts.addItem("Merge sort");
		add(sorts, SOUTH);
		sorts.addActionListener(this);
		
		numElements.setMaximum(1000);
		numElements.setMinimum(7);
		numElements.setValue(currentnum);
		add(new JLabel("                 Number of Elements: "), SOUTH);
		add(numElements, SOUTH);
		numElements.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				pcurrentnum = numElements.getValue();
				numl.setText(Integer.toString(pcurrentnum));
				updatePTime();
	        }
		});
		
		numl.setText(Integer.toString(pcurrentnum));
		add(numl, SOUTH);

		add(new JLabel("                 Pause between steps: "), SOUTH);
		add(pauses, SOUTH);
		pauses.setText(Integer.toString(ptime));
		pauses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatePTime();
			}			
		});
		add(new JLabel("ms       "), SOUTH);
		add(st, SOUTH);
		st.addActionListener(this);	
	}
	
	private void updatePTime() {
		ptime = pauses.getValue();
		if(ptime < 0) {
			ptime = 0;
		} else if(ptime > 2000) {
			ptime = 2000;
		}
		pauses.setText(Integer.toString(ptime));
	}

	public void actionPerformed(ActionEvent e) {
		updatePTime();
		if(e.getActionCommand().equals("Stop")) {
			stopped = true;
			st.setText("Go!");
		} else if(e.getActionCommand().equals("Go!")) {
			removeAll();
			nums.clear();
			timer.setText("0.000s");
			st.setText("Stop");
			stopped = false;
			currentnum = pcurrentnum;
			alg = sorts.getSelectedItem().toString();
			randomize();
		}
	}
	
	public void reset() {
		st.setText("Go!");
	}
	
	private void randomize() {
		for(int i = 0; i < currentnum;i++) {
			nums.add(new SortObj(this, i, this.getWidth()/currentnum, i, (this.getHeight()-100.0)/currentnum));
		}
		SortShell r = new SortShell(this, alg);
		t = new Thread(r);
		t.start();
	}
	
	public Thread t;
	public boolean stopped = true;
	private JButton st = new JButton("Go!");
	public int ptime = 10;
	private int pcurrentnum = 200;
	public int currentnum = 200;
	public JLabel timer = new JLabel();
	private JLabel numl = new JLabel();
	private JComboBox sorts = new JComboBox();
	private JSlider numElements = new JSlider();
	private IntField pauses = new IntField(4);
	public ArrayList<SortObj> nums = new ArrayList<SortObj>();
	public RandomGenerator rgen = RandomGenerator.getInstance();
	private String alg = "";
}

