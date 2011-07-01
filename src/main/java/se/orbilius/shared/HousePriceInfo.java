package se.orbilius.shared;

import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class HousePriceInfo {
	
	enum HousePriceType{
		BOSTADSRATT,
		VILLA
	};
	
	
	public final static String ID ="_id";
	public final static String ADDRESS ="address";
	public final static String START_PRICE ="startPrice";
	public final static String SQUARE_METERS ="squareMeters";
	public final static String HOOD ="hood";
	public final static String LAT ="lat";
	public final static String LON ="lon";
	public final static String UNKNOWN_ADDRESS = "unknown";
	public final static String MONTHLY_FEE="fee";
	public final static String SAVED_DATE="date";
	public final static String URL = "url";

	private String id;
	private HousePriceType type;
	private double lon;
	private double lat;
	private String  address;
	private String hood;
	private long startPrice;
	private int squareMeters;
	private Date date;
	private int monthlyFee;
	private String url;
	
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public HousePriceInfo(double lon, double lat, String address, long startPrice, int squareMeters) {
		super();
		this.lon = lon;
		this.lat = lat;
		this.address = address;
		this.startPrice = startPrice;
		this.squareMeters = squareMeters;
	}
	
	
	public boolean hasAddress(){
		return address != null && !address.equals(UNKNOWN_ADDRESS);
	}
	
	public HousePriceInfo(String string, int i, int j) {
		this(0, 0, string, i, j);
	}

	public HousePriceType getType() {
		return type;
	}


	public void setType(HousePriceType type) {
		this.type = type;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getMonthlyFee() {
		return monthlyFee;
	}


	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}


	public HousePriceInfo() {
		// TODO Auto-generated constructor stub
	}

	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(long startPrice) {
		this.startPrice = startPrice;
	}
	
	public void setSquareMeters(int squareMeters) {
		this.squareMeters = squareMeters;
	}

	public int getSquareMeters() {
		return squareMeters;
	}

	
	@Override
	public boolean equals(Object obj) {
		HousePriceInfo other = (HousePriceInfo) obj;
		return (lon != 0 && lat !=0 && other.lon == this.lon && other.lat == this.lat) |  other.address.equals(address);
	}
	
	@Override
	public String toString() {
		return "HOUSEPRICEINFO " + id + " " + address + ", " + hood + " " + squareMeters + " " + startPrice + " " +  lat + " " + lon + " " + url + " " + date;
	}


	public void setHood(String hood) {
		this.hood = hood;
	}


	public String getHood() {
		return hood;
	}


	public void setSavedDate(Date date) {
		this.date = date;		
	}


	public Object getSavedDate() {
		return date;
	}
	
}
