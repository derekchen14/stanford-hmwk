package sectionAssignment;

import acm.program.*;
import acm.graphics.*;

public class FlipHorizontal extends GraphicsProgram {

	public void run() {
		GImage milkmaid=new GImage("milkmaid.jpg");
		add(milkmaid,80,80);

		GImage flipped=flipHorizontal(milkmaid);
		add(flipped,380,80);
	}
		
	private GImage flipHorizontal(GImage img) {
		//Gets copy of pixel array from image
		int[][] array = img.getPixelArray();
		int height = array.length;
		int width = array[0].length;		
		
		for (int i=0; i<height; i++) {
			for (int j=0; j<width/2; j++) {
				int k = width - j - 1;
				
				int temp = array[i][j];
				array[i][j]= array[i][k];
				array[i][k]= temp;
			}
		}
		return new GImage(array);
	}
}
