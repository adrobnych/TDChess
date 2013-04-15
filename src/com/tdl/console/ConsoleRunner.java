package com.tdl.console;

import com.tdl.core.BoardUpdater;
import com.tdl.core.FiguresHolder;
import com.tdl.core.Game;
import com.tdl.ui.ConsoleMovementResolver;
import com.tdl.ui.UIConsoleManager;
import com.tdl.ui.UIManager;

public class ConsoleRunner {
	
	public static void main(String[] args) {
		UIManager ui = new UIConsoleManager(new BoardUpdater());
		Game game = new Game(ui, 
						FiguresHolder.standardOrderFactory(), 
						new ConsoleMovementResolver());
		game.start();
	}

}
