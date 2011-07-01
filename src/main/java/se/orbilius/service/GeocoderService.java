package se.orbilius.service;

import se.orbilius.geocoder.Geocoder;
import se.orbilius.shared.HousePriceInfoBatch;

/**
 * Reads HousePriceInfo's as JSON strings from a file, specified on the command
 * line Outputs a new file with the same HousePriceInfo's geocoded after their
 * address, also in JSON format.
 * 
 * @author david
 * 
 */

public class GeocoderService implements Service {
	static final String NAME = "geocoder";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void serve(HousePriceInfoBatch batch, ServiceIOArguments args) throws ServiceException {
		Geocoder.geoCodeBatch(batch);
	}
}
