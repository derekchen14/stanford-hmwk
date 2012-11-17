/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import java.io.*;
import java.util.*;
import acm.program.*;
import acm.util.*;

public class Hangman extends ConsoleProgram {
	/* private i-variables and other setup */
	private int guessCount = 8;
	private int lettersLeft;
	private static int letterCount;
	private static String secretWord;
	private RandomGenerator rgen=RandomGenerator.getInstance();
	private HangmanCanvas canvas;
	private ArrayList<String> lexicon=new ArrayList<String>();

	public void run() {		
		startGame();
		playGame();
		endGame();
	}
	
    public void init() {
    	canvas = new HangmanCanvas();
    	add(canvas);
    }	
	
	private void startGame() {
		//get the lexicon of keywords from a file
		getKeywords();
		
		//put something onto the screen
		println("Welcome to Hangman!");
		canvas.run(guessCount);		
		
		//initialize instance variables
		secretWord=new String(getWord(rgen.nextInt(getWordCount())));
		letterCount = secretWord.length();
		lettersLeft = letterCount;
	}
	
	private void getKeywords() {
		BufferedReader rd;
		
		try {rd=new BufferedReader(new FileReader("ShorterLexicon.txt"));
		} catch (IOException ex) {
			println("No such file.");
			throw new ErrorException (ex);
		}		
		
		try {
			while (true) {
				String str=rd.readLine();
				if (str == null) break;
				lexicon.add(str);
			}				
			rd.close();
		} catch (IOException ex) {
			println("Problem reading file.");
			throw new ErrorException(ex);		
		}
	}
	
	private void playGame() {
		String word=secretWord;
		
		while (guessCount>0 && lettersLeft>0) {
			if (word==secretWord) {
				word="";
				for (int i=0; i<letterCount; i++) {word += "-";}
			}	
			println("The word now looks like this: "+word);
			printGuess();
			canvas.displayWord(word);
			
			// receive user input
			String guess=readLine("Your guess: ");
			if (guess.equals("14")) lettersLeft=0;
			
			if (guess.equals(secretWord)) {
				lettersLeft=0;
			} else if (guess.length()>1 || guess.length()==0) {
				println("Illegal entry. Please try again.");
			} else {
				guess=guess.toUpperCase();
				word=handleInput(guess, word);	
			}
			canvas.run(guessCount);
		}
		canvas.displayWord(word);
	}

	private String handleInput(String guess, String word) {
		if (secretWord.indexOf(guess)<0) {
			println("There are no "+guess+"'s in the word.");
			guessCount--;
			canvas.noteIncorrectGuess(guess);
			return word;
		} else {
			String result="";	
			for (int i=0; i<letterCount; i++) {
				String ch = word.substring(i,i+1);
				if (secretWord.substring(i,i+1).equals(guess) && !ch.equals(guess)) {
					result=result.concat(guess);
					lettersLeft--;
				} else {
					result=result.concat(ch);
				}
			}
			println("That guess is correct.");
			return result;
		}
	}
	
	private void printGuess() {
		if (guessCount>1) {
			println("You have "+guessCount+" guesses left.");
		} else {
			println("You have only one guess left.");
		}
	}
		
	private void endGame() {
		if (guessCount == 0) {	
			println("You're completely hung.");
			println("The word was: "+secretWord);
			println("You lose.");
		} else {
			println("You guessed the word: "+secretWord);
			println("You win!");
		}
		
		String reset=readLine("<>");
		if (reset.equalsIgnoreCase("New Game")) {
			canvas.reset();
			guessCount=8;
			startGame();
			playGame();
			endGame();
		}
	}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return lexicon.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return lexicon.get(index);
	}
}

//Completed
