package com.example.dcloc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Location;
import android.view.View;

public class TriangleComponent extends View 
{
	Context triactivity;
	Bitmap	background;
	float SCALE;
	public TriangleComponent(Context context) 
	{
		super(context); 
		triactivity = context;
		background = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.dcmap));
	}

	protected void onDraw(Canvas g) 
	{
		SCALE = Math.min(g.getWidth(), g.getHeight() ) / (float)1000;
		g.scale(SCALE, SCALE);
		
		//System.out.println("printing stuff");
		//Paint paint = new Paint();
		//paint.setColor(Color.BLUE);
		//g.drawRect(400,490,600,510, paint);
		//g.drawBitmap(background,0,0,paint);
	}
}
