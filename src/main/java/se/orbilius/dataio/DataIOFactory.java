package se.orbilius.dataio;

import java.io.IOException;

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

public class DataIOFactory {


	private static final Object MODE_HEMNETFILE = "hemnetfile";
	private String MODE_MONGO_DB = "mongodb";
	private String MODE_FILE = "file";
	private String MODE_STD = "std";


	public DataWriter getWriter(ServiceIOArguments args) throws DataWriterException{
		try {
			return (DataWriter) getIO(args, ServiceIOArguments.Direction.DIRECTION_OUT);
		} catch (DataIOException e) {
			throw new DataWriterException(e);
		}
	}
	
	public DataGetter getGetter(ServiceIOArguments args) throws DataGetterException{
		try {
			return (DataGetter) getIO(args, ServiceIOArguments.Direction.DIRECTION_IN);
		} catch (DataIOException e) {
			throw new DataGetterException(e);
		}
	}
	
	public DataIO getIO(ServiceIOArguments argms, ServiceIOArguments.Direction dir) throws DataIOException {
		
		if (MODE_MONGO_DB.equals(argms.getMode(dir))) {
			if (argms.getHost(dir) != null && argms.getPort(dir) > -1 && argms.getDb(dir) != null && argms.getCol(dir) != null) {

				if (dir.equals(ServiceIOArguments.Direction.DIRECTION_IN)) {
					try {
						return new DataGetterFromMongoDB(argms.getHost(dir), argms.getPort(dir), argms.getDb(dir), argms.getCol(dir));
					} catch (DataGetterException e) {
						throw new DataIOException(
								"Could not create a mongodb getter given those arguments");
					}
				} else {
					try {
						return new DataWriterToMongoDB(argms.getHost(dir), argms.getPort(dir), argms.getDb(dir), argms.getCol(dir));
					} catch (DataWriterException e) {
						throw new DataIOException(
								"Could not create a mongodb writer given those arguments");
					}
				}
			} else {
				throw new DataIOException(
						"Though inmode was 'mongodb' I could not parse the host, port, db or col arguments");
			}
		} else if (MODE_STD.equals(argms.getMode(dir))) {
			if (dir.equals(ServiceIOArguments.Direction.DIRECTION_IN))
				return new StreamDataGetter(System.in);
			else
				return new DataWriterToStdOut();
		} else if (isFileMode(argms, dir)) {
			if (argms.getFile(dir) != null) {

				if (dir.equals(ServiceIOArguments.Direction.DIRECTION_IN)) {
					
					if(MODE_HEMNETFILE.equals(argms.getMode(dir))){
						try {
							return new HemnetDataParsingFileGetter(argms.getFile(dir));
						} catch (IOException e) {
							throw new DataIOException(
							"Though inmode was 'hemnetfile' I could not use the file argument to create a getter", e);
						}
					}
					
					try {
						return new JSonStringFileDataGetter(argms.getFile(dir));
					} catch (IOException e) {
						throw new DataIOException(
								"Though inmode was 'infile' I could not use the file argument to create a getter", e);
					}
				} else {
					try {
						return new DataWriterToFile(argms.getFile(dir));
					} catch (IOException e) {
						throw new DataIOException(
								"Though inmode was 'infile' I could not use the file argument to create a writer", e);
					}
				}
			} else {
				throw new DataIOException(
						"Though inmode was 'infile' I could not parse the file argument");
			}
		} else {
			throw new DataIOException(
					"No valid data getter could be created from those arguments");
		}
	}

	private boolean isFileMode(ServiceIOArguments argms,
			ServiceIOArguments.Direction dir) {
		return MODE_FILE.equals(argms.getMode(dir)) || MODE_HEMNETFILE.equals(argms.getMode(dir));
	}

}
