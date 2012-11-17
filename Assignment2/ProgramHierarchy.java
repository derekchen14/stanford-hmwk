/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;

public class ProgramHierarchy extends GraphicsProgram {	

	private static final long serialVersionUID = 1L;

	private static final int BOX_HEIGHT = 60;
	private static final int BOX_WIDTH = 150;
	
	public void run() {
		addBoxes();
		addLines();
		addLabels();		
	}
	
	private void addBoxes() {
		//set variables
		int sMidWidth=getWidth()/2;
		int sMidHeight=getHeight()/2+(BOX_HEIGHT/2);
		int leftStretch=((3*BOX_WIDTH)/2)+(BOX_HEIGHT/2);
		int rightStretch=(BOX_WIDTH/2)+(BOX_HEIGHT/2);
		
		//instantiate boxes
		GRect box1=new GRect(sMidWidth-(BOX_WIDTH/2),sMidHeight-(2*BOX_HEIGHT),BOX_WIDTH,BOX_HEIGHT);
		GRect box2=new GRect(sMidWidth-leftStretch,sMidHeight,BOX_WIDTH,BOX_HEIGHT);
		GRect box3=new GRect(sMidWidth-(BOX_WIDTH/2),sMidHeight,BOX_WIDTH,BOX_HEIGHT);
		GRect box4=new GRect(sMidWidth+rightStretch,sMidHeight,BOX_WIDTH,BOX_HEIGHT);
		
		//put boxes on the screen
		add(box1);
		add(box2);
		add(box3);
		add(box4);
	}
	
	private void addLines(){
		//set variables
		int sMidWidth=getWidth()/2;
		int sMidHeight=getHeight()/2+(BOX_HEIGHT/2);
		int leftGap=BOX_WIDTH+(BOX_HEIGHT/2);
		int rightGap=leftGap;
		
		//instantiate lines
		GLine lineLeft=new GLine(sMidWidth,sMidHeight-BOX_HEIGHT,sMidWidth-leftGap,sMidHeight);
		GLine lineMiddle=new GLine(sMidWidth,sMidHeight-BOX_HEIGHT,sMidWidth,sMidHeight);
		GLine lineRight=new GLine(sMidWidth,sMidHeight-BOX_HEIGHT,sMidWidth+rightGap,sMidHeight);
		
		//put lines on the screen
		add(lineLeft);
		add(lineMiddle);
		add(lineRight);
	}

	private void addLabels(){
		//set variables
		int sMidWidth=getWidth()/2;
		int sMidHeight=getHeight()/2+(BOX_HEIGHT/2);
		int leftGap=BOX_WIDTH+(BOX_HEIGHT/2);
		int rightGap=leftGap;
		
		//instantiate labels
		GLabel label1=new GLabel("Program",0,0);
		GLabel label2=new GLabel("GraphicsProgram",0,0);
		GLabel label3=new GLabel("ConsoleProgram",0,0);
		GLabel label4=new GLabel("DialogProgram",0,0);

		//make font bigger, just for kicks
		label1.setFont("SansSerif-Bold-14");
		label2.setFont(label1.getFont());
		label3.setFont(label1.getFont());
		label4.setFont(label1.getFont());
		
		//figure out where the labels will go
		int label1start=(int) (sMidWidth-(label1.getWidth()/2));
		int topTextHeight=(int) (sMidHeight-((3*BOX_HEIGHT)/2)+(label1.getAscent()/2));

		int label2start=(int) (sMidWidth-leftGap-(label2.getWidth()/2));
		int label3start=(int) (sMidWidth-(label3.getWidth()/2));
		int label4start=(int) (sMidWidth+rightGap-(label4.getWidth()/2));
		int bottomTextHeight=(int) (sMidHeight+(BOX_HEIGHT/2)+(label2.getAscent()/2));
		
		//set the location of the labels
		
		label1.setLocation(label1start,topTextHeight);
		label2.setLocation(label2start, bottomTextHeight);
		label3.setLocation(label3start, bottomTextHeight);
		label4.setLocation(label4start, bottomTextHeight);
		
		//put labels on the screen
		add(label1);
		add(label2);
		add(label3);
		add(label4);
	}
}

//Completed