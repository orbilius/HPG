package se.orbilius.datagetter.mongodb;

import se.orbilius.shared.HousePriceInfoBatch;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class QueryBuilder {

	
	public DBObject build(int maxPrice){
		if(maxPrice != HousePriceInfoBatch.NO_MAX_PRICE){
			BasicDBObject query = new BasicDBObject();

			query.put("startPrice", new BasicDBObject("$lt", maxPrice));  // e.g. find all where i > 50

			return query;
		}
		
		return null;
	}
}
