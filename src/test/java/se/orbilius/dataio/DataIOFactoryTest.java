package se.orbilius.dataio;

import junit.framework.TestCase;
import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.datagetter.DataGetter;
import se.orbilius.datagetter.DataGetterException;
import se.orbilius.datagetter.HemnetDataParsingFileGetter;
import se.orbilius.datagetter.JSonStringFileDataGetter;
import se.orbilius.datagetter.StreamDataGetter;
import se.orbilius.datagetter.mongodb.DataGetterFromMongoDB;
import se.orbilius.datawriter.DataWriter;
import se.orbilius.datawriter.DataWriterException;
import se.orbilius.datawriter.DataWriterToFile;
import se.orbilius.datawriter.DataWriterToMongoDB;
import se.orbilius.datawriter.DataWriterToStdOut;
import se.orbilius.service.ServiceIOArguments;

public class DataIOFactoryTest extends TestCase {

	public void testCreateJSonStringFileGetter() {
		try {
			DataGetter getter = new DataIOFactory()
					.getGetter(ServiceIOArguments
							.parse(new String[] {
									"-inmodefile",
									"-infiletestfile.txt" }));
			assertEquals(getter instanceof JSonStringFileDataGetter, true);
			
			
		} catch (DataGetterException e) {
			e.printStackTrace();
			fail();
		}
	}

	
	public void testHemnetFileGetter() {
		try {

			DataGetter getter = new DataIOFactory()
					.getGetter(ServiceIOArguments
							.parse(new String[] {
									"-inmodehemnetfile",
									"-infiletestfile.txt" }));
			assertEquals(getter instanceof HemnetDataParsingFileGetter, true);

		} catch (DataGetterException e) {
			e.printStackTrace();
			fail();
		}
	}

	
	public void testCreateStdInGetter() {
		try {
			DataGetter getter = new DataIOFactory()
					.getGetter(ServiceIOArguments
							.parse(new String[] { "-inmodestd" }));
			assertEquals(getter instanceof StreamDataGetter, true);

		} catch (DataGetterException e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testCreateMongoDBGetter() {
		try {
			DataGetter getter = new DataIOFactory()
					.getGetter(ServiceIOArguments
							.parse(new String[] { "-inmodemongodb",
									"-inhostlocalhost", "-inport27017",
									"-indbtestdb", "-incoltestcoll22" }));
			assertEquals(getter instanceof DataGetterFromMongoDB, true);

		} catch (DataGetterException e) {
			e.printStackTrace();
			fail();
		}
	}

	// Writer tests
	public void testCreateFileWriter() {
		try {
			DataWriter writer = new DataIOFactory()
					.getWriter(ServiceIOArguments
							.parse(new String[] { "-outmodefile",
									"-outfile/Users/polopoly/projects/HPG/data/test/foo.txt" }));
			assertEquals(writer instanceof DataWriterToFile, true);
			writer.writeData(HousePriceInfoTestUtil.getTestBatch());

		} catch (DataWriterException e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testCreateStdOutWriter() {
		try {
			DataWriter writer = new DataIOFactory()
					.getWriter(ServiceIOArguments
							.parse(new String[] { "-outmodestd" }));
			assertEquals(writer instanceof DataWriterToStdOut, true);

		} catch (DataWriterException e) {
			e.printStackTrace();
			fail();
		}
	}

	public void testCreateMongoDBWriter() {
		try {
			DataWriter writer = new DataIOFactory()
					.getWriter(ServiceIOArguments.parse(new String[] {
							"-outmodemongodb", "-outhostlocalhost",
							"-outport27017", "-outdbtestdb",
							"-outcoltestcoll22" }));
			assertEquals(writer instanceof DataWriterToMongoDB, true);

		} catch (DataWriterException e) {
			e.printStackTrace();
			fail();
		}
	}
}
