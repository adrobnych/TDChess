package com.tdl.core;

public class Movement {
	private String firstPosition;
	private String secondPosition;
	
	public Movement(String firstPosition, String secondPosition) {
		this.firstPosition = firstPosition;
		this.secondPosition = secondPosition;
	}
	public String getFirstPosition() {
		return firstPosition;
	}
	public void setFirstPosition(String firstPosition) {
		this.firstPosition = firstPosition;
	}
	public String getSecondPosition() {
		return secondPosition;
	}
	public void setSecondPosition(String secondPosition) {
		this.secondPosition = secondPosition;
	}

}
