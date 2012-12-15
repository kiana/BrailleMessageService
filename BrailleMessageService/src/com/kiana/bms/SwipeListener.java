package com.kiana.bms;

import android.content.Context;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;

public class SwipeListener extends SimpleOnGestureListener {
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private Context context;
    
    public SwipeListener(Context context) {
    	this.context = context;
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
    	Toast.makeText(context, "bottom", Toast.LENGTH_SHORT).show();
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

