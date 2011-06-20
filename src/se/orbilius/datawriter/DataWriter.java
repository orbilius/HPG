package se.orbilius.datawriter;

import se.orbilius.dataio.DataIO;
import se.orbilius.shared.HousePriceInfoBatch;

public interface DataWriter extends DataIO {
	
	public void writeData(HousePriceInfoBatch batch) throws DataWriterException;

}
