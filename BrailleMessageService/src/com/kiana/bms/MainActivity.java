package com.kiana.bms;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ToggleButton;

import com.immersion.uhl.Launcher;

public class MainActivity extends Activity {

	private Launcher haptics;
	private GestureDetector gestureDetector;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
        	gestureDetector  = new GestureDetector(MainActivity.this, new SwipeListener(this));
        	haptics = new Launcher(this);
        } catch (Exception e) {
            Log.e("BMS", "Exception!: " + e.getMessage());
        }
        
        
    }

	@Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    public void onToggleClicked(View view) {
        
    	ToggleButton toggle = (ToggleButton) view;
        boolean on = toggle.isChecked();
        if (on) {
        	toggle.setBackgroundColor(Color.parseColor("#191970"));
        } else {
        	toggle.setBackgroundColor(Color.parseColor("#FF4500"));
        }
        
        haptics.play(Launcher.DOUBLE_STRONG_CLICK_100);
    }
}
