package sectionAssignments;

import acm.util.*;
import acm.program.*;
import acm.graphics.*;


public class RandomCircles extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	
	
	public void run() {

		int cWidth=getWidth()/2;
		int cHeight=getHeight()/2;
		
		GLabel countDown=new GLabel("Start!",cWidth-30,cHeight-10);
		countDown.setFont("Times-Bold-14");
		add(countDown);
		pause(1400);
		
		for (int i=30; i>0; i--){
			//Create a label that counts down
			countDown.setLabel("There are "+i+" more circles left.");
			double wCD=countDown.getWidth()/2;
			double hCD=countDown.getAscent()/2;
			add(countDown,cWidth-wCD,cHeight-hCD);

			//create a circle with a random size
			int rRadius=rgen.nextInt(5,50);
			int diameter=rRadius*2;
			GOval circle=new GOval(0,0,diameter,diameter);

			//set a random location
			int rWidth=rgen.nextInt(getWidth()-diameter);
			int rHeight=rgen.nextInt(getHeight()-diameter);
			circle.setLocation(rWidth, rHeight);
			
			//set a random color
			circle.setFilled(true);
			circle.setColor(rgen.nextColor());
			
			add(circle);
			
			//take a random break
			int delay=rgen.nextInt(100, 1000);
			pause(delay);
		}
		
		countDown.setLabel("Finished!");
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}

//completed