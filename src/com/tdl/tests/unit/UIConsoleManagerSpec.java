package com.tdl.tests.unit;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tdl.console.BoardUpdater;
import com.tdl.core.FiguresHolder;
import com.tdl.core.Game;
import com.tdl.ui.ConsoleMovementResolver;
import com.tdl.ui.UIConsoleManager;
import com.tdl.ui.UIManager;

@RunWith(JMock.class)
public class UIConsoleManagerSpec {
	Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
	Game game =
		context.mock(Game.class);

	@Test
	public void itShouldMockUserInput() {
		UIManager ui = new UIConsoleManager(new BoardUpdater());
		ui.setGame(game);
		
		context.checking(new Expectations() {{
			oneOf(game).userEnteredLine("d2-d3");
		}});
		
		ui.mimicUserInput("d2-d3");
	}

}
