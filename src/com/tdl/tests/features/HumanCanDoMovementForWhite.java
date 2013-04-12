package com.tdl.tests.features;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

import com.tdl.console.CIN;
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
		ThenHeSHouldSeeUpdatedBoard();
		//AndShouldSeeMessageThatTDCHessIsThinking();
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
	
	private void ThenHeSHouldSeeUpdatedBoard() {
			String[] boardPattern = {		
					" +---------black---------+",
					"8|RK|KN|BS|QN|KG|BS|KN|RK|",
					" |--+--+--+--+--+--+--+--|",
					"7|PW|PW|PW|PW|PW|PW|PW|PW|",
					" |--+--+--+--+--+--+--+--|",
					"6|  |  |  |  |  |  |  |  |",
					" |--+--+--+--+--+--+--+--|",
					"5|  |  |  |  |  |  |  |  |",
					" |--+--+--+--+--+--+--+--|",
					"4|  |  |  |  |  |  |  |  |",
					" |--+--+--+--+--+--+--+--|",
					"3|  |  |  |pw|  |  |  |  |",
					" |--+--+--+--+--+--+--+--|",
					"2|pw|pw|pw|  |pw|pw|pw|pw|",
					" |--+--+--+--+--+--+--+--|",
					"1|rk|kn|bs|qn|kg|bs|kn|rk|",
					" +---------white---------+",
					"  a  b  c  d  e  f  g  h"};
			
			StringBuilder expectedBoard = new StringBuilder();
			for(String line : boardPattern) 
				expectedBoard.append(line+"\n");
			
			String visibleBoard = COUT.getLastLines(8*2+3);
			
			assertThat(visibleBoard, containsString(expectedBoard.toString()));
		
		
	}
    
}
