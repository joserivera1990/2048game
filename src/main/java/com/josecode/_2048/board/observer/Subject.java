package com.josecode._2048.board.observer;

import com.josecode._2048.board.IPlay;

public interface Subject {

	void attach(IPlay play);
		
	void notifyObserver(String keyword);
}
