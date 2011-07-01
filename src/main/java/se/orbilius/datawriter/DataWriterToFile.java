package se.orbilius.datawriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class DataWriterToFile implements DataWriter {

	private File file;

	public DataWriterToFile(String file) throws IOException{

		this.file = new File(file);
	}
	
	@Override
	public void writeData(HousePriceInfoBatch batch) throws DataWriterException {

		HousePriceJSONServerParserUtil parser = new HousePriceJSONServerParserUtil();
		List<String> jsonStrings = new ArrayList<String>();
		
		for(HousePriceInfo info : batch.getInfoList()){
			String json = parser.housePriceToJSONString(info);
			jsonStrings.add(json);
		}
		
		try {
			FileUtils.writeLines(file, "UTF-8", jsonStrings);
		} catch (IOException e) {
			throw new DataWriterException(e);
		}
	}
}
