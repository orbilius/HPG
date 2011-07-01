package se.orbilius.datawriter;

import se.orbilius.dataio.DataIO;
import se.orbilius.shared.HousePriceInfoBatch;

/**
 * A DataWriter knows how to write a {@link HousePriceInfoBatch} to a certain medium

 * @author david
 *
 */
public interface DataWriter extends DataIO {
	
	public void writeData(HousePriceInfoBatch batch) throws DataWriterException;

}
