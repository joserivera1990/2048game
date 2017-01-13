package com.josecode._2048.board.impl;

import com.josecode._2048.board.Board;
import com.josecode._2048.board.Cell;

public final class SimpleBoard implements Board {
	
	Cell [][] grid;
    private boolean isWinner;
    private boolean isLost;
    
	public boolean won() {
		return this.isWinner;
	}
	
	public boolean lost() {
		return this.isLost;
	}
}
