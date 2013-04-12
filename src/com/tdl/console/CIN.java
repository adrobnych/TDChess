package com.tdl.console;

public class CIN {
	private static String lastInputLine = null;
	
	public static void mimicUserInput(String inputLine){
		lastInputLine = inputLine;
	}
	
	public static String getLastLine(){
		return lastInputLine;
	}
}
