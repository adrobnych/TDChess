package com.tdl.tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.runner.RunWith;
import org.jmock.integration.junit4.*;

import com.tdl.console.CIN;
import com.tdl.core.BoardUpdater;
import com.tdl.core.Game;

@RunWith(JMock.class)
public class GameSpec {
	
	//interfaces - dependencies
	CIN cin = new CIN();
	Game game = new Game(cin);

	Mockery context = new JUnit4Mockery();
	BoardUpdater boardUpdater =
		context.mock(BoardUpdater.class);
	
	public void afterStartItShouldWaitForHumanMovementAndThenUpdateBoard() {

		game.start();
		
		context.checking(new Expectations() {{
			oneOf(boardUpdater).updateAfterUserMovement("d2-d3");
		}});
		    
		cin.mimicUserInput("d2-d3");
		
	}

}
