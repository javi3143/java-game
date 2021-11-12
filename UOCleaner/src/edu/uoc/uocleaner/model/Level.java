package edu.uoc.uocleaner.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
 * Level/Room class. 
 * @author David García Solórzano
 * @version 1.0 
 */
public class Level{
	/**
	 * Number of rows of the board.
	 */
	private int numRows;
	/**
	 * Number of columns of the board.
	 */
	private int numColumns;
	/**
	 * Representation of the 2D board.
	 */
	private Sprite[][] board;
	/**
	 * Name of the background image for the GUI app.
	 */
	private String imageBackground;
	/**
	 * Number of turns which the player has in order to beat the level.
	 */
	private int turns;	
	/**
	 * Maximum time which the player has in order to beat the level.
	 */
	private int time;
		
	/**
	 * Constructor 
	 * @param fileName Name of the configuration file which has all the information of the level.
	 * @throws FileNotFoundException When it is impossible to open the configuration file.
	 * @throws LevelException When the number of rows or columns are zero or negative; 
	 * when the number of turns or time is negative; when there is not only one vacuum cleaner; when there are not dumpsters; 
	 * when there are not dirts or dustballs.
	 * @throws VacuumException When the value for the vacuum cleaner's capacity is zero or negative.
	 * @throws SpriteException When the index of either the row or the column is incorrect.
	 */
	public Level(String fileName) throws FileNotFoundException, LevelException, VacuumException, SpriteException {
		char[] line = null;
		boolean isDumpster = false, isDirt = false;
		int numVacuums = 0;		
		
		Scanner sc = new Scanner(new File(fileName));

		// find the number of rows and columns       
        setNumRows(Integer.parseInt(sc.nextLine()));
        setNumColumns(Integer.parseInt(sc.nextLine()));
        setImageBackground(sc.nextLine());
        setTurns(Integer.parseInt(sc.nextLine()));
        setTime(Integer.parseInt(sc.nextLine()));
        
        board = new Sprite[numRows][numColumns];           
        for (int row = 0; row < numRows; row++) {
        	line = sc.nextLine().toCharArray();        	
			for (int column = 0; column < numColumns; column++) {				
				board[row][column] = SpriteFactory.getSprite(row,column,Symbol.getName(line[column]));				
				if(board[row][column] instanceof Dirt) isDirt = true;
				if(board[row][column] instanceof Vacuum) numVacuums++;
				if(board[row][column] instanceof Dumpster) isDumpster = true;								
			}			
        }        
        
        sc.close();       
                
        if(numVacuums!=1) {
        	throw new LevelException(LevelException.ERROR_NUM_VACUUMS);
        }
        
        if(!isDumpster) {
        	throw new LevelException(LevelException.ERROR_NO_DUMPSTERS);
        }
        
        if(!isDirt) {
        	throw new LevelException(LevelException.ERROR_NO_DIRT);
        }        
	}	
	
	public int getNumRows() {
		return numRows;
	}
	
	public int getNumColumns() {
		return numColumns;
	}
	
	public String getImageBackground() {
		return imageBackground;
	}
	
	public int getTurns() {
		return turns;
	}
	
	public int getTime() {
		return time;
	}
	
	private void setNumRows(int numRows) throws LevelException {
		if (numRows <= 0) {
			String msg = LevelException.ERROR_NUM_ROWS_INCORRECT;
			throw new LevelException(msg);
		} else {
			this.numRows = numRows;
		}
	}
	
	private void setNumColumns(int numColumns) throws LevelException {
		if (numColumns <= 0) {
			String msg = LevelException.ERROR_NUM_COLUMNS_INCORRECT;
			throw new LevelException(msg);
		} else {
			this.numColumns = numColumns;
		}
	}
	
	private void setTime(int time) throws LevelException {
		if (time < 0) {
			String msg = LevelException.ERROR_NUM_TIME_INCORRECT;
			throw new LevelException(msg);
		} else {
			this.time = time;
		}
	}
	
	private void setTurns(int turns) throws LevelException {
		if (turns < 0) {
			String msg = LevelException.ERROR_NUM_TURNS_INCORRECT;
			throw new LevelException(msg);
		} else {
			this.turns = turns;
		}
	}
	
	private void setImageBackground(String imageBackground) {
		this.imageBackground = imageBackground;
	}
	
	public void decTurns() throws LevelException {
		setTurns(getTurns() - 1);
	}
	
	public void decTime() throws LevelException {
		setTime(getTime() - 1);
	}
	
	public List<Sprite> get1DBoard() {
		ArrayList<Sprite> board1D = new ArrayList<Sprite>();
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {
				board1D.add(board[i][j]);
			}
		}
		return board1D;
	}
	
	public Sprite getCell(int row, int column) {
		return board[putRowInRange(row)][putColumnInRange(column)];
	}
	
	public void setCell(Sprite sprite) throws SpriteException {
		setCell(sprite.getRow(), sprite.getColumn(), sprite);
	}
	
	public void setCell(int row, int column, Sprite sprite) throws SpriteException {
		board[putRowInRange(row)][putColumnInRange(column)] = sprite;
		sprite.setRow(putRowInRange(row));
		sprite.setColumn(putColumnInRange(column));
	}
	
	private int putRowInRange(int row) {
		int correctRow;
		
		if(row < 0) correctRow = 0;
		else if(row >= numRows) correctRow = numRows - 1;
		else correctRow = row;
		
		return correctRow;
	}
	
	private int putColumnInRange(int column) {
		int correctColumn;
		
		if(column < 0) correctColumn = 0;
		else if(column >= numColumns) correctColumn = numColumns - 1;
		else correctColumn = column;
		
		return correctColumn;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for (Sprite[] boardRow : board) {
			for (Sprite sprite: boardRow) {
			    builder.append(sprite.toString());
			}
	    	builder.append("\n");
		}
		return builder.toString();
	}
}