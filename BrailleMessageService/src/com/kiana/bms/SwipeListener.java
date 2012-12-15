package com.kiana.bms;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SwipeListener extends SimpleOnGestureListener {
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private Context context;
    private BrailleConverter brailleConverter;
    private StringBuilder sentence;
    List<ToggleButton> buttonList;
    
    public SwipeListener(Context context, View view) {
    	this.context = context;
    	initializeBrailleConverter(view);
    	sentence = new StringBuilder();
    }

    private void initializeBrailleConverter(View view) {
		buttonList = new ArrayList<ToggleButton>();
		buttonList.add((ToggleButton)view.findViewById(R.id.dot1)); 
		buttonList.add((ToggleButton)view.findViewById(R.id.dot2)); 
		buttonList.add((ToggleButton)view.findViewById(R.id.dot3)); 
		buttonList.add((ToggleButton)view.findViewById(R.id.dot4)); 
		buttonList.add((ToggleButton)view.findViewById(R.id.dot5)); 
		buttonList.add((ToggleButton)view.findViewById(R.id.dot6)); 
		brailleConverter = new BrailleConverter(buttonList);
	}
    
    private void toggleAllButtonsOff() {
    	for (ToggleButton button : buttonList) {
    		button.setChecked(false);
    	}
    }

	private void onSwipeRight() {
    	Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
    }

    private void onSwipeLeft() {
    	Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();
    }

    private void onSwipeTop() {
    	Toast.makeText(context, "top", Toast.LENGTH_SHORT).show();
    }

    private void onSwipeBottom() {
    	Character character = brailleConverter.toCharacter();
    	if (character != null) {
    		sentence.append(character);
        	Toast.makeText(context, sentence.toString(), Toast.LENGTH_SHORT).show();
        	//TODO haptics indicating letter ADDED
    	} else {
    		//TODO haptics indicating letter NOT ADDED
    	}
		toggleAllButtonsOff();
    }
    
    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                }
            } else {
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }
}

