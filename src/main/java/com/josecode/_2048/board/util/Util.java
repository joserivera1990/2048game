package com.josecode._2048.board.util;

public final class Util {

	private Util() {
	}
    
	public static int getRandomNumber(int maxNumber) {
		return (int) (Math.random() * maxNumber-1) + 1;
	}
	
	public static int getRandomNumber(int maxNumber, int noPosible) {
		int randomNumber = (int) (Math.random() * maxNumber - 1) + 1;
		if (randomNumber == noPosible) {
			return getRandomNumber(maxNumber,noPosible);
		} else {
			return randomNumber;
		}
	}
		
	public static int createAzulejo() {
		int random = getRandomNumber(10);
		if (random == 4) {
			return random;
		} else {
			return 2;
		}
	}
}
