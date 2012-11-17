package sectionAssignments;

import acm.program.*;

public class Fibonnaci extends ConsoleProgram {
	private static final long serialVersionUID = 1L;

	private static final int MAX_TERM_VALUE = 10000;
		
	public void run (){
		println("This program lists the Fibonnaci sequence.");
		
		int termA = 0;
		int termB = 1;
		
		println(termA);
		println(termB);
		
		while (true) {
			int termC;
			termC = termA + termB;

			if (termC > MAX_TERM_VALUE) break;
			
			println(termC);
			termA=termB;
			termB=termC;
		}
	}
}

//Completed
