package com.tdl.ui;

import com.tdl.core.Game;

public class UIConsoleManager implements UIManager {

	private Game currentGame;
	
	@Override
	public void mimicUserInput(String movement) {
		currentGame.userEnteredLine(movement);
	}

	@Override
	public void setGame(Game g) {
		this.currentGame = g;
	}

}
