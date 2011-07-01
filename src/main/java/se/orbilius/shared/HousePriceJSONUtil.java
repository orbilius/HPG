package se.orbilius.shared;

public interface HousePriceJSONUtil {

	public abstract String housePriceToJSONString(HousePriceInfo info);

	public abstract HousePriceInfo parseHousePriceJson(String string);

	public abstract String housePriceBatchToJSONString(HousePriceInfoBatch batch);

	public abstract HousePriceInfoBatch parseHousePriceBatch(String jsonString);
	
}