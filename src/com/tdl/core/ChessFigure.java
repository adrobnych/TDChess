package com.tdl.core;

public class ChessFigure {
	private FigureType type;
	private FigureColor color;
	
	public ChessFigure(FigureType type, FigureColor color){
		this.type = type;
		this.color = color;
	}
	
	public void moveToNewPosition(String boardCell){
		
	}
	
	public FigureType getFigureSymbol(){
		return type;
	}
	
	public FigureColor getFigureColor(){
		return color;
	}
}
