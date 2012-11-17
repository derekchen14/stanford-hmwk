package sectionAssignments;

import acm.program.*;
import acm.util.*;
import java.awt.event.*;

public class ClickForStar extends GraphicsProgram{
	private static final long serialVersionUID = 1L;
	
	public void init (){		
		addMouseListeners();
	}
	
	public void mouseClicked (MouseEvent e) {
		double size = rgen.nextDouble(0.1,0.8);
		
		double x=e.getX();
		double y=e.getY();		
		
		GStar star=new GStar(size);
		
		add(star,x,y);
	}
	
	private RandomGenerator rgen=RandomGenerator.getInstance();
}

