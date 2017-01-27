package com.josecode._2048.board.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.josecode._2048.board.Board;
import com.josecode._2048.board.Cell;
import com.josecode._2048.board.movement.Movement;
import com.josecode._2048.board.util.MovementStrategy;
import com.josecode._2048.board.util.Orientation;
import com.josecode._2048.board.util.Util;

public final class SimpleBoard implements Board {
	
	Cell [][] grid;
    private boolean isWinner;
    private boolean isLost;
    
    @Override
	public boolean won() {
		return this.isWinner;
	}
	
    @Override
	public boolean lost() {
		return this.isLost;
	}
    
    @Override
	public void startBoard(int x, int y) {
		this.grid = new Cell[y][x];
		//buildFirstsOccupiedCell();
		this.grid[3][1] = new OccupiedCell(1,3);
		this.grid[3][2] = new OccupiedCell(4,2,3);
		this.grid[2][3] = new OccupiedCell(4,3,2);
		this.grid[0][3] = new OccupiedCell(4,3,0);
		this.grid[0][2] = new OccupiedCell(4,2,0);
		this.grid[2][0] = new OccupiedCell(4,0,2);
		this.grid[2][1] = new OccupiedCell(4,1,2);
		this.grid[2][2] = new OccupiedCell(4,2,2);
		fillBoard();
	}
    
    private void buildFirstsOccupiedCell() {
    	int numberX = Util.getRandomNumber(3);
    	int numberY = Util.getRandomNumber(3);
    	this.grid[numberY][numberX] = new OccupiedCell(Util.createAzulejo(), numberX, numberY);
    	int numberXtwo = Util.getRandomNumber(3, numberX);
    	int numberYtwo = Util.getRandomNumber(3, numberY);
    	this.grid[numberYtwo][numberXtwo] = new OccupiedCell(Util.createAzulejo(), numberXtwo, numberYtwo);
    }
    
    private void fillBoard() { 	 	
    	for (int i = 0; i < this.grid.length; i++) {	
			for (int j = 0; j < this.grid.length; j++) {
				if (grid[i][j] == null) {
					grid[i][j] = new EmptyCell(j,i);
				}
			}
		}
    }
     
	@Override
	public void doMovement(Orientation orientation) {
		MovementStrategy strategy = new MovementStrategy();
		Movement movement = strategy.movementType(orientation);
		movement.moveNumbers(grid);
		movement.joinNumbers(grid);      
	}
    
	@Override
	public void update() {
		System.out.println("ddd");
	}
	
	
	@Override
	public void checkIfPlayerLose() {		
		Optional<Cell> foundEmpty = Arrays.stream(grid).map(array -> Arrays.stream(array))
				 						  .flatMap(cell -> cell)
				 						  .filter(cellFilter -> cellFilter  instanceof EmptyCell)
				 						  .findFirst(); 
		 if (!foundEmpty.isPresent()) {
			 this.isLost = true;
		 } 	 
	}
	
	public void addNewNumberToBoard() {
		List<Cell> listCells = findCellsEmpty();
		int x = Util.getRandomNumber(listCells.size()-1);
        this.grid[listCells.get(x).getY()][listCells.get(x).getX()] = new OccupiedCell(2, listCells.get(x).getX(), listCells.get(x).getY()); 	
	}
	
	private List<Cell> findCellsEmpty() {
		return  Arrays.stream(grid).map(arrayCells -> findCellsByArray(arrayCells))
								   .flatMap(List::stream)
								   .collect(Collectors.toList());
	}
	
	private static List<Cell> findCellsByArray(Cell[] cell) {
		return Arrays.stream(cell).filter(n -> n instanceof EmptyCell)
								  .collect(Collectors.toList());
	}
		 
    @Override
    public void printBoard() {
    	System.out.println("*****************************");
		for (int i = 0; i < this.grid.length; i++) {	
			for (int j = 0; j < this.grid.length; j++) {
				if (grid[i][j] instanceof EmptyCell) {
					System.out.print("| "+ "  |  ");
				} else {
					System.out.print(" |" +((OccupiedCell) grid[i][j]).getNumber()+" |  ");
				}
			}
			System.out.println("\n");
		}
		System.out.println("*****************************");	
    }
              
}
