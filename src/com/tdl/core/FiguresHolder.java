package com.tdl.core;

public class FiguresHolder {
	public ChessFigure findFigureAtFirstPosition(String boardCell){
		return new ChessFigure();
	}
	
	public static FiguresHolder standardOrderFactory(){
		return new FiguresHolder();
	}
}
