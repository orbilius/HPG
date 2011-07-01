package se.orbilius.service;

import se.orbilius.shared.HousePriceInfoBatch;

public class MongoDBInserterService implements Service {

	
	static final String NAME = "mongodbinserter";
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void serve(HousePriceInfoBatch batch, ServiceIOArguments args) throws ServiceException {

	}
}
