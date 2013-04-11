package com.tdl.tests.features;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdl.console.COUT;
import com.tdl.core.Game;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TDChessShouldPlayForBlack {

	@Test
	public void test() {
		givenWeStartedNewGame();
		thenWeShallSeeBoard();
		andTDCHessAsksForHumanMove();
	}

	Game game = new Game();
	
	private void givenWeStartedNewGame() {
		game.start();
	}
	
	private void thenWeShallSeeBoard() {
		String[] boardPattern = {		
				" +---------black---------+",
				"8|RK|KN|BS|QN|KG|BS|KN|RK|",
				" |--+--+--+--+--+--+--+--|",
				"7|PW|PW|PW|PW|PW|PW|PW|PW|",
				" |--+--+--+--+--+--+--+--|",
				"6|  |  |  |  |  |  |  |  |",
				" |--+--+--+--+--+--+--+--|",
				"5|  |  |  |  |  |  |  |  |",
				" |--+--+--+--+--+--+--+--|",
				"4|  |  |  |  |  |  |  |  |",
				" |--+--+--+--+--+--+--+--|",
				"3|  |  |  |  |  |  |  |  |",
				" |--+--+--+--+--+--+--+--|",
				"2|pw|pw|pw|pw|pw|pw|pw|pw|",
				" |--+--+--+--+--+--+--+--|",
				"1|rk|kn|bs|qn|kg|bs|kn|rk|",
				" +---------white---------+",
				"  a  b  c  d  e  f  g  h"};
		
		StringBuilder expectedBoard = new StringBuilder();
		for(String line : boardPattern) 
			expectedBoard.append(line+"\n");
		
		String visibleBoard = COUT.getLastLines(8*2+3);
		
		assertThat(visibleBoard, containsString(expectedBoard.toString()));
	}
	
	private void andTDCHessAsksForHumanMove() {
		assertEquals("Human move (in form d2-d3):", COUT.getLastLine().trim());
	}

}
