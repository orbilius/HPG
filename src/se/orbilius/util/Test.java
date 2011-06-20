package se.orbilius.util;

import java.io.File;
import java.io.IOException;

import se.orbilius.datagetter.DataGetter;
import se.orbilius.datagetter.DataGetterException;
import se.orbilius.datagetter.DataGetterFromFile;
import se.orbilius.datawriter.DataWriter;
import se.orbilius.datawriter.DataWriterException;
import se.orbilius.datawriter.DataWriterToStdOut;
import se.orbilius.shared.HousePriceInfoBatch;

/**
 * Reads HousePriceInfo's as JSON strings from a file, specified on the command line
 * Outputs a new file with the same HousePriceInfo's geocoded after their address, also in JSON format.
*
 * @author david
 *
 */

public class Test {

	public static void main(String[] args){

		
		String inFile = args[0];
		
		File inF = new File(inFile);

		if(!inF.exists()){
			throw new IllegalArgumentException(inFile + " did not exist");
		}
		
		try {
			DataGetter getter = new DataGetterFromFile(inFile);
			DataWriter writer = new DataWriterToStdOut();
			HousePriceInfoBatch batch = getter.getLatestBatch();
			
			writer.writeData(batch);
			
			
		} catch (DataGetterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataWriterException e) {
			e.printStackTrace();
		}
	}	
}
