package com.tdl.tests.features;

import static org.junit.Assert.*;

import org.junit.Test;

public class TDChessShouldPlayForBlack {

	@Test
	public void test() {
		givenWeStartedNewGame();
		//thenWeShallSeeBoard();
		//andTDCHessHasArrangedBlackFiguresAlongTopEdgeOfTheBoard();
	}

	Game game = new Game();
	
	private void givenWeStartedNewGame() {
		game.start();
	}
	
	

}
