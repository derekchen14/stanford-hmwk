package sectionAssignment;

import acm.graphics.*;
import acm.program.*;

public class makeGreen extends GraphicsProgram {
	public void run() {
		GImage milkmaid=new GImage("milkmaid.jpg");
		add(milkmaid,80,80);

		GImage droid=fillGreen(milkmaid);
		add(droid,400,80);
	}
		
	private GImage fillGreen(GImage img) {
		//Gets copy of pixel array from image
		int[][] array = img.getPixelArray();
		int height = array.length;
		int width = array[0].length;			

		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				int r = 255;
				int g = 255;
				int b = 255;
				array[i][j] = GImage.createRGBPixel (r,g,b);
			}
		}
		
		for (int i=0; i<height/2; i++) {
			for (int j=0; j<width/2; j++) {
				int r = 164;
				int g = 198;
				int b = 57;
				array[i][j] = GImage.createRGBPixel (r,g,b);
			}
		}
		
		for (int i=height/2; i<height; i++) {
			for (int j=width/2; j<width; j++) {
				int r = 182;
				int g = 52;
				int b = 187;
				array[i][j] = GImage.createRGBPixel (r,g,b);
			}
		}
		
		return new GImage(array);
	}
}
