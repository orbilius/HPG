package se.orbilius.server;

import junit.framework.TestCase;
import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.shared.HousePriceInfo;

public class HousePriceJSONServerParserUtilTest extends TestCase {

	
	public void testCreateJSONWithLatLon(){
		HousePriceInfo info = HousePriceInfoTestUtil.getTestHousePriceInfo();
		HousePriceJSONServerParserUtil parser = new HousePriceJSONServerParserUtil();
		String string = parser.housePriceToJSONString(info);
		
		HousePriceInfo parsed = parser.parseHousePriceJson(string);
		assertEquals(info.getLat(), parsed.getLat());
		assertEquals(info.getLon(), parsed.getLon());
		assertEquals(info.getUrl(), parsed.getUrl());
	}
}
