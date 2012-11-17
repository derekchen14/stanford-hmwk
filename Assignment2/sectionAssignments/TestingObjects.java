package sectionAssignments;

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class TestingObjects extends GraphicsProgram {
	private static final long serialVersionUID = 1L;
	private GObject block;
	private double xOriginal;
	private double yOriginal;
	
	public void run() {		
		//add the image
		GImage logo=new GImage("cal.gif");
		logo.scale(0.5);
		double wLogo=logo.getWidth();
		double hLogo=logo.getHeight();
		add(logo,400,280);
		
		//add another image
		GImage logo2=new GImage("ucla.gif");
		logo2.setSize(wLogo, hLogo);
		add(logo2,30,30);	
		
		//add a third image
		GImage logo3=new GImage("yale.gif");
		logo3.setSize(wLogo, hLogo);
		add(logo3,400,30);

		//add a fourth image
		GImage logo4=new GImage("mit.gif");
		logo4.setSize(wLogo, hLogo);
		add(logo4,30,280);
		
		//make the magic happen
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		xOriginal=e.getX();
		yOriginal=e.getY();
		block=getElementAt(xOriginal,yOriginal);
	}
	
	public void mouseDragged(MouseEvent e) {
		if (block != null) {
			block.move(e.getX()-xOriginal, e.getY()-yOriginal);
			
			//reset the original x,y coordinates
			xOriginal=e.getX();
			yOriginal=e.getY();
		}	
	}
	
	public void mouseReleased(MouseEvent e) {
		if (block != null) {block.sendToFront();}
	}

}

