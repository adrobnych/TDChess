package com.tdl.ui;

import com.tdl.core.Movement;

public interface MovementResolver {
	public Movement parse(String movement);
}
