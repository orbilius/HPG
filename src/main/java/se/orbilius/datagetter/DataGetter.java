package se.orbilius.datagetter;

import se.orbilius.dataio.DataIO;
import se.orbilius.shared.HousePriceInfoBatch;

/**
 * A DataGetter knows how to read a {@link HousePriceInfoBatch} from a certain medium
 * 
 * @author david
 *
 */
public interface DataGetter extends DataIO{
	
	public HousePriceInfoBatch getBatch() throws DataGetterException;

}
