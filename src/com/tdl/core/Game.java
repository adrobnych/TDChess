package com.tdl.core;

import com.tdl.console.COUT;
import com.tdl.ui.MovementResolver;
import com.tdl.ui.UIManager;

public class Game {
	
	private final UIManager uiManager; 
	private FiguresHolder figures;
	
	public Game(UIManager ui, FiguresHolder figures, MovementResolver mr){
		this.uiManager = ui;
		uiManager.setGame(this);
		this.figures = figures;
		this.figures.setMovementResolver(mr);
	}
	
	public void start(){
		uiManager.update();
		
		COUT.println("Human move (in form d2-d3):");  
	}
	
	public FiguresHolder getFigures(){
		return figures;
	}
	
	public void userEnteredLine(String lineFromUser){
		figures.moveToNewPosition(lineFromUser);
		uiManager.update();
	}
}
