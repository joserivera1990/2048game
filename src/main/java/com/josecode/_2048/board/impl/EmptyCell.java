package com.josecode._2048.board.impl;

import com.josecode._2048.board.Cell;

public class EmptyCell implements Cell {

	public EmptyCell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int x;
	private int y;
	
	@Override
	public int getX() {
		return x;
	}
    
	@Override
	public int getY() {
		return y;
	}
    
	@Override
	public int getNumber() {
		return 0;
	}
	
	public void setNumber(int number) {
		//Not Implemented
	}
	
}
