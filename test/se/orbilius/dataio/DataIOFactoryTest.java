package se.orbilius.dataio;

import junit.framework.TestCase;
import se.orbilius.HousePriceInfoTestUtil;
import se.orbilius.datagetter.DataGetter;
import se.orbilius.datagetter.DataGetterException;
import se.orbilius.datagetter.DataGetterFromFile;
import se.orbilius.datagetter.DataGetterFromStream;
import se.orbilius.datagetter.mongodb.DataGetterFromMongoDB;
import se.orbilius.datawriter.DataWriter;
import se.orbilius.datawriter.DataWriterException;
import se.orbilius.datawriter.DataWriterToFile;
import se.orbilius.datawriter.DataWriterToMongoDB;
import se.orbilius.datawriter.DataWriterToStdOut;
import se.orbilius.service.ServiceIOArguments;

public class DataIOFactoryTest extends TestCase {

	public void testCreateFileGetter() {
		try {

			DataGetter getter = new DataIOFactory()
					.getGetter(ServiceIOArguments
							.parse(new String[] {
									"-inmodefile",
									"-infile/Users/david/Projects/m/HousePriceInfoGrapher/data/test/bromma20100502.txt" }));
			assertEquals(getter instanceof DataGetterFromFile, true);

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
			assertEquals(getter instanceof DataGetterFromStream, true);

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
									"-outfile/Users/david/Projects/m/HousePriceInfoGrapher/data/test/foo.txt" }));
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
