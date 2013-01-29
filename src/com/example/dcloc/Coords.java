package com.example.dcloc;

public class Coords
{
	public int lat, lng;

	Coords(int lng, int lat)
	{
		this.lat = lat;
		this.lng = lng;
	}

	Coords(double lng, double lat)
	{
		
		this.lat = (int) Math.round(lat);
		this.lng = (int) Math.round(lng);
	}
	
	public String print()
	{
		return (String.valueOf(this.lng) + " " + String.valueOf(this.lat));
	}
}
