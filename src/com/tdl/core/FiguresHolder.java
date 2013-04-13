package com.tdl.core;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class FiguresHolder {
	
	private Map<String, ChessFigure> figures = new HashMap<>();
	
	public ChessFigure findFigureAtPosition(String boardCell){
		return figures.get(boardCell);
	}
	
	public static FiguresHolder standardOrderFactory(){
		FiguresHolder holder = new FiguresHolder();
		holder.figures.put("a8", new ChessFigure(FigureType.ROOK, FigureColor.BLACK));
		holder.figures.put("b8", new ChessFigure(FigureType.KNIGHT, FigureColor.BLACK));
		holder.figures.put("c8", new ChessFigure(FigureType.BISHOP, FigureColor.BLACK));
		holder.figures.put("d8", new ChessFigure(FigureType.QUEEN, FigureColor.BLACK));
		holder.figures.put("e8", new ChessFigure(FigureType.KING, FigureColor.BLACK));
		holder.figures.put("f8", new ChessFigure(FigureType.BISHOP, FigureColor.BLACK));
		holder.figures.put("g8", new ChessFigure(FigureType.KNIGHT, FigureColor.BLACK));
		holder.figures.put("h8", new ChessFigure(FigureType.ROOK, FigureColor.BLACK));
		
		for(char col='a'; col<='h'; col++)
			holder.figures.put(col + "7", new ChessFigure(FigureType.PAWN, FigureColor.BLACK));
		
		for(char col='a'; col<='h'; col++)
			holder.figures.put(col + "2", new ChessFigure(FigureType.PAWN, FigureColor.WHITE));
		
		holder.figures.put("a1", new ChessFigure(FigureType.ROOK, FigureColor.WHITE));
		holder.figures.put("b1", new ChessFigure(FigureType.KNIGHT, FigureColor.WHITE));
		holder.figures.put("c1", new ChessFigure(FigureType.BISHOP, FigureColor.WHITE));
		holder.figures.put("d1", new ChessFigure(FigureType.QUEEN, FigureColor.WHITE));
		holder.figures.put("e1", new ChessFigure(FigureType.KING, FigureColor.WHITE));
		holder.figures.put("f1", new ChessFigure(FigureType.BISHOP, FigureColor.WHITE));
		holder.figures.put("g1", new ChessFigure(FigureType.KNIGHT, FigureColor.WHITE));
		holder.figures.put("h1", new ChessFigure(FigureType.ROOK, FigureColor.WHITE));
		
		return holder;
	}
}
