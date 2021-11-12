package edu.uoc.uocleaner.model;

import java.util.ArrayList;

public class DustBall extends Dirt implements Movable{
	public DustBall(int row, int column) throws SpriteException {
		super(row, column, Symbol.DUSTBALL, 5);
	}
	
	public void moveTo(int row, int column) throws SpriteException {
		setRow(row);
		setColumn(column);
	}
	
	public boolean validMove(Level level, int row, int column) {
		boolean isValid;
		
		if (row < 0 || row >= level.getNumRows()) isValid=false;
		else if (column < 0 || row >= level.getNumColumns()) isValid=false;
		else if (level.getCell(row, column).getSymbol() != Symbol.DIRT && level.getCell(row, column).getSymbol() != Symbol.CORRIDOR) isValid=false;
		else isValid=true;
		return isValid;
	}
	
	public ArrayList<int[]> moveRandomly(Level level){
		ArrayList<int[]> potentials = new ArrayList<int[]>();
		ArrayList<int[]> possibles = new ArrayList<int[]>();
		// Generating potential movements 
		potentials.add(new int[]{this.getRow() - SPEED, this.getColumn()});
		potentials.add(new int[]{this.getRow() + SPEED, this.getColumn()});
		potentials.add(new int[]{this.getRow(), this.getColumn() - SPEED});
		potentials.add(new int[]{this.getRow(), this.getColumn() + SPEED});
		// Filtering valid movements
		for (int[] p: potentials) {
			if(validMove(level, p[0], p[1])) possibles.add(p);
		}
		// Making the move if both conditions are true
		if (Math.random() >= 0.75 && possibles.size() > 0) {
			int indexPicked = (int) (Math.random() * possibles.size());
			try {
				level.setCell(new Dirt(this.getRow(), this.getColumn()));
				level.setCell(possibles.get(indexPicked)[0], possibles.get(indexPicked)[1], this);
			} catch (SpriteException e) {
				e.printStackTrace();
			}
		}
		return possibles;
	}
}
