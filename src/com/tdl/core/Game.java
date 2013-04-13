package com.tdl.core;

import com.tdl.console.CIN;
import com.tdl.console.COUT;
import com.tdl.ui.UIManager;

public class Game {
	
	private final UIManager uiManager; 
	
	public Game(UIManager ui){
		this.uiManager = ui;
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
}
