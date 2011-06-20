package se.orbilius.service;

import se.orbilius.shared.HousePriceInfoBatch;

public interface Service {

	public String getName();
	public void serve(HousePriceInfoBatch batch, ServiceIOArguments args) throws ServiceException;
	
}
