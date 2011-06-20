package se.orbilius.datawriter;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.util.Command;

public class BreakChainIfNoStartPriceCommand implements Command {

	@Override
	public boolean execute(HousePriceInfo info) {
		return info.getStartPrice() > 0;
	}

	@Override
	public String getErrorMessage() {
		return "Start price was not > 0";
	}
}
