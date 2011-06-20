package se.orbilius.analyzer;

import se.orbilius.shared.HousePriceInfo;

public class MediumPriceAnalyzer extends MediumValueAnalyzer{


	@Override
	public double getInfoValue(HousePriceInfo info) {
		return info.getStartPrice();
	}
}
