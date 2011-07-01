package se.orbilius.datawriter;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.util.Command;

public class BreakChainIfNoAddressCommand implements Command {

	@Override
	public boolean execute(HousePriceInfo info) {
		return info.getAddress() != null && info.getAddress().length() > 0;
	}

	@Override
	public String getErrorMessage() {
		return "Address was either null or empty";
	}


}
