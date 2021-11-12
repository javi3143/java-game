package edu.uoc.uocleaner.model;

@SuppressWarnings("serial")
public class DumpsterException extends Exception{
	public static final String ERROR_LOAD_NEGATIVE_VALUE = "[ERROR] Load cannot be negative!!";
	
	public DumpsterException() {
		super();
	}
	
	public DumpsterException(String msg) {
		super(msg);
	}
}
