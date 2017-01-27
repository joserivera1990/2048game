package com.josecode._2048.board.impl;

import com.josecode._2048.board.Cell;

public class OccupiedCell implements Cell {
	
	private int x;
	private int y;
	private int number;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public OccupiedCell(int x, int y) {
		this.number = 2;
		this.x = x;
		this.y = y;
	}
	
	public OccupiedCell(int number,int x, int y) {
		this.number = number;
		this.x = x;
		this.y = y;
	}
		
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "" + this.number;
	}
}
