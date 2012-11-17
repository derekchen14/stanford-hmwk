package sectionAssignments;

import acm.program.*;
import java.io.*;
import acm.util.*;

public class Histogram extends ConsoleProgram {
	
	public void run() {
	
		BufferedReader rd=openFile("File: ");
		int[] scoreArray=new int[11];	
		for (int i=0; i<11; i++) {
			scoreArray[i]=0;
		}
		
		try {
			while (true) {
				String str=rd.readLine();
				if (str == null) break;

				int score=Integer.parseInt(str);
				if (score <0 || score>100) {
					throw new ErrorException ("That score is out of range.");
				}
				int range=score/10;
				scoreArray[range]++;				
			}				
		} catch (IOException ex) {
				println("Bad File.");
				throw new ErrorException(ex);		
		}

		String[] starArray=translateToStars(scoreArray);
		printHistogram(starArray);
	}
	
	private String[] translateToStars(int[] arr1) {

		String[] arr2=new String[11];

		for (int i=0; i<11; i++) {
			arr2[i]="";
			for (int j=0; j<arr1[i]; j++) {				
				arr2[i] += "*";
			}	
		}
		return arr2;
	}
	
	private void printHistogram(String[] arr) {
		println("00-09: "+arr[0]);
		println("10-19: "+arr[1]);
		println("20-29: "+arr[2]);
		println("30-39: "+arr[3]);
		println("40-49: "+arr[4]);
		println("50-59: "+arr[5]);
		println("60-69: "+arr[6]);
		println("70-79: "+arr[7]);
		println("80-89: "+arr[8]);
		println("90-99: "+arr[9]);
		println("  "+"100: "+arr[10]);
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
