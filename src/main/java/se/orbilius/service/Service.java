package se.orbilius.service;

import se.orbilius.shared.HousePriceInfoBatch;

/**
 * A service does something to a {@link HousePriceInfoBatch}
 *
 * @author david
 *
 */
public interface Service {

	String getName();
	
	void serve(HousePriceInfoBatch batch, ServiceIOArguments args) throws ServiceException;
	
}
