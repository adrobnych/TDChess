package com.tdl.tests.unit;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tdl.console.BoardUpdater;
import com.tdl.core.ChessFigure;
import com.tdl.core.FigureColor;
import com.tdl.core.FigureType;
import com.tdl.core.FiguresHolder;
import com.tdl.core.Game;
import com.tdl.core.Movement;
import com.tdl.ui.ConsoleMovementResolver;
import com.tdl.ui.MovementResolver;
import com.tdl.ui.UIConsoleManager;
import com.tdl.ui.UIManager;

@RunWith(JMock.class)
public class GameSpec {
	
	//interfaces - dependencies
	UIManager ui;
	Game game;
	
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
		ui = new UIConsoleManager(boardUpdater);
		
		//protocols
		context.checking(new Expectations() {{
			oneOf(figures).setMovementResolver(null);   
		}});
		
		context.checking(new Expectations() {{
			oneOf(figures).moveToNewPosition("d2-d3");   
		}});
		
		context.checking(new Expectations() {{
			oneOf(boardUpdater).update();
		}});
		    
		//actionUnderTest
		game = new Game(ui, figures, null);
		game.start();
		game.userEnteredLine("d2-d3");

	}
	
	@Test
	public void afterStartItShouldWaitForHumanMovementAndThenUpdateBoard_final_state() {
		//setup
		BoardUpdater bu = new BoardUpdater();
		ui = new UIConsoleManager(bu);
		bu.setUi(ui);
		game = new Game(ui, 
						FiguresHolder.standardOrderFactory(), 
						new ConsoleMovementResolver());
		game.start();
		    
		//actionUnderTest
		ui.mimicUserInput("d2-d3");
				
		//final state of world
		assertEquals(null, game.getFigures().findFigureAtPosition("d2")); //not for further refactoring - use exception or NullObject instead
		assertEquals(ChessFigure.class, game.getFigures().findFigureAtPosition("d3").getClass());
		assertEquals(FigureType.PAWN, game.getFigures().findFigureAtPosition("d3").getFigureType());
		assertEquals(FigureColor.WHITE, game.getFigures().findFigureAtPosition("d3").getFigureColor());
	}

}
