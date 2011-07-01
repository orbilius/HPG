package se.orbilius.datagetter;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class JSonStringFileDataGetter extends DataFileGetter implements DataGetter {

	public JSonStringFileDataGetter(String file) throws IOException{
		super(file);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public HousePriceInfoBatch getBatch() throws DataGetterException{
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
