package sectionAssignments;

import acm.program.*;

public class Comma_To_String extends ConsoleProgram {
	public void run() {
		while (true) {
			String digits = readLine("Enter a number: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}	
	
	private String addCommasToNumericString (String str) {
		String result="";
		int len = str.length();
		int count = 1;
		
		for (int i=len-1; i>=0; i--) {
			result=str.charAt(i)+result;
			if ((count%3 == 0) && (i != 0)) {result=","+result;}
			count++;
		}
		return result;
	}
}




/*
//declare your variables
int x = str.length();
int y = x%3;
int count = 0;

//find out how many commas you need to put in
if (x<3) return str;
if (y == 0) y+=3;
while (x != y) {
	x-=3;
	count++;
}

for (int i=0; i<count; i++) {
	//add commas to the first part
	if (y != 0) {
		String temp=str.substring(0, y).concat(",");
		str=temp+str.substring(y);	
		y-=y;
	} else {
		String other=str.substring(0,x+i).concat(",");
		str=other+str.substring(x+i);
	}
	x+=3;
} */		

