/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	private static final long serialVersionUID = 1L;

	public void run() {
		//Gather input from the user
		int varStart=readInt("Enter a number: ");
		int varEnd=varStart;
		int stepCount=0;
		
		//Run Hail-stone Sequence
		while (varStart != 1) {
			if (varStart%2 == 0){
				varEnd = varEnd/2;
				println(varStart+" is even, so I take half: "+varEnd);
				varStart=varEnd;
			} else {
				varEnd = (varEnd*3)+1;
				println(varStart+" is odd, so I make 3n + 1: "+varEnd);
				varStart=varEnd;
			}
			stepCount++;		
		}

		//Count number of steps and print results
		println("The process took "+stepCount+" steps to reach 1.");		
	}
}

//Completed