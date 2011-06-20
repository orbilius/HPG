package se.orbilius.service;

import java.util.Date;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class DataAugmenterService implements Service {

	public final static String NAME = "dataaugment";
	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public void serve(HousePriceInfoBatch batch, ServiceIOArguments args) throws ServiceException {
		for (HousePriceInfo info : batch.getInfoList()) {
			addDateOfSaving(info);
		}
	}
	
	protected void addDateOfSaving(HousePriceInfo info){
		if (info.getSavedDate() == null){
			info.setSavedDate(new Date());
		}
	}
}
