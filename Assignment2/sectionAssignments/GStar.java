package sectionAssignments;

import acm.graphics.*;
import acm.util.*;

public class GStar extends GCompound {				
	
	//private instance variable
	private GPolygon star;

	public GStar(double star_size) {
		star=makeStar(star_size);
		
		double wScreen=getWidth()/2;
		double hScreen=getHeight()/2;
		
		add(star,wScreen,hScreen);
	}
	
	private GPolygon makeStar(double x) {
		GPolygon poly=new GPolygon ();
		poly.addVertex(0,-100);			//edge 1
		poly.addVertex(22,-30.9); 
		poly.addVertex(95.1,-30.9); 	//edge 2
		poly.addVertex(36, 12);		
		poly.addVertex(58.8,80.9);		//edge 3
		poly.addVertex(0, 42);		
		poly.addVertex(-58.8,80.9); 	//edge 4
		poly.addVertex(-36, 12);		
		poly.addVertex(-95.1, -30.9);	//edge 5
		poly.addVertex(-22, -30.9);
		
		poly.setFilled(true);
		poly.setFillColor(rgen.nextColor());
		poly.scale(x);
		
		return poly;
	}
	
	private RandomGenerator rgen= RandomGenerator.getInstance();	
}
