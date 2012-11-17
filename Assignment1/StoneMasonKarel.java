/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run (){
		while(frontIsClear()){
			scaleColumn();
			nextColumn();
		}
		scaleColumn();
	}

	private void scaleColumn(){
		turnLeft();
		while(frontIsClear()){
			if(beepersPresent()){move();}
			else {putBeeper();}
		}		
		turnAround();
			if(noBeepersPresent()){
				putBeeper();
			}
		moveToWall();
		turnLeft();	
	}
	
	private void nextColumn(){
		move();
		move();
		move();
		move();	}
	
	private void moveToWall(){
		while(frontIsClear()){
			move();
		}
	}
}
// Complete