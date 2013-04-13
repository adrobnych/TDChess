package com.tdl.tests.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tdl.core.ChessFigure;
import com.tdl.core.FigureColor;
import com.tdl.core.FigureType;
import com.tdl.core.FiguresHolder;

public class FiguresHolderSpec {

	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForBlackRook() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtFirstPosition("a8");
		assertEquals(FigureType.ROOK, foundFigure.getFigureSymbol());
		assertEquals(FigureColor.BLACK, foundFigure.getFigureColor());
	}
	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForWhitePawnAtH2() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtFirstPosition("h2");
		assertEquals(FigureType.PAWN, foundFigure.getFigureSymbol());
		assertEquals(FigureColor.WHITE, foundFigure.getFigureColor());
	}
	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForBlackPawnAtG7() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtFirstPosition("g7");
		assertEquals(FigureType.PAWN, foundFigure.getFigureSymbol());
		assertEquals(FigureColor.BLACK, foundFigure.getFigureColor());
	}
	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForWhiteKingAtE1() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtFirstPosition("e1");
		assertEquals(FigureType.KING, foundFigure.getFigureSymbol());
		assertEquals(FigureColor.WHITE, foundFigure.getFigureColor());
	}

}
