package se.orbilius.geocoder;

public class Location {

	public String lon, lat;
	
	public final static Location NO_LOCATION = new Location("", "");

	public Location(String lat, String lon) {
		this.lon = lon;
		this.lat = lat;
	}

	public String toString() {
		return "Lat: " + lat + ", Lon: " + lon;
	}
}
