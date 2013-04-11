package com.tdl.tests.features;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdl.console.COUT;
import com.tdl.core.Game;

public class TDChessShouldPlayForBlack {

	@Test
	public void test() {
		givenWeStartedNewGame();
		thenWeShallSeeBoard();
		//andTDCHessHasArrangedBlackFiguresAlongTopEdgeOfTheBoard();
	}

	Game game = new Game();
	
	private void givenWeStartedNewGame() {
		game.start();
	}
	
	private void thenWeShallSeeBoard() {
		String[] boardPattern = {		
				"+---------black---------+",
				"|RK|KN|BS|QN|KG|BS|KN|RK|",
				"|--+--+--+--+--+--+--+--|",
				"|PW|PW|PW|PW|PW|PW|PW|PW|",
				"|--+--+--+--+--+--+--+--|",
				"|  |  |  |  |  |  |  |  |",
				"|--+--+--+--+--+--+--+--|",
				"|  |  |  |  |  |  |  |  |",
				"|--+--+--+--+--+--+--+--|",
				"|  |  |  |  |  |  |  |  |",
				"|--+--+--+--+--+--+--+--|",
				"|  |  |  |  |  |  |  |  |",
				"|--+--+--+--+--+--+--+--|",
				"|pw|pw|pw|pw|pw|pw|pw|pw|",
				"|--+--+--+--+--+--+--+--|",
				"|rk|kn|bs|qn|kg|bs|kn|rk|",
				"+---------white---------+"};
		
		StringBuilder expectedBoard = new StringBuilder();
		for(String line : boardPattern) 
			expectedBoard.append(line+"\n");
		
		String visibleBoard = COUT.getLastLines(8*2+1);
		
		assertEquals(expectedBoard.toString().trim(), visibleBoard);
	}

}
