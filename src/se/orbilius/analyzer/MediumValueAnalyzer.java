package se.orbilius.analyzer;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public abstract class MediumValueAnalyzer implements HouseAnalyzer {
	
	double max = -1d;
	
	/* (non-Javadoc)
	 * @see se.orbilius.analyzer.HouseAnalyzer#analyze(se.orbilius.shared.HousePriceInfoBatch)
	 */
	public double analyze(HousePriceInfoBatch batch) {

		double count = batch.getInfoList().size();
		if(count == 0){
			throw new IllegalArgumentException("Batch contained no house price infos");
		}

		double accumulatedValue = 0;
		
		for(HousePriceInfo info : batch.getInfoList()){
			if(getInfoValue(info) > max)
				max = getInfoValue(info);
			
			accumulatedValue = accumulatedValue + getInfoValue(info);
			System.out.println("ACCUM:" + accumulatedValue + "COUNT: " + count);
		}
		
		return accumulatedValue / count;
	}
	
	/* (non-Javadoc)
	 * @see se.orbilius.analyzer.HouseAnalyzer#getMax()
	 */
	public double getMax(){
		return max;
	}

	/* (non-Javadoc)
	 * @see se.orbilius.analyzer.HouseAnalyzer#getInfoValue(se.orbilius.shared.HousePriceInfo)
	 */
	public abstract double getInfoValue(HousePriceInfo info);

}
