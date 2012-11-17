package sectionAssignments;

import acm.program.*;

public class RemoveAll extends ConsoleProgram {
	public void run() {
		while (true) {
			String originalString = readLine("Enter a sentence: ");
			String temp = readLine("Enter a character to remove: ");
			char originalCharacter = temp.charAt(0);
			
			if (originalString.length() == 0) break;
			println("Your new sentence says: "+removeAllOccurences(originalString, originalCharacter));
		}
	}	
	
	private String removeAllOccurences (String str, char ch) {
		String result="";		
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) != ch) {
				result=result+str.charAt(i);
			}
		}
		return result;
	}
}
