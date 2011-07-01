package se.orbilius.service;

import java.util.Date;

import junit.framework.TestCase;
import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;
import se.orbilius.util.HousePriceUtil;

public class ServiceTest extends TestCase {

	public void testGetGeoCoderService() {
		try {

			Service service = new ServiceFactory()
					.getService(ServiceIOArguments
							.parse(new String[] { "-servicegeocoder" }));

			assertEquals(service instanceof GeocoderService, true);

		} catch (NoSuchServiceException e) {
			e.printStackTrace();
			assertEquals(false, true);

		}
	}

	public void testAugmentBatch() {
		try {

			HousePriceInfoBatch testBatch = HousePriceInfoTestUtil
					.getTestBatch();

			HousePriceInfo info = testBatch.getInfoList().get(0);
			assertEquals(info.getSavedDate(), null);
			ServiceIOArguments args = ServiceIOArguments
			.parse(new String[] { "-servicedataaugment" });
			
			Service service = new ServiceFactory()
					.getService(args);
			
			service.serve(testBatch, args);
			assertEquals(HousePriceUtil.getDateFormat().format(info.getSavedDate()), HousePriceUtil.getDateFormat().format(new Date()));

		} catch (NoSuchServiceException e) {
			e.printStackTrace();
			assertEquals(false, true);

		} catch (ServiceException e) {
			e.printStackTrace();
			assertEquals(false, true);

		}
	}
}
