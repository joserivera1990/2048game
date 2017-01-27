package com.josecode._2048.board.util;

public enum Orientation {
	N,S,W,E;
	
	public static Orientation getEnum(String id) {
		return Enum.valueOf(Orientation.class, id);
	}
  
}
