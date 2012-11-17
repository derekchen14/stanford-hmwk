/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 501;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - ((NBRICKS_PER_ROW + 5) * BRICK_SEP)) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
/** Time delay between movements, the lower the number, the faster the game */
	private static final int GAME_SPEED = 14;

	//declare your instances variables
	private RandomGenerator rgen=RandomGenerator.getInstance();
	private GRect brick;
	private GRect paddle;
	private GOval ball;
	private double vx, vy;
	private int turns = NTURNS;
	private int blockCount = NBRICKS_PER_ROW*NBRICK_ROWS;
	private int delay=GAME_SPEED;
	
	//load game sounds
	AudioClip bounce=MediaTools.loadAudioClip("bounce.au");
	AudioClip rockhit=MediaTools.loadAudioClip("rockhit.au");
	AudioClip sting=MediaTools.loadAudioClip("sting.au");	
	AudioClip wahwah=MediaTools.loadAudioClip("wahwah.au");
	
	public void run() {			
		startGame();
		buildBricks();
		buildBall();
		buildPaddle();		
		playGame();
	}
	
	private void startGame() {
		GLabel start=new GLabel("Click to start.");
		start.setFont("SansSerif-Bold-18");
		add(start,(getWidth()-start.getWidth())/2,(getHeight()-start.getAscent())/2);
		waitForClick();
		remove(start);
	}
	
	private void buildBricks(){		
		//set your local variables			
		double bWidth=(BRICK_WIDTH+BRICK_SEP);
		double bHeight=(BRICK_HEIGHT+BRICK_SEP);
		double wStart=BRICK_SEP*3;
		double hStart=BRICK_Y_OFFSET;
		
		//use a for loop to create one row of bricks
		for (int j=0; j<NBRICKS_PER_ROW; j++) {	
			//use a for loop to duplicate the rows
			for (int i=0; i<NBRICK_ROWS; i++) {				
				//set the colors
				brick=new GRect(BRICK_WIDTH,BRICK_HEIGHT);
				brick.setFilled(true);
				
				if (i<2) {
					brick.setColor(Color.RED);
				} else if (i<4) {
					brick.setColor(Color.ORANGE);
				} else if (i<6) {
					brick.setColor(Color.YELLOW);
				} else if (i<8) {
					brick.setColor(Color.GREEN);
				} else if (i<10) {
					brick.setColor(Color.CYAN);
				} else {
					brick.setColor(Color.MAGENTA);
				}
				
				//print money
				add(brick,wStart+(j*bWidth),hStart+(i*bHeight));
			}
		}	
	}
	
	private void buildPaddle() {
		paddle=new GRect(rgen.nextInt(400),HEIGHT-PADDLE_Y_OFFSET,PADDLE_WIDTH,PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.GRAY);
		add(paddle);	
	}
	
	public void mouseMoved(MouseEvent e) {
		double x=e.getX();
		double y=e.getY();

		if (y>HEIGHT/2 && x>(PADDLE_WIDTH/2) && x<WIDTH-(PADDLE_WIDTH/2)) {
			paddle.setLocation(x-(PADDLE_WIDTH/2),HEIGHT-PADDLE_Y_OFFSET);
		}
	}
	
	private void buildBall(){		
		double wScreen=getWidth()/2;
		double hScreen=getHeight()/2;
		int diameter=BALL_RADIUS*2;
		
		//create your ball
		ball=new GOval(wScreen-BALL_RADIUS,hScreen-BALL_RADIUS,diameter,diameter);
		ball.setFilled(true);
		add(ball);			
	}
	
	private void playGame() {
		//set your local variables
		vy=3.0;
		vx=rgen.nextDouble(1.0,3.0);
		if (rgen.nextBoolean(0.5)) {vx = -vx;}
		
		//start the game
		while (blockCount>0) {
			ball.move(vx,vy);
			checkForCollision();
			pause(delay);
		
			//speed things up as the game progresses
			if (blockCount<(NBRICK_ROWS*5)) {	
				if (blockCount<(NBRICK_ROWS*2)) {
					delay= GAME_SPEED-6;
				} else {delay= GAME_SPEED-3;}
			}

			if (ball.getY()>HEIGHT-(BALL_RADIUS*2)) break;
		}	
	}
	
	private void checkForCollision() {
		double x=ball.getX();
		double y=ball.getY();
		double sidePaddle=HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT-BALL_RADIUS+1;
		
		//logic to handle collisions
		GObject collider=getCollidingObject(x,y);
			if (collider==paddle) {
				if (y <=sidePaddle) {vy = -vy;}
				if (y > sidePaddle && y < sidePaddle+12) {
					vy = -vy;
					vx = -vx;}
				bounce.play();
			} else if (collider!=null) {
				vy = -vy; remove(collider);
				bounce.play();
				blockCount--;
			}
			
		//algorithm to end the game					
		if (blockCount==0) {
			endGame(true);
		}
		
		//logic to handle the game walls
		bounceOffWall(x,y);		
	}
	
	private GObject getCollidingObject(double xLoc, double yLoc) {		
		int d=BALL_RADIUS*2;
		GObject collider;
		
		collider = getElementAt(xLoc,yLoc);
		if (collider != null) {
			return collider; 
		} else collider = getElementAt(xLoc+d,yLoc);
		if (collider != null) {
			return collider;
		} else collider = getElementAt(xLoc,yLoc+d);
		if (collider != null) {
			return collider;
		} else collider = getElementAt(xLoc,yLoc+d);
		if (collider != null) {
			return collider;
		} else return null;
	}
	
	private void endGame(boolean x) {
		pause(1400);
		removeAll();		
		GLabel endGame=new GLabel("End Game");
		endGame.setFont("SansSerif-Bold-18");
		
		if (x==true) {endGame.setLabel("You Win!"); sting.play();}
		else {endGame.setLabel("[GAME OVER]"); wahwah.play();}	
		
		add(endGame,(getWidth()-endGame.getWidth())/2,(getHeight()-endGame.getAscent())/2);
	}
	
	private void bounceOffWall(double xLoc, double yLoc) {
		
		//logic to help bounce off the walls
		if (xLoc>WIDTH-(BALL_RADIUS*2) || xLoc<=0) {vx = -vx;}
		if (yLoc<1) {vy = -vy;}
		
		//algorithm to missed balls
		if (yLoc>HEIGHT-(BALL_RADIUS*2)) {
			rockhit.play();
			turns--;
			GLabel loseTurn=new GLabel("You lose. There are "+turns+" more turns left.");			
			add(loseTurn,(getWidth()-loseTurn.getWidth())/2,(getHeight()-loseTurn.getAscent())/2);
			if (turns>0) {
				waitForClick();
				remove(loseTurn);
				remove(ball);
				buildBall();
				playGame();
			} else {
				endGame(false); 
			}
		}
	}
	
	public void init()	{
		addMouseListeners();
	}
}

//Completed