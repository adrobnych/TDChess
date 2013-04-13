package com.tdl.tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdl.core.ChessFigure;
import com.tdl.core.FigureType;
import com.tdl.core.FiguresHolder;

public class FiguresHolderSpec {

	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForBlackRook() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtFirstPosition("a8");
		assertEquals(FigureType.ROOK, foundFigure.getFigureSymbol());
	}

}
