package se.orbilius.datagetter;

import java.util.List;

import junit.framework.TestCase;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class DataGetterFromMongoDBTest extends TestCase {

	public void testGetMockData() {
		DataGetter getter = new DataGetterMock();
		HousePriceInfoBatch batch;
		try {
			batch = getter.getLatestBatch();
			List<HousePriceInfo> list = batch.getInfoList();
			assertNotNull("List was null", list);
			assertTrue("Found no items in that list", list.size() > 0);
		} catch (DataGetterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
