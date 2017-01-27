package com.josecode._2048.board.movement.impl;

import com.josecode._2048.board.Cell;
import com.josecode._2048.board.impl.EmptyCell;
import com.josecode._2048.board.impl.OccupiedCell;
import com.josecode._2048.board.movement.Movement;

import javaslang.control.Option;

public class West implements Movement{

	@Override
	public void moveNumbers(Cell[][] grid) {
		for (int y = 0; y < grid.length; y++) {	
			for (int x = 0; x < grid.length; x++) {
				if (grid[y][x] instanceof EmptyCell) {
					Option<Cell> cellNext = returnNextCellLefttFillRow(x, y, grid);
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
		for (int y = 0; y < grid.length; y++) {	
			for (int x=0; x < grid.length; x++) {
				if (!(grid[y][x] instanceof EmptyCell)) {
					OccupiedCell cell = (OccupiedCell) grid[y][x];
					Option<Cell> cellNext = returnNextCellLefttFillRow(x, y, grid);
					
					if (cellNext.isDefined()) {
						if (cell.getNumber() == ((OccupiedCell) cellNext.get()).getNumber()) {
							cell.setNumber(cell.getNumber() + ((OccupiedCell)cellNext.get()).getNumber());
							grid[cellNext.get().getY()][cellNext.get().getX()] = new EmptyCell(cellNext.get().getX(),cellNext.get().getY());
							moveNumbers(grid);
						} else {
							grid[y][x+1] = new OccupiedCell(cellNext.get().getNumber(), cellNext.get().getX(), cellNext.get().getY());
						}
					} 
				} else {
					Option<Cell> cellNext = returnNextCellLefttFillRow(x, y, grid);
					if (cellNext.isDefined()) {
						grid[y][x] = new OccupiedCell(cellNext.get().getNumber(), x, y);
						grid[cellNext.get().getY()][cellNext.get().getX()] = new EmptyCell(cellNext.get().getX(),cellNext.get().getY());
					}		
				}
			}
		}
		
	}

	private Option<Cell> returnNextCellLefttFillRow(int x, int y, Cell[][] grid) {
		
		if (x+1 >= grid.length ) {
			return Option.none();
		}
		if (!(grid[y][x+1] instanceof EmptyCell)) {
			return Option.of(grid[y][x+1]);
		}   	
		return returnNextCellLefttFillRow(x+1, y, grid);
	}

}
