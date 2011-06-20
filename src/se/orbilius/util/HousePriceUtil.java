package se.orbilius.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HousePriceUtil {
	
	private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

	public static DateFormat getDateFormat(){
		return format;
	}
}
