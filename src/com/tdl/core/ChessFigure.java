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
	
	public String getFigureSymbol(){
		String lowCaseSymbol = null; 
		switch(type){
		case ROOK:
			lowCaseSymbol = "rk";
			break;
		case KNIGHT:
			lowCaseSymbol = "kn";
			break;
		case BISHOP:
			lowCaseSymbol = "bs";
			break;
		case QUEEN:
			lowCaseSymbol = "qn";
			break;
		case KING:
			lowCaseSymbol = "kg";
			break;
		case PAWN:
			lowCaseSymbol = "pw";
		}
		if(color == FigureColor.BLACK)
			return lowCaseSymbol.toUpperCase();
		else 
			return lowCaseSymbol;
	}
	
	public FigureType getFigureType(){
		return type;
	}
	
	public FigureColor getFigureColor(){
		return color;
	}
}
