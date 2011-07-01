package se.orbilius.datagetter;

import java.io.IOException;


public class DataGetterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7047111054566918733L;

	public DataGetterException(Exception e) {
		super(e);
	}

	public DataGetterException(String string) {
		super(string);
	}

	public DataGetterException(String string, IOException e) {
		super(string, e);
	}
}
