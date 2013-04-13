package com.tdl.core;

import com.tdl.console.COUT;
import com.tdl.ui.UIManager;

public class Game {
	
	private final UIManager uiManager; 
	private FiguresHolder figures;
	
	public Game(UIManager ui, FiguresHolder figures){
		this.uiManager = ui;
		uiManager.setGame(this);
		this.figures = figures;
	}
	
	private final String[] boardPattern = {		
			" +---------black---------+",
			"8|RK|KN|BS|QN|KG|BS|KN|RK|",
			" |--+--+--+--+--+--+--+--|",
			"7|PW|PW|PW|PW|PW|PW|PW|PW|",
			" |--+--+--+--+--+--+--+--|",
			"6|  |  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"5|  |  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"4|  |  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"3|  |  |  |  |  |  |  |  |",
			" |--+--+--+--+--+--+--+--|",
			"2|pw|pw|pw|pw|pw|pw|pw|pw|",
			" |--+--+--+--+--+--+--+--|",
			"1|rk|kn|bs|qn|kg|bs|kn|rk|",
			" +---------white---------+",
			"  a  b  c  d  e  f  g  h"};
	
	public void start(){
		for(String line : boardPattern)
			COUT.println(line);
		
		COUT.println("Human move (in form d2-d3):");  
	}
	
	public FiguresHolder getFigures(){
		return figures;
	}
	
	public void userEnteredLine(String lineFromUser){
		
	}
}
