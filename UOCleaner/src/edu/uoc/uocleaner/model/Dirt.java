package edu.uoc.uocleaner.model;

public class Dirt extends Sprite{
	int score;
	
	public Dirt(int row, int column) throws SpriteException {
		this(row, column, Symbol.DIRT, 1);
	}
	
	protected Dirt(int row, int column, Symbol symbol, int score) throws SpriteException {
		super(row, column, symbol);
		setScore(score);
		
	}
	
	public int getScore() {
		return score;
	}
	
	protected void setScore(int score) {
		this.score = score;
	}
}
