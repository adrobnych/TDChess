package com.tdl.tests.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.junit.Test;

import com.tdl.console.BoardUpdater;
import com.tdl.console.COUT;
import com.tdl.core.FiguresHolder;
import com.tdl.core.Game;
import com.tdl.ui.ConsoleMovementResolver;
import com.tdl.ui.UIConsoleManager;
import com.tdl.ui.UIManager;

public class BoardUpdaterSpec {

	BoardUpdater bu = new BoardUpdater();
	UIManager ui = new UIConsoleManager(bu);

	Game game = new Game(ui, 
					FiguresHolder.standardOrderFactory(), 
					new ConsoleMovementResolver());
	
	String[] expectedBoardPattern = {		
			" +---------black---------+",
			"8|RK|KN|BS|QN|KG|BS|KN|RK|",
			" |--+--+--+--+--+--+--+--|",
			"7|PW|PW|PW|PW|PW|PW|PW|PW|",
			" |--+--+--+--+--+--+--+--|",
			"6|  |  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"5|  |  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"4|pw|  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"3|  |  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"2|  |pw|pw|pw|pw|pw|pw|pw|",
			" |--+--+--+--+--+--+--+--|",
			"1|rk|kn|bs|qn|kg|bs|kn|rk|",
			" +---------white---------+",
			"  a  b  c  d  e  f  g  h"};
	
	@Test
	public void test() {
		
		bu.setUi(ui);
		game.start();
		COUT.reset();
		ui.mimicUserInput("a2-a4");
		
		StringBuilder expectedBoard = new StringBuilder();
		for(String line : expectedBoardPattern) 
			expectedBoard.append(line+"\n");
		
		String visibleBoard = COUT.getLastLines(8*2+3);
		
		assertThat(visibleBoard, containsString(expectedBoard.toString()));
	}

}
