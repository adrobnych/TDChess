package com.tdl.ui;

import com.tdl.core.BoardUpdater;
import com.tdl.core.Game;

public class UIConsoleManager implements UIManager {

	private BoardUpdater boardUpdater;
	
	private Game currentGame;
	
	public UIConsoleManager(BoardUpdater boardUpdater) {
		this.boardUpdater = boardUpdater;
	}

	@Override
	public void mimicUserInput(String movement) {
		currentGame.userEnteredLine(movement);
	}

	@Override
	public void setGame(Game g) {
		this.currentGame = g;
	}

	@Override
	public void update() {
		boardUpdater.update();
	}

}
