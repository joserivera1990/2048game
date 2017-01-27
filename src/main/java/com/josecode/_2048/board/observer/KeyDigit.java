package com.josecode._2048.board.observer;

import java.util.ArrayList;

import com.josecode._2048.board.IPlay;

public class KeyDigit implements Subject {
    
	private static ArrayList<IPlay> observers = new ArrayList<>();
	
	@Override
	public void attach(IPlay play) {
		observers.add(play);
		
	}

	@Override
	public void notifyObserver(String keyword) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).update(keyword);
		}
		
	}

}
