package se.orbilius.analyzer;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class MediaPricePerSquareMeterAnalyzer extends MediumPriceAnalyzer {

	
	public double analyze(HousePriceInfoBatch batch) {

		double count = batch.getInfoList().size();
		if(count == 0){
			throw new IllegalArgumentException("Batch contained no house price infos");
		}

		
		batch.getInfoList().size();
		
		int mitten = 		batch.getInfoList().size() / 2;
		
		HousePriceInfo info = batch.getInfoList().get(mitten);
		double medianValue = (double) info.getStartPrice();
		
		return medianValue;
	}

}
