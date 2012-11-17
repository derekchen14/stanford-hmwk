package sectionAssignments;

import acm.program.*;
import acm.graphics.*;
import java.awt.event.MouseEvent;

public class DrawingLines extends GraphicsProgram {
	private static final long serialVersionUID = 1L;

	//Private instance variables
	private GLine rubberband;

	
	public void init() {
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		int wScreen=getWidth()/2;
		int hScreen=getHeight()/2;

		double x=e.getX();
		double y=e.getY();
		rubberband=new GLine(wScreen,hScreen,x,y);
		add(rubberband);
	}
	
	public void mouseDragged(MouseEvent e) {		
		double x=e.getX();
		double y=e.getY();	
		rubberband.setEndPoint(x,y);
	}
	
	public void mouseReleased(MouseEvent e) {
		int wScreen=getWidth()/2;
		int hScreen=getHeight()/2;
		
		double x=e.getX();
		double y=e.getY();	
		rubberband.setEndPoint(wScreen+((x-wScreen)*0.8),hScreen+((y-hScreen)*0.8));
	}
	
}
