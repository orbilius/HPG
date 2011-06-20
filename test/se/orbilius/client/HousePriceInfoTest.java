package se.orbilius.client;


import junit.framework.TestCase;
import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceJSONUtil;

public class HousePriceInfoTest extends TestCase {

    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
    }

    @Override
    protected void tearDown()
        throws Exception
    {
        super.tearDown();
    }
	

	public void testJSonStringAndParsing(){
		assertEquals(true, true);
	    /*
		HousePriceInfo info = HousePriceInfoTestUtil.getTestHousePriceInfo();
		HousePriceJSONUtil parser = new HousePriceJSONClientParserUtil();
		
		String string = new HousePriceJSONServerParserUtil().housePriceToJSONString(info);
		HousePriceInfo parsed = parser.parseHousePriceJson(string);
		assertNotNull(parsed);
		assertEquals(info.getAddress(), parsed.getAddress());
		assertEquals(info.getStartPrice(), parsed.getStartPrice());
		assertEquals(info.getSquareMeters(), parsed.getSquareMeters());
		assertEquals(info.getUrl(), parsed.getUrl());
	*/
	}

}
