package se.orbilius.service;

import se.orbilius.datagetter.DataGetterException;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(DataGetterException e) {
		super(e);
	}

	public ServiceException(String string) {
		super(string);
	}

}
