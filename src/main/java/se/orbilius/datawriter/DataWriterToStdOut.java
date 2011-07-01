package se.orbilius.datawriter;

import se.orbilius.dataio.UTF8Stream;
import se.orbilius.server.HousePriceJSONServerParserUtil;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class DataWriterToStdOut implements DataWriter {

	@Override
	public void writeData(HousePriceInfoBatch batch) throws DataWriterException {
		HousePriceJSONServerParserUtil parser = new HousePriceJSONServerParserUtil();
		if (batch != null) {
			for (HousePriceInfo info : batch.getInfoList()) {
				String json = parser.housePriceToJSONString(info);
				UTF8Stream.println(json);
			}
		}
	}
}
