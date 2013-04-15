package com.tdl.console;

import com.tdl.core.ChessFigure;
import com.tdl.ui.UIManager;

public class BoardUpdater {
	private UIManager ui;
	
	public void setUi(UIManager ui) {
		this.ui = ui;
	}

	public void update(){
		COUT.println(" +---------black---------+");
		for(int i=8; i>=1; i--){
			String figuresRow = ""+i+"|";
			for(char j='a'; j<='h'; j++){
				ChessFigure figure = ui.getGame().getFigures().findFigureAtPosition(""+j+i);
				if(figure != null)
					figuresRow += figure.getFigureSymbol();
				else
					figuresRow += "  ";
				figuresRow += "|";
			}	
			COUT.println(figuresRow);
			COUT.println(separatorLine(i));	
		}	
		COUT.println("  a  b  c  d  e  f  g  h");
	}
	
	private String separatorLine(int rowNumber){
		if(rowNumber == 1)
			return " +---------white---------+";
		else
			return " |--+--+--+--+--+--+--+--|";
	}
}
