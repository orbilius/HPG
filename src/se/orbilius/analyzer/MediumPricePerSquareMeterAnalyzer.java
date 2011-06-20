package se.orbilius.analyzer;

import se.orbilius.shared.HousePriceInfo;

public class MediumPricePerSquareMeterAnalyzer extends MediumValueAnalyzer{

	@Override
	public double getInfoValue(HousePriceInfo info) {
		return (double) info.getStartPrice() / (double) info.getSquareMeters();
	}
}
