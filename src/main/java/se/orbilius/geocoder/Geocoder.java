package se.orbilius.geocoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class Geocoder {
	private final static String ENCODING = "UTF-8";
	private final static String KEY = "xyz";

	private final static java.util.logging.Logger LOG = java.util.logging.Logger.getLogger("geocoder");
	

	public static void geoCodeBatch(HousePriceInfoBatch batch) {
		for (HousePriceInfo info : batch.getInfoList()) {
			try {
				Thread.sleep(3 * 1000);


				if (info.hasAddress()) {
					String addr = info.getAddress();
					String hood = info.getHood();
					Location loc = getLocation(addr + ", " + hood + ", Stockholm, Sweden");
					if (loc != null) {
						info.setLat(Double.parseDouble(loc.lat));
						info.setLon(Double.parseDouble(loc.lon));
					} else {
					}
					//LOG.log(Level.INFO, addr + ", " + info.getLat() + ", " + info.getLon());


				}

			} catch (IOException e) {
				e.printStackTrace();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static Location parseGeocoderResponse(String line){
		// Format: 200,6,42.730070,-73.690570
		return  new Location(line.substring("200,6,".length(), line
				.indexOf(',', "200,6,".length())), line.substring(line
				.indexOf(',', "200,6,".length()) + 1, line.length()));
	}
	
	public static Location getLocation(String address) throws IOException {

		String encondedAddress = URLEncoder.encode(address, ENCODING);
		String url = "http://maps.google.com/maps/geo?q="
			+ encondedAddress
			+ "&output=csv&key=" + KEY;
		BufferedReader in = new BufferedReader(new InputStreamReader(new URL(
				url).openStream()));
		int statusCode = -1;
		
		LOG.log(Level.INFO, url);
		
		String line;
		Location location = null;
		while ((line = in.readLine()) != null) {
			statusCode = Integer.parseInt(line.substring(0, 3));
			if (statusCode == 200){
				location = parseGeocoderResponse(line);
			}
		}
		if (location == null) {
			switch (statusCode) {
			case 400:
				throw new IOException("Bad Request");
			case 500:
				throw new IOException("Unknown error from Google Encoder");
			case 601:
				throw new IOException("Missing query");
			case 602:
				return null;
			case 603:
				throw new IOException("Legal problem");
			case 604:
				throw new IOException("No route");
			case 610:
				throw new IOException("Bad key");
			case 620:
				throw new IOException("Too many queries");
			}
		}
		return location;
	}

	public static void main(String[] argv) throws Exception {
		System.out.println(Geocoder
				.getLocation("KŠglestigen 4, Bromma, Sweden"));
	}
}
