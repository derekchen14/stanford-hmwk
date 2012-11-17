package sectionAssignments;

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class RobotFace extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	
	private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 300;
	
	private static final int EYE_RADIUS = 20;
	
	private static final int MOUTH_WIDTH = 120;
	private static final int MOUTH_HEIGHT = 40;
	
	public void run (){
		//set variables
		int diameter = EYE_RADIUS*2;
		int cWidth = getWidth()/2;
		int cHeight = getHeight()/2;
		
		//instantiate objects (Face, Eyes, Mouth)
		GRect face=new GRect(cWidth-(HEAD_WIDTH/2),cHeight-(HEAD_HEIGHT/2),HEAD_WIDTH,HEAD_HEIGHT);
		GOval leftEye=new GOval(cWidth-(HEAD_WIDTH/4)-EYE_RADIUS,cHeight-(HEAD_HEIGHT/4)-EYE_RADIUS,diameter,diameter);
		GOval rightEye=new GOval(cWidth+(HEAD_WIDTH/4)-EYE_RADIUS,cHeight-(HEAD_HEIGHT/4)-EYE_RADIUS,diameter,diameter);
		GRect mouth=new GRect(cWidth-(MOUTH_WIDTH/2),cHeight+(HEAD_HEIGHT/4)-(MOUTH_HEIGHT/2),MOUTH_WIDTH,MOUTH_HEIGHT);
		
		//fill in the color of the objects
		face.setFilled(true);
		face.setFillColor(Color.GRAY);
		
		leftEye.setColor(Color.YELLOW);
		leftEye.setFilled(true);
		leftEye.setFillColor(Color.YELLOW);
		
		rightEye.setColor(Color.YELLOW);
		rightEye.setFilled(true);
		rightEye.setFillColor(Color.YELLOW);
		
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
				
		//print them to the screen
		add(face);
		add(leftEye);
		add(rightEye);
		add(mouth);	
	}	
}


//Completed
