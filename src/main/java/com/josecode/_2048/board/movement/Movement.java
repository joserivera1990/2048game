package com.josecode._2048.board.movement;

import com.josecode._2048.board.Cell;

public interface Movement {

	void moveNumbers(Cell[][] grid);
    
	void joinNumbers(Cell[][] grid);
}
