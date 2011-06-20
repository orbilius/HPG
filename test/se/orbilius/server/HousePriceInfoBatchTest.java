package se.orbilius.server;


import junit.framework.TestCase;
import se.orbilius.*;
import se.orbilius.shared.HousePriceInfoBatch;
import se.orbilius.shared.HousePriceJSONUtil;

public class HousePriceInfoBatchTest extends TestCase {

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
	
	public void testJSONString(){
		HousePriceInfoBatch batch = HousePriceInfoTestUtil.getTestBatch();
		HousePriceJSONUtil parser = new HousePriceJSONServerParserUtil();
		
		String string = parser.housePriceBatchToJSONString(batch);
		HousePriceInfoBatch parsedBatch = parser.parseHousePriceBatch(string);
		assertEquals(batch.getInfoList().size(), parsedBatch.getInfoList().size());

	}
}
