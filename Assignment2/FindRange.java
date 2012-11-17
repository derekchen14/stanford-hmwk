/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final long serialVersionUID = 1L;

	private int sentinel=0;
	
	public void run(){
		//start the class with a welcome message
		println("This program finds the largest and smallest numbers.");

		//store the first number, plus the 'small' and the 'large' variables
		int storage1=readInt("? ");
		int small=storage1;
		int large=storage1;
		
		//throw an exception if no numbers are entered
		if (storage1 == sentinel) {
			println("No values have been entered, please try again.");
		} else {

			//collect user input
			while(storage1 != sentinel) {			
				int storage2=readInt("? ");
					
				//end the loop when we sense a sentinel
				if (storage2 == sentinel) {
					storage1=storage2;
				} else if (storage2>large){
					large=storage2;
				} else if (storage2<small) {
					small=storage2;
				}
			}

			println("smallest: "+small);
			println("largest: "+large);
		}
	}	
}
// Completed




/*
//create conditional
int sentinel;
private boolean isNotSentinel(){
	return (sentinel != 0); 
}

IntegerArray numberList=new IntegerArray ();

//allow users to input numbers					xxx
while (isNotSentinel()) {
	numberList = readIntArray("? ");
}

println(numberList);

//find the smallest and largest numbers			xxx
int small = numberList.minArray(sentinel);
int large = numberList.maxArray(sentinel);

//set exception when there is only one number 	xxx
//set exception when there are no inputs		xxx

println("smallest: "+small);
println("largest: "+large);		
*/

