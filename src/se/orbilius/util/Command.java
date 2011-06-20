package se.orbilius.util;

import se.orbilius.shared.HousePriceInfo;

public interface Command {
	
	public boolean execute(HousePriceInfo info);

	  String getErrorMessage();
	
}
