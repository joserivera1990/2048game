package com.josecode._2048;

import java.util.Scanner;

import com.josecode._2048.board.Board;
import com.josecode._2048.board.IPlay;
import com.josecode._2048.board.impl.Play;
import com.josecode._2048.board.impl.SimpleBoard;
import com.josecode._2048.board.observer.KeyDigit;

public class Main {
	
	private static KeyDigit key = new KeyDigit();
	
    public static void main( String[] args ) {   
	    IPlay play = new Play();
    	Board board = new SimpleBoard();
	    board.startBoard(4, 4);
	    board.printBoard();
	    play.setBoard(board);
	    key.attach(play);
    	Scanner entradaEscaner = new Scanner(System.in); 
    	askNumber(board, entradaEscaner);
    }
    
	private static void askNumber(Board board, Scanner entradaEscaner) {
		System.out.println ("Please introduce a of the next keyboard: N,W,E,S  -> North,West,East,South");
	    String entradaX = entradaEscaner.nextLine();
	    KeyDigit key = new KeyDigit();
	    key.notifyObserver(entradaX);
	    if (!board.lost()) {
	    	askNumber(board, entradaEscaner);
	    } else {
	    	 System.out.println("GAME OVER");
	    }
	 }
}
