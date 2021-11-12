package edu.uoc.uocleaner.model;

@SuppressWarnings("serial")
public class LevelException extends Exception{
	public static final String ERROR_NUM_ROWS_INCORRECT = "[ERROR] The number of rows cannot be 0 or smaller!!";
	public static final String ERROR_NUM_COLUMNS_INCORRECT = "[ERROR] The number of columns cannot be 0 or smaller!!";
	public static final String ERROR_NUM_TURNS_INCORRECT = "[ERROR] The turns cannot be negative!!";
	public static final String ERROR_NUM_TIME_INCORRECT = "[ERROR] The time cannot be negative!!";
	public static final String ERROR_NUM_VACUUMS = "[ERROR] There must only be one vacuum cleaner!!";
	public static final String ERROR_NO_DUMPSTERS = "[ERROR] There must be one dumpster at least!!";
	public static final String ERROR_NO_DIRT = "[ERROR] There must be one dirt at least!!";
	
	public LevelException() {
		super();
	}
	
	public LevelException(String msg) {
		super(msg);
	}
}
