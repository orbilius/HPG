package se.orbilius.datawriter;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.util.Command;

public class BreakChainIfAlreadyExists implements Command {

	@Override
	public boolean execute(HousePriceInfo info) {
		return false;
	}

	@Override
	public String getErrorMessage() {
		return "An object with this id already exists in the collection";
	}

}
