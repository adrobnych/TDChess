package com.tdl.core;

import java.util.HashMap;
import java.util.Map;

public class FiguresHolder {
	
	private Map<String, ChessFigure> figures = new HashMap<>();
	
	public ChessFigure findFigureAtFirstPosition(String boardCell){
		return figures.get(boardCell);
	}
	
	public static FiguresHolder standardOrderFactory(){
		FiguresHolder holder = new FiguresHolder();
		holder.figures.put("a8", new ChessFigure(FigureType.ROOK, FigureColor.BLACK));
		return holder;
	}
}
