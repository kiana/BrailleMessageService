package com.kiana.bms;

import java.util.List;

import android.widget.ToggleButton;

public class BrailleConverter {

	private List<ToggleButton> toggleButtons;
	
	public BrailleConverter(List<ToggleButton> toggleButtons) {
		this.toggleButtons = toggleButtons;
	}
	
	public Character toLetter() {
		if (a()) return 'a';
		if (b()) return 'b';
		return null;
	}
	
	private boolean a() {
		return checked(1) && !checked(2) && !checked(3) && !checked(4) && !checked(5) && !checked(6);
	}

	private boolean b() {
		return checked(1) && checked(2) && !checked(3) && !checked(4) && !checked(5) && !checked(6);
	}
	
	private boolean checked(int index) {
		return toggleButtons.get(index-1).isChecked();
	}
}
