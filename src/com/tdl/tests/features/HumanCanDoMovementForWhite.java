package com.tdl.tests.features;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tdl.console.COUT;
import com.tdl.core.Game;

public class HumanCanDoMovementForWhite {

	@Test
	public void importantNoteBeforeSecondFuncTest() {
		System.out.println(
				"There was a question is it good time to start unit test exploration " +
				"of classes after walking skeleton stage.\n" +
				"I think we have to do a little more work on functionality level " +
				"becouse classes had not enough explored after first functional test.\n" +
				"So. We'll start another functional test loop. And then we'll look " +
				"again if it's good time start unit test level."
		);
	}
	
	@Test
	public void test(){
		GivenGameWasStarted();
		AndUserSeeInvitationLine();
		WhenUserEnterMovementOfPawn();
		//ThenHeShouldSeeCorrectMovementOfSomeBlackFigure();
	}

	Game game = new Game();
	
	private void GivenGameWasStarted() {
		game.start();
	}
	
	private void AndUserSeeInvitationLine() {
		assertEquals("Human move (in form d2-d3):", COUT.getLastLine().trim());
	}
	
	private void WhenUserEnterMovementOfPawn() {
		CIN.mimicUserInput("d2-d3");
	}
    
}
