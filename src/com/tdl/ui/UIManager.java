package com.tdl.ui;

import com.tdl.core.Game;

public interface UIManager {
	public void setGame(Game g);
	public void mimicUserInput(String movement);
	public void update();
}
