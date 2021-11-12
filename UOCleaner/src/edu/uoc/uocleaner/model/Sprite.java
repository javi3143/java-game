package edu.uoc.uocleaner.model;

public abstract class Sprite{
	private int row;
	private int column;
	private Symbol symbol;
	
	protected Sprite(int row, int column, Symbol symbol) throws SpriteException {
		setRow(row);
		setColumn(column);
		setSymbol(symbol);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setRow(int row) throws SpriteException {
		if (row < 0) {
			String msg = SpriteException.ERROR_INDEX_ROW_INCORRECT;
			throw new SpriteException(msg);
		} else {
			this.row = row;
		}	
	}
	
	public void setColumn(int column) throws SpriteException {
		if (column < 0) {
			String msg = SpriteException.ERROR_INDEX_COLUMN_INCORRECT;
			throw new SpriteException(msg);
		} else {
			this.column = column;
		}	
	}
	
	public Symbol getSymbol() {
		return symbol;
	}
	
	private void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public boolean equals(Object other) {
		boolean isEqual = super.equals(other);
		boolean elseIsEqual = row == ((Sprite) other).getRow() && column == ((Sprite) other).getColumn () && symbol == ((Sprite) other).getSymbol(); 
		return isEqual || elseIsEqual;
	}
	
	@Override
	public String toString() {
		return symbol.toString();
	}
}
