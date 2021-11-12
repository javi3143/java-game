package edu.uoc.uocleaner.model;

@SuppressWarnings("serial")
public class SpriteException extends Exception{
	public static final String ERROR_INDEX_ROW_INCORRECT= "[ERROR] The index of row cannot be negative!!";
	public static final String ERROR_INDEX_COLUMN_INCORRECT = "[ERROR] The index of column cannot be negative!!";
	
	public SpriteException() {
		super();
	}
	
	public SpriteException(String msg) {
		super(msg);
	}
}
