package com.tdl.tests.unit;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tdl.core.ChessFigure;
import com.tdl.core.FigureColor;
import com.tdl.core.FigureType;
import com.tdl.core.FiguresHolder;
import com.tdl.core.Movement;
import com.tdl.ui.ConsoleMovementResolver;
import com.tdl.ui.MovementResolver;

@RunWith(JMock.class)
public class FiguresHolderSpec {
	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForBlackRook() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtPosition("a8");
		assertEquals(FigureType.ROOK, foundFigure.getFigureType());
		assertEquals(FigureColor.BLACK, foundFigure.getFigureColor());
	}
	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForWhitePawnAtH2() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtPosition("h2");
		assertEquals(FigureType.PAWN, foundFigure.getFigureType());
		assertEquals(FigureColor.WHITE, foundFigure.getFigureColor());
	}
	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForBlackPawnAtG7() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtPosition("g7");
		assertEquals(FigureType.PAWN, foundFigure.getFigureType());
		assertEquals(FigureColor.BLACK, foundFigure.getFigureColor());
	}
	
	@Test
	public void itCanGenerateDefauldOrderOfFigures_checkForWhiteKingAtE1() {
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		ChessFigure foundFigure = figures.findFigureAtPosition("e1");
		assertEquals(FigureType.KING, foundFigure.getFigureType());
		assertEquals(FigureColor.WHITE, foundFigure.getFigureColor());
	}
	
	
	Mockery context = new Mockery();
    
	MovementResolver mockMoveResolver =
		context.mock(MovementResolver.class);
	
	@Test
	public void itDelegatesMovementParsingToMovementResolver(){
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		figures.setMovementResolver(mockMoveResolver);
		
		context.checking(new Expectations() {{
			oneOf(mockMoveResolver).parse("a2-a3");   
		}});
		
		figures.moveToNewPosition("a2-a3");
	}
	
	@Test
	public void itCanMoveFigure(){
		FiguresHolder figures = FiguresHolder.standardOrderFactory();
		MovementResolver moveResolver = new ConsoleMovementResolver();
		figures.setMovementResolver(moveResolver);
		
		figures.moveToNewPosition("a2-a3");
		assertEquals(null, figures.findFigureAtPosition("a2"));
		ChessFigure foundFigure = figures.findFigureAtPosition("a3");
		assertEquals(FigureType.PAWN, foundFigure.getFigureType());
	}
	
}
