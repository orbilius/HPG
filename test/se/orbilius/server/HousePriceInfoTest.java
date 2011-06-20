package se.orbilius.server;


import junit.framework.TestCase;
import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.shared.HousePriceInfo;

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
		HousePriceInfo info = HousePriceInfoTestUtil.getTestHousePriceInfo();
		HousePriceJSONServerParserUtil parser = new HousePriceJSONServerParserUtil();
		
		String string = parser.housePriceToJSONString(info);
		System.out.println(string);

		HousePriceInfo parsed = parser.parseHousePriceJson(string);
		assertNotNull(parsed);
		assertEquals(info.getAddress(), parsed.getAddress());
		assertEquals(info.getStartPrice(), parsed.getStartPrice());
		assertEquals(info.getSquareMeters(), parsed.getSquareMeters());
	}
}
