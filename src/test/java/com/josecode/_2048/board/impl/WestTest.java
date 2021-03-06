package com.josecode._2048.board.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.josecode._2048.board.Cell;
import com.josecode._2048.board.movement.impl.West;

public class WestTest {

	West west = new West();
	SimpleBoard simple = new SimpleBoard();
	
	@Test
	public void moveNumbersNorth() {
		Cell[][] cells = buildCell(); 
		west.moveNumbers(cells);
		assertEquals(4, cells[0][0].getNumber());
		assertEquals(2, cells[3][0].getNumber());
	}
	
	@Test
	public void joinNumbersNorth() {
		Cell[][] cells = buildCell(); 
		west.moveNumbers(cells);
		west.joinNumbers(cells);
		assertEquals(8, cells[0][0].getNumber());
		assertEquals(8, cells[2][0].getNumber());
	}
	
	private Cell[][] buildCell() {
		Cell [][] grid = new Cell[4][4];
		grid[3][1] = new OccupiedCell(1,3);
		grid[3][2] = new OccupiedCell(4,2,3);
		grid[2][3] = new OccupiedCell(4,3,2);
		grid[0][3] = new OccupiedCell(4,3,0);
		grid[0][2] = new OccupiedCell(4,2,0);
		grid[2][0] = new OccupiedCell(4,0,2);
		grid[2][1] = new OccupiedCell(4,1,2);
		grid[2][2] = new OccupiedCell(4,2,2);
        fillBoard(grid);		
		return grid; 
	}
	
    private void fillBoard(Cell [][] grid) { 	
		for (int i = 0; i < grid.length; i++) {	
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == null) {
					grid[i][j] = new EmptyCell(j,i);
				}
			}
		}
    }

}
