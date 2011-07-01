package se.orbilius.server;

import java.util.logging.Level;
import java.util.logging.Logger;

import se.orbilius.client.HousePriceInfoService;
import se.orbilius.datagetter.DataGetterException;
import se.orbilius.datagetter.mongodb.DataGetterFromMongoDB;
import se.orbilius.datagetter.mongodb.QueryBuilder;
import se.orbilius.shared.HousePriceInfoBatch;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mongodb.DBObject;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class HousePriceInfoServiceImpl extends RemoteServiceServlet implements
		HousePriceInfoService {
	
	private final static Logger LOG = Logger.getLogger(HousePriceInfoServiceImpl.class.getName());

	public String getHousePriceInfo(String input, String maxPrice)
			throws IllegalArgumentException {
		// Verify that the input is valid.
		/*
		 * if (!FieldVerifier.isValidName(input)) { // If the input is not
		 * valid, throw an IllegalArgumentException back to // the client. throw
		 * new IllegalArgumentException(
		 * "Name must be at least 4 characters long"); }
		 */

		HousePriceInfoBatch batch = new HousePriceInfoBatch();

		String[] collections = input.split(",");

		int max = HousePriceInfoBatch.NO_MAX_PRICE;
		if(maxPrice != null && maxPrice.length() > 0){
			try{
				max = Integer.parseInt(maxPrice);
			} catch(NumberFormatException nfe){
				LOG.warning("Failed to parse max price input " + maxPrice);
			}
		}
		
		
		DBObject query = new QueryBuilder().build(max);
		
		
		for (String string : collections) {
			String trimmed = string.trim();
			try {

				DataGetterFromMongoDB getter = new DataGetterFromMongoDB("localhost", 27017,
						"testdb", trimmed);
				getter.setQuery(query);
				
				HousePriceInfoBatch b = getter.getBatch();
				batch.merge(b);
				//System.out.println("merged " + batch.getInfoList() + " from " + trimmed);
				
			} catch (DataGetterException e) {
				LOG.log(Level.SEVERE, "Failed to retrieve data", e);
			}
		}
		
		
		return new HousePriceJSONServerParserUtil()
				.housePriceBatchToJSONString(batch);
	}
}
