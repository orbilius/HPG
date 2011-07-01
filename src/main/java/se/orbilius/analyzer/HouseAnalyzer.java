package se.orbilius.analyzer;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public interface HouseAnalyzer {

	public abstract double analyze(HousePriceInfoBatch batch);

	public abstract double getMax();

	public abstract double getInfoValue(HousePriceInfo info);

}