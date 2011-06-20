package se.orbilius.analyzer;

public class HouseAnalyzerFactory {
	
	public static final String MEDIUM_PRICE_PER_SQUARE_METER_ANALYZER = "mppsma";
	public static final String MEDIUM_PRICE_ANALYZER = "mpa";
	

	public static HouseAnalyzer getHouseAnalyzer(String a){
		
		if(MEDIUM_PRICE_PER_SQUARE_METER_ANALYZER.equals(a)){
			return new MediumPricePerSquareMeterAnalyzer();
		} else if(MEDIUM_PRICE_ANALYZER.equals(a)){
			return new MediumPriceAnalyzer();
		}
		
		return new MediaPricePerSquareMeterAnalyzer();
		
	}

}
