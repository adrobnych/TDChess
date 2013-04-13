package com.tdl.console;

import com.tdl.core.Game;

public class ConsoleRunner {

	public static void main(String[] args) {
		Game game = new Game(new CIN());
		game.start();
	}

}
