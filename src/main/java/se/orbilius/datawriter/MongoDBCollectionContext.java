package se.orbilius.datawriter;

import com.mongodb.DBCollection;

import se.orbilius.util.ContextImplBase;

public class MongoDBCollectionContext extends ContextImplBase {

	public MongoDBCollectionContext(DBCollection col){
		this.put("col", col);
	}

	@SuppressWarnings("unused")
	private MongoDBCollectionContext(){}
	
	public DBCollection getCollection(){
		DBCollection myCol = (DBCollection)get("col");
		if(myCol == null)
			throw new IllegalStateException("No collection has been added yet");
		return myCol;
	}
}
