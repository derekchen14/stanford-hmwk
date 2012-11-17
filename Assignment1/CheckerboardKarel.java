/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run(){
		if (frontIsBlocked()){
				turnLeft();
				putAltBeepers();
		}
		
		while(frontIsClear()){
			putAltBeepers ();
			checkBehindForBeeper();
			jumpLevel();
		}
		
	}

//Moves Karel up one step when she is facing East
	private void goEastToWest(){
		if(leftIsClear()){
			if(beepersPresent()){
				turnLeft();
				move();
				turnLeft();
				move();
			} else {
				turnLeft();
				move();
				turnLeft();
			}
		}
	}
	
//Moves Karel up one step when she is facing West
	private void goWestToEast(){
		if(rightIsClear()){
			if(beepersPresent()){
				turnRight();
				move();
				turnRight();
				move();
			} else {
				turnRight();
				move();
				turnRight();
			}
		}
	}
	
//Moves Karel up one step whether or not she is going east or west	
	private void jumpLevel(){

		if (facingEast()){
			goEastToWest();
		} else {
			goWestToEast();
		}
	}
	
	
/*	Checks to see if Karel had just put down a beeper behind her and if not,
	Karel will put one down */
	
	private void checkBehindForBeeper(){
		turnAround();
		move();
		if(beepersPresent()){
			turnAround();
			move();
		} else {
			turnAround();
			move();
			putBeeper();
		}
	}
	
// Put beepers down in alternating pattern in front of you
	private void putAltBeepers(){
		while(frontIsClear()) {
			putBeeper();
			move();
			if(frontIsClear()){
				move();
			}
		}
	}
	
} 

// Completed
		