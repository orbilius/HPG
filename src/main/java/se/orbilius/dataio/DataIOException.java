package se.orbilius.dataio;

import java.io.IOException;

public class DataIOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataIOException(String string) {
		super(string);
	}

	public DataIOException(String string, IOException e) {
		super(string, e);
	}

}
