/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import acm.program.*;

public class HangmanLexicon extends ConsoleProgram {

	/* private i-variables and other setup */
	private int guessCount = 8;
	private int lettersLeft;
	private static int letterCount;
	private static String secretWord;
	private RandomGenerator rgen=RandomGenerator.getInstance();
	
	public void run() {		
		startGame();
		playGame();
		endGame();
	}
	
	private void startGame() {
		println("Welcome to Hangman!");
		secretWord=new String(getWord(rgen.nextInt(10)));
		letterCount = secretWord.length();
		lettersLeft = letterCount;
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
			
			// receive user input
			String guess=readLine("Your guess: ");
			if (guess.equals("14")) lettersLeft=0;
			
			if(guess.length()>1 || guess.length()==0) {
				println("Illegal entry. Please try again.");
			} else {
				guess=guess.toUpperCase();
				word=handleInput(guess, word);	
			}
		}
	}

	private String handleInput(String guess, String word) {
		if (secretWord.indexOf(guess)<0) {
			println("There are no "+guess+"'s in the word.");
			guessCount--;
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
	}
	
/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	}
}