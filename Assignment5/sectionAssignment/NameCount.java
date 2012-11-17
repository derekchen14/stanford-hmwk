package sectionAssignment;

import acm.program.*;
import java.util.*;

public class NameCount extends ConsoleProgram {
	public void run() {
		ArrayList<String> nameStore=new ArrayList<String>();
		
		while (true) {
			String name=readLine("Enter name:");
			if (name == "") break;
			nameStore.add(name);
			
			//implement a hashmap
		}
		printNames(nameStore);
	}
	
	private void printNames(ArrayList arr) {
		for (int i=0; i<arr.size(); i++) {	
			int x=3;
			println("Entry "+arr.get(i)+" has count "+x);
		}
	}	
}
