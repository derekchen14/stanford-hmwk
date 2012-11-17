package sectionAssignments;

import acm.program.*;
import java.io.*;
import acm.util.*;

public class WordCount extends ConsoleProgram {
	
	public void run() {
		int lineCount=0;
		int wordCount=0;
		int charCount=0;
		BufferedReader rd=openFile("File: ");			
	
		try {
			while (true) {
				String str=rd.readLine();
				if (str == null) break;

				//do the actual math
				lineCount++;
				wordCount+=countWords(str);
				charCount+=str.length();
			}			
			rd.close();
		} catch (IOException ex) {
			println("Bad File.");
			throw new ErrorException(ex);
		}
		println("Lines: "+lineCount);
		println("Words: "+wordCount);
		println("Chars: "+charCount);						
	}	
	
	private int countWords (String line) {
		boolean inWord = false;
		int counter=0;
		
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				inWord = true;
			} else {
				if (inWord) counter++;
				inWord = false;
			}
		}
		if (inWord) counter++;
		
		return counter;
	}
	
	private BufferedReader openFile(String prompt) {
		BufferedReader rd=null;
		
		while (rd == null) {
			String filename = readLine(prompt);
			try {
				rd = new BufferedReader(new FileReader(filename));
			} catch (IOException ex) {
				println("Bad file. Try again.");
			}
		}
		return rd;
	}
}
	