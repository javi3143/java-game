package edu.uoc.uocleaner.model;

public enum Symbol {
	DUSTBALL('@', "dustball.png"),
	DUMPSTER('D', "dumpster.png"),
	VACUUM('V', "huocver.png"),
	DIRT('·', "dirt.png"),
	WALL('#', ""),
	CORRIDOR(' ', "");
	
	private final char ascii;
	private final String image;
	
	private Symbol(char ascii, String image) {
		this.ascii = ascii;
		this.image = image;
	}
	
	public static Symbol getName(char ascii) {
		Symbol result = null;
		int i= 0;
		
		Symbol[] symbols = Symbol.values();
		while(i < symbols.length && result == null) {
			if (symbols[i].getAscii() == ascii) {
				result = symbols[i];
			}
			i++;
		}
		return result;
	}
	
	public char getAscii() {
		return ascii;
	}
	
	public String getImage() {
		return image;
	}
	
	@Override
	public String toString() {
		return String.valueOf(ascii);
	}
}
