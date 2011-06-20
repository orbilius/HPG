package se.orbilius.datagetter;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class DataGetterFromFile implements DataGetter {

	private File file;
	
	public boolean isValid(){
		return this.file.exists();
	}
	
	public DataGetterFromFile(String file) throws IOException{
		this.file = new File(file);
		if(!isValid()){
			throw new IOException("Can't find file " + file);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HousePriceInfoBatch getLatestBatch() throws DataGetterException{
		try {
			HousePriceInfoBatch batch = new HousePriceInfoBatch();
			HousePriceJSONServerParserUtil parser = new HousePriceJSONServerParserUtil();
			List list = FileUtils.readLines(file, "UTF-8");
			for(Object obj : list){
				if(obj instanceof String){
					HousePriceInfo info = parser.parseHousePriceJson((String) obj);
					if(info != null)
						batch.addInfo(info);
				} else{
					System.out.println("That was not a string!");
				}
			}			
			return batch;
		} catch (IOException e) {
			throw new DataGetterException(e);
		}
	}
}
