package se.orbilius.datagetter;

import se.orbilius.dataio.DataIO;
import se.orbilius.shared.HousePriceInfoBatch;

public interface DataGetter extends DataIO{
	
	public HousePriceInfoBatch getLatestBatch() throws DataGetterException;

}
