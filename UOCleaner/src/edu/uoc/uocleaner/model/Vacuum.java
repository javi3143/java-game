package edu.uoc.uocleaner.model;

public class Vacuum extends Sprite implements Movable{
	private final int MAX_CAPACITY;
	private int capacity;
	private Sprite under;
	
	public Vacuum(int row, int column, int maxCapacity) throws SpriteException, VacuumException {
		super(row, column, Symbol.VACUUM);
		setCapacity(0);
		setUnder(new Corridor(row, column));
		if (maxCapacity <= 0) {
			String msg = VacuumException.ERROR_MAX_CAPACITY_VALUE;
			throw new VacuumException(msg);
		} else {
			MAX_CAPACITY = maxCapacity;
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void incCapacity(int inc) throws VacuumException {
		if (inc < 0) {
			String msg = VacuumException.ERROR_INC_CAPACITY_NEGATIVE_VALUE;
			throw new VacuumException(msg);
		} else {
			setCapacity(this.capacity + inc);
		}
	}
	
	private void setCapacity(int capacity) throws VacuumException {
		if (capacity < 0) {
			String msg = VacuumException.ERROR_CAPACITY_NEGATIVE_VALUE;
			throw new VacuumException(msg);
		} else if (capacity > MAX_CAPACITY) {
			String msg = VacuumException.ERROR_OVERFLOW_MAX_CAPACITY;
			throw new VacuumException(msg);
		} else {
			this.capacity = capacity;
		}
	}
	
	public void empty() throws VacuumException {
		setCapacity(0);
	}
	
	public int getMaxCapacity() {
		return MAX_CAPACITY;
	}
	
	public void moveTo(int row, int column) throws SpriteException {
		setRow(row);
		setColumn(column);
	}
	
	public Sprite getUnder() {
		return under;
	}
	
	public void setUnder(Sprite sprite) {
		this.under = sprite;
	}
}
