package com.tdl.tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameSpec {
	
	@Test
	public void itShouldWaitForHumanMovementAndThenUpdateBoard() {
		//first TDD smell we can see is that we designed CIN with global visibility.
		//this makes task of unit testing hard and we see the first point
		//for immediate refactoring.
		
		//Another smell which we see immediately is that Game has at least 2
		//responsibilities: process human movement *AND* update board.
	}

}
