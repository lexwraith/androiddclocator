package com.example.dcloc;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Location;
import android.util.Log;
import android.view.View;

public class PlotView extends View
{
	Context triactivity;
	Bitmap background;
	float SCALE;
	ArrayList<Coords> mylist;

	public PlotView(Context context)
	{
		super(context);
		triactivity = context;
		background = Bitmap.createScaledBitmap(
				BitmapFactory.decodeResource(getResources(), R.drawable.dcmap),
				1000, 1000, false);
		mylist = new ArrayList(100);
	}

	protected void onDraw(Canvas g)
	{
		/*
		 * OnDraw is the method called when the program "starts", i.e. it's
		 * initial screen I wonder if it's replicated for every screen or is it
		 * called over and over again depending on the state of the program.
		 */
		// It appears the coordinates to from X ={0-1000} and Y = {0,1505}.
		// Not sure on the math.

		Coords blah = (Coords) mylist.get(0);

		SCALE = Math.min(g.getWidth(), g.getHeight()) / (float) 1000;
		g.scale(SCALE, SCALE);
		Paint artist = new Paint();
		g.drawBitmap(background, 0, 0, artist);

		if (mylist.size() > 2)
		{
			for (int z = 1; z < mylist.size(); z++)
			{
				Coords begin = mylist.get(z-1);
				Coords end = mylist.get(z);
				g.drawLine(begin.lng,begin.lat,end.lng,end.lat,artist);
			}
		}
	}
}
