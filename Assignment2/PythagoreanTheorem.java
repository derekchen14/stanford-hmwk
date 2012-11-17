/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {

	private static final long serialVersionUID = 1L;

	public void run() {
		println("Enter values to compute Pythagorean theorem.");
		
		//get A and B values
		int a = readInt("a: ");
		int b = readInt("b: ");
		
		//calculate C value
		double hypotenuse = (double) Math.sqrt((a*a)+(b*b));	
		
		//print out the answer
		println("c = "+hypotenuse);
	}
}

//Completed