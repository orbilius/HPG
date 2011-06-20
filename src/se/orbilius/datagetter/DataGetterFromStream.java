package se.orbilius.datagetter;

import java.io.IOException;
import java.io.InputStream;

import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class DataGetterFromStream implements DataGetter {

	private InputStream stream;
	
	public DataGetterFromStream(InputStream stream) {
		this.stream = stream;
	}
	
	
	@Override
	public HousePriceInfoBatch getLatestBatch() throws DataGetterException {

		try {
			java.io.BufferedReader stdin = new java.io.BufferedReader(
					new java.io.InputStreamReader(stream, "UTF8"));
			
			HousePriceJSONServerParserUtil parser = new HousePriceJSONServerParserUtil();
			HousePriceInfoBatch batch = new HousePriceInfoBatch();
			while(true){
				String line = stdin.readLine();
				if(line == null)
					break;
				HousePriceInfo info = parser.parseHousePriceJson(line);
				batch.addInfo(info);
			}
			
			return batch;
			
		} catch (IOException e) {
			throw new DataGetterException(e);

		}
	}
}
