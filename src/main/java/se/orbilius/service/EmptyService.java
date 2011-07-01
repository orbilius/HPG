package se.orbilius.service;

import se.orbilius.shared.HousePriceInfoBatch;

public class EmptyService implements Service {

	public static final String NAME = "empty";
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void serve(HousePriceInfoBatch batch, ServiceIOArguments args) throws ServiceException {
		//Do nuthin, that's the point
	}

}
