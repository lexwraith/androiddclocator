package com.example.dcloc;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity
{
	int rectx = 300, recty = 300;
	PlotView myprogram;
	static final double DC_WEST = -77.119789, DC_EAST = -76.909399,
			DC_NORTH = 38.99554, DC_SOUTH = 38.79163;
	private LocationManager lm;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		myprogram = new PlotView(this);
		myprogram.setOnTouchListener(new DCLocListener(this));
		setContentView(myprogram);
		initializeGPS();
		
		Thread t = new Thread()
		{
			public void run()
			{
				Looper.prepare();
				while (true)
				{
					double lng = getLongitude();
					double lat = getLatitude();
					
					int pixlng = (int) Math.abs((lng - DC_WEST)/(DC_EAST - DC_WEST) * 1000);
					int pixlat = (int) Math.abs((lat - DC_NORTH)/(DC_SOUTH -  DC_NORTH) * 1000);
					
					Coords temp = new Coords(pixlng, pixlat);
					System.out.println(temp.print());
					myprogram.postInvalidate();
					
					myprogram.mylist.add(temp);
					
					try
					{
						Thread.sleep(10000);
					} catch (InterruptedException o)
					{
					}
				}
			}

		};
		t.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private void initializeGPS()
	{
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0,
				new LocationListener()
				{
					public void onLocationChanged(Location location)
					{

					}

					public void onProviderDisabled(String provider)
					{

					}

					public void onProviderEnabled(String provider)
					{
					}

					public void onStatusChanged(String provider, int status,
							Bundle extras)
					{
					}
				});
	}

	private double getLatitude()
	{
		if (lm == null
				|| lm.getLastKnownLocation(LocationManager.GPS_PROVIDER) == null)
			return 0;
		return lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
				.getLatitude();
	}

	private double getLongitude()
	{
		if (lm == null
				|| lm.getLastKnownLocation(LocationManager.GPS_PROVIDER) == null)
			return 0;
		return lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
				.getLongitude();
	}
}
