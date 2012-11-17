package sectionAssignments;

import acm.program.*;
import java.util.*;

public class UniqueName extends ConsoleProgram {
	
	public void run() {		
		ArrayList<String> nameArray=new ArrayList<String>();

		while(true) {
			String str = readLine("Enter name: ");
			if(str.equals("")) break;	
			if (!nameArray.contains(str)) nameArray.add(str);
		}	
		printNames(nameArray);
	}

	private void printNames(ArrayList arr) {
		println("Unique name list contains: ");

		for (int i=0; i<arr.size(); i++) {	
			println(arr.get(i));
		}
	}
}

