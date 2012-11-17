/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;

public class Pyramid extends GraphicsProgram {

	private static final long serialVersionUID = 1L;

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	
	public void run() {
		buildPyramid();
	}
	
	private void buildPyramid(){
		//build rows until no more are needed
		for(int row=0; row<BRICKS_IN_BASE; row++) {
			
			//determines how many bricks to put in that row
			int baseCount = BRICKS_IN_BASE - row;
			int baseWidth=baseCount*BRICK_WIDTH;
			
			//lay and appropriate number of bricks for that row
			for (int i=0; i<baseCount; i++) {
				//set the location of each brick within the row
				int x = getWidth()/2 - (baseWidth/2) + (BRICK_WIDTH*i);
				int y = getHeight() - BRICK_HEIGHT*(row+1);
				GRect brick = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
				
				add(brick);				
			}
		}	
	}
}

