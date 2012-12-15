package com.kiana.bms;

import java.util.List;

import android.widget.ToggleButton;

public class BrailleConverter {

	private List<ToggleButton> toggleButtons;
	
	public BrailleConverter(List<ToggleButton> toggleButtons) {
		this.toggleButtons = toggleButtons;
	}
	
	public Character toCharacter() {
		if (a()) return 'a';
		if (b()) return 'b';
		if (space()) return ' ';
		if (questionMark()) return '?';
		if (exclamationMark()) return '!';
		if (period()) return '.';
		return null;
	}
	
	private boolean space() {
		return !checked(1) && !checked(2) && !checked(3) && !checked(4) && !checked(5) && !checked(6);
	}
	
	private boolean period() {
		return !checked(1) && checked(2) && !checked(3) && !checked(4) && checked(5) && checked(6);
	}
	
	private boolean questionMark() {
		return !checked(1) && checked(2) && checked(3) && !checked(4) && !checked(5) && checked(6);
	}
	
	private boolean exclamationMark() {
		return !checked(1) && checked(2) && checked(3) && !checked(4) && checked(5) && checked(6);
	}
	
	private boolean a() {
		return checked(1) && !checked(2) && !checked(3) && !checked(4) && !checked(5) && !checked(6);
	}

	private boolean b() {
		return checked(1) && checked(2) && !checked(3) && !checked(4) && !checked(5) && !checked(6);
	}
	
	/**
	 * @param index Position of dot. NOT zero-indexed for better translation. Subtracts 1 to find the zero-indexed position in ArrayList.
	 * @return boolean indicating whether button is toggled on or off.
	 */
	private boolean checked(int index) {
		return toggleButtons.get(index-1).isChecked();
	}
}
