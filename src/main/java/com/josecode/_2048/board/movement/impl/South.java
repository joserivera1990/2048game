package com.josecode._2048.board.movement.impl;

import com.josecode._2048.board.Cell;
import com.josecode._2048.board.impl.EmptyCell;
import com.josecode._2048.board.impl.OccupiedCell;
import com.josecode._2048.board.movement.Movement;

import javaslang.control.Option;

public class South implements Movement {

	@Override
	public void moveNumbers(Cell[][] grid) {
		for (int x = 0; x < grid.length; x++) {	
			for (int y = grid.length-1; y >= 0; y--) {
				if (grid[y][x] instanceof EmptyCell) {
					Option<Cell> cellNext = returnNextCellDownFillColumn(x, y, grid);
					if (cellNext.isDefined()) {
						grid[y][x] = new OccupiedCell(cellNext.get().getNumber(), x, y);
						grid[cellNext.get().getY()][cellNext.get().getX()] = new EmptyCell(cellNext.get().getX(),cellNext.get().getY());	
					}
				}
			}
		}
		
	}

	@Override
	public void joinNumbers(Cell[][] grid) {
		for (int x = 0; x < grid.length; x++) {	
			for (int y = grid.length-1; y >= 0; y--) {
				if (!(grid[y][x] instanceof EmptyCell)) {
					OccupiedCell cell = (OccupiedCell) grid[y][x];
					Option<Cell> cellNext = returnNextCellDownFillColumn(x, y, grid);
					
					if (cellNext.isDefined()) {
						if (cell.getNumber() == ((OccupiedCell) cellNext.get()).getNumber()) {
							cell.setNumber(cell.getNumber() + ((OccupiedCell)cellNext.get()).getNumber());
							grid[cellNext.get().getY()][cellNext.get().getX()] = new EmptyCell(cellNext.get().getX(),cellNext.get().getY());
							moveNumbers(grid);
						} else {
							grid[y-1][x] = new OccupiedCell(cellNext.get().getNumber(), cellNext.get().getX(), cellNext.get().getY());
						}
					} 
				} else {
					Option<Cell> cellNext = returnNextCellDownFillColumn(x, y, grid);
					if (cellNext.isDefined()) {
						grid[y][x] = new OccupiedCell(cellNext.get().getNumber(), x, y);
						grid[cellNext.get().getY()][cellNext.get().getX()] = new EmptyCell(cellNext.get().getX(),cellNext.get().getY());
					}		
				}
			}
		}
	}

	private Option<Cell> returnNextCellDownFillColumn(int x, int y, Cell[][] grid) {
		
		if (0 > y-1) {
			return Option.none();
		}
		if (!(grid[y-1][x] instanceof EmptyCell)) {
			return Option.of(grid[y-1][x]);
		}   	
		return returnNextCellDownFillColumn(x, y-1, grid);
	}

}
