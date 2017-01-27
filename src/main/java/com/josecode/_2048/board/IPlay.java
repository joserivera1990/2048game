package com.josecode._2048.board;

public interface IPlay {

	void update(String keyword);
    
	Board getBoard();

	void setBoard(Board board);
}
