package com.tdl.ui;

import com.tdl.core.Movement;

public class ConsoleMovementResolver implements MovementResolver {

	@Override
	public Movement parse(String movement) {
		String[] parts = movement.split("-");
		String part1 = parts[0];
		String part2 = parts[1];
		Movement m = new Movement(part1, part2);
		return m;
	}

}
