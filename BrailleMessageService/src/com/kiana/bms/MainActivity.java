package com.kiana.bms;

import android.app.Activity;
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
			gestureDetector  = new GestureDetector(MainActivity.this, new SwipeListener(this, findViewById(android.R.id.content)));
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
		ToggleButton button = (ToggleButton) view;
		switch (button.getId()) {
			case R.id.dot1:
				haptics.play(Launcher.SHARP_CLICK_100);
			case R.id.dot2:
				haptics.play(Launcher.SHARP_CLICK_66);
			case R.id.dot3:
				haptics.play(Launcher.SHARP_CLICK_33);
			case R.id.dot4:
				haptics.play(Launcher.TICK_100);
			case R.id.dot5:
				haptics.play(Launcher.TICK_66);
			case R.id.dot6:
				haptics.play(Launcher.TICK_33);
		}
	}
}
