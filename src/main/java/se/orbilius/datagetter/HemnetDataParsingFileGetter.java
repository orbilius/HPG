package se.orbilius.datagetter;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;

import se.orbilius.shared.HousePriceInfoBatch;

public class HemnetDataParsingFileGetter extends DataFileGetter {

	public HemnetDataParsingFileGetter(String file) throws IOException {
		super(file);
	}

	@Override
	public HousePriceInfoBatch getBatch() throws DataGetterException {
		Tidy tidy = new Tidy();
		tidy.setQuiet(true);
		try {
			System.out.println("LETS TRY THIS");
			Document doc = tidy.parseDOM(
					(InputStream) FileUtils.openInputStream(file),
					(OutputStream) null);

		} catch (IOException e) {
			throw new DataGetterException("Failed to parse file " + file
					+ " to a node", e);
		}
		return null;
	}
}
