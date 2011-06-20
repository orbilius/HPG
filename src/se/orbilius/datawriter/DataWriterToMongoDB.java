package se.orbilius.datawriter;

import java.net.UnknownHostException;

import se.orbilius.dataio.UTF8Stream;
import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;
import se.orbilius.util.Chain;
import se.orbilius.util.ChainImpl;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DataWriterToMongoDB implements DataWriter {

	private DB db = null;
	private DBCollection collection;
	
	public DataWriterToMongoDB(String host, int port, String database, String col) throws DataWriterException {
		Mongo m;
		try {
			m = new Mongo(host, port);
			db = m.getDB(database);
			collection = db.getCollection(col);
		} catch (UnknownHostException e) {
			throw new DataWriterException(e);
		} catch (MongoException e) {
			throw new DataWriterException(new Exception(e));
		}
	}
	
	 DataWriterToMongoDB(){
		 
	 }
	
	@Override
	public void writeData(HousePriceInfoBatch batch) throws DataWriterException {
		HousePriceJSONServerParserUtil parser = new HousePriceJSONServerParserUtil();
		for(HousePriceInfo info : batch.getInfoList()){
			Chain validationChain = createValidationChain();
			if(validationChain.execute(info)){
				UTF8Stream.println("Writing " + info);
				BasicDBObject obj = (BasicDBObject) com.mongodb.util.JSON.parse(parser.housePriceToJSONString(info));

				collection.insert(obj);		
			} else{
				UTF8Stream.println("Will not write " + info + " : " + validationChain.getErrorMessage());
				
			}
		}
	}

	private Chain createValidationChain() {
		Chain chain = new ChainImpl();
		
		chain.addCommand(new BreakChainIfNoAddressCommand());
		chain.addCommand(new BreakChainIfNoSquareMetersCommand());
		chain.addCommand(new BreakChainIfNoStartPriceCommand());

		return chain;
	}
}
