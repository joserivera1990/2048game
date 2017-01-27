package com.josecode._2048.board.impl;

import com.josecode._2048.board.Board;
import com.josecode._2048.board.IPlay;
import com.josecode._2048.board.util.OrientationUtil;

public class Play implements IPlay {

	
	private Board board;
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public void update(String keyword) {
		board.doMovement(OrientationUtil.getOrientation(keyword));
	    board.addNewNumberToBoard();
	    board.printBoard();
	    board.checkIfPlayerLose();
	}

}
