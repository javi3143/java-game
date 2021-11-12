package edu.uoc.uocleaner.model;

public interface Movable {
	int SPEED = 1;
	
	void moveTo(int row, int column) throws Exception;
}
