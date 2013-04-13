package com.tdl.tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.runner.RunWith;
import org.jmock.lib.legacy.ClassImposteriser;

import com.tdl.console.CIN;
import com.tdl.core.BoardUpdater;
import com.tdl.core.Game;

@RunWith(JMock.class)
public class GameSpec {
	
	//interfaces - dependencies
	
	//We have rework CIN from global static scope to object
	CIN cin = new CIN();
	Game game = new Game(cin);

	//naturally Mockery works with interfaces, so need additional efforts to work with 
	//concrete files. Actually I don't see problem with one concrete instance of boardUpdater. We wont have several ones.
	Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
	BoardUpdater boardUpdater =
		context.mock(BoardUpdater.class);
	
	@Test
	public void afterStartItShouldWaitForHumanMovementAndThenUpdateBoard() {

		game.start();
		
		context.checking(new Expectations() {{
			oneOf(boardUpdater).updateAfterUserMovement("d2-d3");
		}});
		    
		cin.mimicUserInput("d2-d3");
		
	}

}
