/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.util.ArrayList;

import acm.graphics.*;
import acm.util.*;

public class HangmanCanvas extends GCanvas {	
	private ArrayList<GLabel> ig=new ArrayList<GLabel>();
	
	public void run(int guessCount) {
		//initialize checkpoints
		int x0=5*getWidth()/9;
		int y0=50;
		int x1=x0;
		int y1=y0+(HEAD_RADIUS*2)+ARM_OFFSET_FROM_HEAD;
		int x2=x0;
		int y2=y0+(HEAD_RADIUS*2)+BODY_LENGTH;
		
		switch (guessCount) {
			case 8: drawScaffold(x0,y0); break;		
			case 7: drawHead(x0,y0); break;
			case 6: drawBody(x0,y0); break;
			case 5: drawLeftArm(x1,y1); break;
			case 4: drawRightArm(x1,y1); break;
			case 3: drawLeftLeg(x2,y2); break;
			case 2: drawRightLeg(x2,y2); break;
			case 1: drawLeftFoot(x2,y2); break;
			case 0: drawRightFoot(x2,y2); break;
			default: throw new ErrorException ("Canvas received illegal guessCount.");
		}
	}	
	
	private void drawScaffold(int x, int y) {
		GLine scaffold=	new GLine(x-BEAM_LENGTH,y-ROPE_LENGTH+SCAFFOLD_HEIGHT,x-BEAM_LENGTH,y-ROPE_LENGTH);
		GLine beam=		new GLine(x-BEAM_LENGTH,y-ROPE_LENGTH,x,y-ROPE_LENGTH);
		GLine rope=		new GLine(x,y-ROPE_LENGTH,x,y);
		add(scaffold);
		add(beam);
		add(rope);
	}
	
	private void drawHead(int x, int y) {
		int d= HEAD_RADIUS*2;
		GOval head=new GOval (x-HEAD_RADIUS,y,d,d);
		add(head);
	}
	
	private void drawBody(int x, int y) {
		int d= HEAD_RADIUS*2;
		GLine body=new GLine (x,y+d,x,y+d+BODY_LENGTH);
		add(body);
	}
	
	private void drawLeftArm(int x, int y) {
		GLine la1=new GLine (x-UPPER_ARM_LENGTH,y,x,y); 
		GLine la2=new GLine (x-UPPER_ARM_LENGTH,y,x-UPPER_ARM_LENGTH,y+LOWER_ARM_LENGTH);
		add(la1);
		add(la2);
	}
	
	private void drawRightArm(int x, int y) {
		GLine ra1=new GLine (x,y,x+UPPER_ARM_LENGTH,y); 
		GLine ra2=new GLine (x+UPPER_ARM_LENGTH,y,x+UPPER_ARM_LENGTH,y+LOWER_ARM_LENGTH);
		add(ra1);
		add(ra2);
	}
	
	private void drawLeftLeg(int x, int y) {
		int z = HIP_WIDTH;
		GLine ll1=new GLine (x-z,y,x,y); 
		GLine ll2=new GLine (x-z,y,x-z,y+LEG_LENGTH);
		add(ll1);
		add(ll2);
	}
	
	private void drawRightLeg(int x, int y) {
		int z = HIP_WIDTH;
		GLine rl1=new GLine (x,y,x+z,y); 
		GLine rl2=new GLine (x+z,y,x+z,y+LEG_LENGTH);
		add(rl1);
		add(rl2);
	}

	private void drawLeftFoot(int x, int y) {
		int z = HIP_WIDTH;
		GLine lf=new GLine (x-z,y+LEG_LENGTH,x-z-FOOT_LENGTH,y+LEG_LENGTH); 
		add(lf);
	}
	
	private void drawRightFoot(int x, int y) {
		int z = HIP_WIDTH;
		GLine rf=new GLine (x+z,y+LEG_LENGTH,x+z+FOOT_LENGTH,y+LEG_LENGTH); 
		add(rf);
	}
	
/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {				
		GObject block = getElementAt(45,430);
		if (block != null) remove(block); 
		
		GLabel label=new GLabel(word,40,435);
		label.setFont("Courier-22");
		add(label);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String letter) {
		GLabel label = new GLabel(letter);
		double dx = label.getWidth();
		for (int i=0; i<ig.size(); i++) {
			ig.get(i).move(dx, 0);
		}
		add(label,40,455);
		ig.add(label);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
