package se.orbilius.datagetter.mongodb;

import java.net.UnknownHostException;

import se.orbilius.datagetter.DataGetter;
import se.orbilius.datagetter.DataGetterException;
import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DataGetterFromMongoDB implements DataGetter {

	private DB db = null;
	private DBCollection collection;
	private DBObject query;
	
	public DataGetterFromMongoDB(String host, int port, String database, String coll) throws DataGetterException {
		Mongo m;
		try {
//			m = new Mongo("localhost", 27017);
			m = new Mongo(host, port);
			db = m.getDB(database);
			collection = db.getCollection(coll);
		} catch (UnknownHostException e) {
			throw new DataGetterException(e);
		} catch (MongoException e) {
			throw new DataGetterException(new Exception(e));
		}
	}
	
	public void setQuery(DBObject query){
		this.query = query;
	}

	@Override
	public HousePriceInfoBatch getBatch() {
		HousePriceInfoBatch batch = new HousePriceInfoBatch();
		HousePriceJSONServerParserUtil util = new HousePriceJSONServerParserUtil();
		
		DBCursor cursor = null;
		if(query != null){
			cursor = collection.find(query);
		}
		else{
			cursor = collection.find();
		}
		while(cursor.hasNext()){
			DBObject obj = cursor.next();
			//System.out.println(obj.toString());
			HousePriceInfo info = util.parseHousePriceJson(obj.toString());
			//System.out.println(info);
			batch.addInfo(info);
		}		
		return batch;
	}
}
