package com.tdl.console;

import com.tdl.core.FiguresHolder;
import com.tdl.core.Game;
import com.tdl.ui.ConsoleMovementResolver;
import com.tdl.ui.UIConsoleManager;
import com.tdl.ui.UIManager;

public class ConsoleRunner {
	
	public static void main(String[] args) {
		BoardUpdater bu = new BoardUpdater();
		UIManager ui = new UIConsoleManager(bu);
		bu.setUi(ui);
		Game game = new Game(ui, 
						FiguresHolder.standardOrderFactory(), 
						new ConsoleMovementResolver());
		ui.setGame(game);

		game.enableRealInput();
		game.start();
	}

}
