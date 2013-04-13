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
	Game game = new Game(ui);

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
	public void afterStartItShouldWaitForHumanMovementAndThenUpdateBoard() {
		//setup
		game.start();
		
		//protocols
		context.checking(new Expectations() {{
			oneOf(figures).findFigureAtFirstPosition("d2");   
		}});
		
		context.checking(new Expectations() {{
			oneOf(figure).moveToNewPosition("d3");   
		}});
		
		context.checking(new Expectations() {{
			//lets spec this more simple
			oneOf(boardUpdater).update();
		}});
		    
		//actionUnderTest
		ui.mimicUserInput("d2-d3");
				
		//final state of world
		assertEquals(null, game.getFigures().findFigureAtFirstPosition("d2")); //not for further refactoring - use exception or NullObject instead
		assertEquals(ChessFigure.class, game.getFigures().findFigureAtFirstPosition("d3").getClass());
		assertEquals(FigureType.PAWN, game.getFigures().findFigureAtFirstPosition("d3").getFigureSymbol());
		assertEquals(FigureColor.WHITE, game.getFigures().findFigureAtFirstPosition("d3").getFigureColor());

		//note how quickly we can change spec of code - much faster then code itself.
	    //This is one of parts of TD "miricle". 
	
	    //and there is no scare to fail. because we have tests as a safety belt
	}

}
