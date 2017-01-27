package com.josecode._2048.board.util;

import com.josecode._2048.board.movement.Movement;
import com.josecode._2048.board.movement.impl.East;
import com.josecode._2048.board.movement.impl.North;
import com.josecode._2048.board.movement.impl.South;
import com.josecode._2048.board.movement.impl.West;

public class MovementStrategy {
    
	public Movement movementType(Orientation orientation) {
		switch (orientation) {
			case N:
				return new North();
			case S:
				return new South();
			case W:
				return new West();
			case E:
				return new East();
			default:
		          throw new AssertionError("Orientation doesn't exist");
		}
	}
}
