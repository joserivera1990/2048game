package com.josecode._2048.board;

import com.josecode._2048.board.util.Orientation;

public interface Board {

	boolean won();
	
	boolean lost();
	
	void startBoard(int x, int y);
	
	void doMovement(Orientation orientation);
	
	void printBoard();
	
    void addNewNumberToBoard();
    
    void checkIfPlayerLose();
    
    void update();
}
