package se.orbilius.service;

import java.io.IOException;

import se.orbilius.datagetter.DataGetter;
import se.orbilius.datagetter.DataGetterException;
import se.orbilius.dataio.DataIOFactory;
import se.orbilius.datawriter.DataWriter;
import se.orbilius.datawriter.DataWriterException;
import se.orbilius.datawriter.DataWriterToFile;
import se.orbilius.shared.HousePriceInfoBatch;

public class ServiceRunner {
	
	public static void main(String [] args){

	try {
		ServiceIOArguments argums = ServiceIOArguments.parse(args);
		DataIOFactory ioFact = new DataIOFactory();
		DataGetter getter = ioFact.getGetter(argums);
		Service service = new ServiceFactory().getService(argums);
		DataWriter writer = ioFact.getWriter(argums);
		
		HousePriceInfoBatch batch = getter.getBatch();
		service.serve(batch, argums);
		writer.writeData(batch);
		
		DataWriter logWriter = new DataWriterToFile(argums.log);
		logWriter.writeData(batch);
		
	} catch (DataGetterException e) {
		e.printStackTrace();
	} catch (DataWriterException e) {
		e.printStackTrace();
	} catch (NoSuchServiceException e) {
		e.printStackTrace();
	} catch (ServiceException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
