package se.orbilius.datawriter;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.util.Command;

public class BreakChainIfNoSquareMetersCommand implements Command {

	@Override
	public boolean execute(HousePriceInfo info) {
		return info.getSquareMeters() > 0;
	}

	@Override
	public String getErrorMessage() {
		return "Square meters was not larger than 0";
	}

}
