package com.example.dcloc;

import android.location.Location;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class DCLocListener implements OnTouchListener
{
	MainActivity past;
	Location myloc = new Location("DC");
	public DCLocListener(MainActivity ta)
	{
		this.past = ta;
	}
	public boolean onTouch(View v, MotionEvent event) 
	{
		Log.i("touchtest","I touched here: " + event.getX() + " " + event.getY());
		Log.i("GPS", String.valueOf(myloc.getAccuracy()));
		Log.i("Coords", String.valueOf(myloc.getLatitude()) + " " + String.valueOf(myloc.getLongitude()) );
		
		float x = (event.getX())/past.myprogram.SCALE;
		float y = (event.getY())/past.myprogram.SCALE;
		
		past.rectx = (int) x;
		past.recty = (int) y;
		
		return true;
	}

}
