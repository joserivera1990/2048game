package com.josecode._2048.board.util;

public final class OrientationUtil {

	private OrientationUtil(){}
	
	public static Orientation getOrientation(String text) {
		switch (text.toUpperCase()) {
		case "N":
			return Orientation.N;
		case "S":
			return Orientation.S;
		case "W":
			return Orientation.W;
		case "E":
			return Orientation.E;
		default:
	          throw new AssertionError("Orientation doesn't exist");
	}
}
}
