package com.tdl.console;

public class CIN {
	private String lastInputLine = null;
	
	public void mimicUserInput(String inputLine){
		lastInputLine = inputLine;
	}
	
	public String getLastLine(){
		return lastInputLine;
	}
}
