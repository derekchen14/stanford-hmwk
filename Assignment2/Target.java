/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import java.awt.*;
import acm.program.*;
import acm.graphics.*;

public class Target extends GraphicsProgram {
	
	private static final long serialVersionUID = 1L;

	public void run() {
		addOuterCircle();
		addMiddleCircle();
		addInnerCircle();
	}
	
	private void addOuterCircle() {
		int radius = 72;
		int diameter = radius*2;
		int x = getWidth()/2 - radius;
		int y = getHeight()/2 - radius;
		GOval OuterCircle = new GOval (x, y, diameter, diameter);
		OuterCircle.setColor(Color.RED);
		OuterCircle.setFilled(true);
		OuterCircle.setFillColor(Color.RED);
		add(OuterCircle);
	}
	
	private void addMiddleCircle() {
		double radius = 72*65/100;
		double diameter = radius*2;
		double x = getWidth()/2 - radius;
		double y = getHeight()/2 - radius;
		GOval MiddleCircle = new GOval (x, y, diameter, diameter);
		MiddleCircle.setColor(Color.WHITE);
		MiddleCircle.setFilled(true);
		MiddleCircle.setFillColor(Color.WHITE);
		add(MiddleCircle);
	}
	
	private void addInnerCircle(){
		double radius = 72*30/100;
		double diameter = radius*2;
		double x = getWidth()/2 - radius;
		double y = getHeight()/2 - radius;
		GOval InnerCircle = new GOval (x,y,diameter,diameter);
		InnerCircle.setColor(Color.RED);
		InnerCircle.setFilled(true);
		InnerCircle.setFillColor(Color.RED);
		add(InnerCircle);
	}
}

//Completed