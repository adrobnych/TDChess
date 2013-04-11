package com.tdl.core;

import com.tdl.console.COUT;

public class Game {
	
	private final String[] boardPattern = {		
			"+---------black---------+",
			"|RK|KN|BS|QN|KG|BS|KN|RK|",
			"|--+--+--+--+--+--+--+--|",
			"|PW|PW|PW|PW|PW|PW|PW|PW|",
			"|--+--+--+--+--+--+--+--|",
			"|  |  |  |  |  |  |  |  |",
			"|--+--+--+--+--+--+--+--|",
			"|  |  |  |  |  |  |  |  |",
			"|--+--+--+--+--+--+--+--|",
			"|  |  |  |  |  |  |  |  |",
			"|--+--+--+--+--+--+--+--|",
			"|  |  |  |  |  |  |  |  |",
			"|--+--+--+--+--+--+--+--|",
			"|pw|pw|pw|pw|pw|pw|pw|pw|",
			"|--+--+--+--+--+--+--+--|",
			"|rk|kn|bs|qn|kg|bs|kn|rk|",
			"+---------white---------+"};
	
	public void start(){
		for(String line : boardPattern)
			COUT.println(line);
		
		COUT.println("Human move (in form d2-d3):");
	}
}
