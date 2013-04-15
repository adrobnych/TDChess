package com.tdl.ui;

import java.util.Scanner;

import com.tdl.console.BoardUpdater;
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

	@Override
	public Game getGame() {
		return currentGame;
	}

	@Override
	public void getRealInput() {
		Scanner scan = new Scanner(System.in);
		String lineFromUser = scan.nextLine();
		currentGame.userEnteredLine(lineFromUser);
		scan.close();
	}

}
