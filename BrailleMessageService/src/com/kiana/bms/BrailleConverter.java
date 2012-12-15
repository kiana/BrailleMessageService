package com.kiana.bms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.ToggleButton;

public class BrailleConverter {
	
	private List<ToggleButton> toggleButtons;
	
	public BrailleConverter(List<ToggleButton> toggleButtons) {
		this.toggleButtons = toggleButtons;
	}
	
	private static Map<String, Character> brailleMap = new HashMap<String, Character>();
	static {
		brailleMap.put("100000", Character.valueOf('a'));
		brailleMap.put("110000", Character.valueOf('b'));
		brailleMap.put("100100", Character.valueOf('c'));
		brailleMap.put("100110", Character.valueOf('d'));
		brailleMap.put("100010", Character.valueOf('e'));
		brailleMap.put("110100", Character.valueOf('f'));
		brailleMap.put("110110", Character.valueOf('g'));
		brailleMap.put("110010", Character.valueOf('h'));
		brailleMap.put("010100", Character.valueOf('i'));
		brailleMap.put("010110", Character.valueOf('j'));
		brailleMap.put("101000", Character.valueOf('k'));
		brailleMap.put("111000", Character.valueOf('l'));
		brailleMap.put("101100", Character.valueOf('m'));
		brailleMap.put("101110", Character.valueOf('n'));
		brailleMap.put("101010", Character.valueOf('o'));
		brailleMap.put("111100", Character.valueOf('p'));
		brailleMap.put("111110", Character.valueOf('q'));
		brailleMap.put("111010", Character.valueOf('r'));
		brailleMap.put("011100", Character.valueOf('s'));
		brailleMap.put("011110", Character.valueOf('t'));
		brailleMap.put("101001", Character.valueOf('u'));
		brailleMap.put("111001", Character.valueOf('v'));
		brailleMap.put("010111", Character.valueOf('w'));
		brailleMap.put("101101", Character.valueOf('x'));
		brailleMap.put("101111", Character.valueOf('y'));
		brailleMap.put("101011", Character.valueOf('z'));
		brailleMap.put("010011", Character.valueOf('.'));
		brailleMap.put("011010", Character.valueOf('!'));
		brailleMap.put("011001", Character.valueOf('?'));
		brailleMap.put("000000", Character.valueOf(' '));
	};
	
	public Character toCharacter() {
		return brailleMap.get(combine());
	}
	
	/**
	 * @param index Position of dot.
	 * @return boolean indicating whether button is toggled on or off.
	 */
	private boolean checked(int index) {
		return toggleButtons.get(index).isChecked();
	}
	
	/**
	 * Combines all values from the toggleButtons list and converts into a string of 0's and 1's.
	 * @return String of 0's and 1's
	 */
	private String combine() {
		StringBuilder combinedIndexes = new StringBuilder();
		for (int index=0 ; index < toggleButtons.size(); index++) {
			combinedIndexes.append(convert(index));
		}
		return combinedIndexes.toString();
	}
	
	/**
	 * Converts toggleButton.isChecked() into 1 or 0.
	 * @param index toggleButton, non zero-index
	 * @return String "1" or "0" corresponding to traditional boolean converted values.
	 */
	private String convert(int index) {
		if (checked(index)) {
			return "1";
		}
		return "0";
	}
}
