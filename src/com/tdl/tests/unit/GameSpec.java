package com.tdl.tests.unit;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tdl.core.BoardUpdater;
import com.tdl.core.ChessFigure;
import com.tdl.core.FigureColor;
import com.tdl.core.FigureType;
import com.tdl.core.FiguresHolder;
import com.tdl.core.Game;
import com.tdl.ui.UIConsoleManager;
import com.tdl.ui.UIManager;

@RunWith(JMock.class)
public class GameSpec {
	
	//interfaces - dependencies
	
	//cin is unstable dependency to console ui. Lets depend on abstraction 
	UIManager ui = new UIConsoleManager();
	Game game = new Game(ui, FiguresHolder.standardOrderFactory());

	//naturally Mockery works with interfaces, so need additional efforts to work with 
	//concrete files. Actually I don't see problem with one concrete instance of boardUpdater. We wont have several ones.
	Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
	BoardUpdater boardUpdater =
		context.mock(BoardUpdater.class);
	FiguresHolder figures =
		context.mock(FiguresHolder.class);
	ChessFigure figure = 
		context.mock(ChessFigure.class);
	
	@Test
	public void afterStartItShouldWaitForHumanMovementAndThenUpdateBoard_protocols() {
		//setup
		game.start();
		
		//protocols
		context.checking(new Expectations() {{
			oneOf(figures).findFigureAtPosition("d2");   
		}});
		
		context.checking(new Expectations() {{
			oneOf(figures).moveToNewPosition("d2-d3");   
		}});
		
		context.checking(new Expectations() {{
			oneOf(boardUpdater).update();
		}});
		    
		//actionUnderTest
		game.userEnteredLine("d2-d3");

	}
	
	@Test
	public void afterStartItShouldWaitForHumanMovementAndThenUpdateBoard_final_state() {
		//setup
		game.start();
		    
		//actionUnderTest
		ui.mimicUserInput("d2-d3");
				
		//final state of world
		assertEquals(null, game.getFigures().findFigureAtPosition("d2")); //not for further refactoring - use exception or NullObject instead
		assertEquals(ChessFigure.class, game.getFigures().findFigureAtPosition("d3").getClass());
		assertEquals(FigureType.PAWN, game.getFigures().findFigureAtPosition("d3").getFigureSymbol());
		assertEquals(FigureColor.WHITE, game.getFigures().findFigureAtPosition("d3").getFigureColor());
	}

}
