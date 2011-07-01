package se.orbilius.client;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;
import se.orbilius.shared.HousePriceJSONUtil;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class HousePriceJSONClientParserUtil implements HousePriceJSONUtil {

	@Override
	public String housePriceBatchToJSONString(HousePriceInfoBatch batch) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String housePriceToJSONString(HousePriceInfo info) {
		throw new UnsupportedOperationException();
	}
	
	

	@Override
	public HousePriceInfoBatch parseHousePriceBatch(String jsonString) {
		
		HousePriceInfoBatch batch = new HousePriceInfoBatch();
		JSONObject object = JSONParser.parse(jsonString).isObject();

		JSONValue o = object.get("infoList");
		JSONArray array = o.isArray();

		for(int i = 0; i < array.size(); i++){
			HousePriceInfo info = parseHousePriceJson(array.get(i).toString());
			batch.addInfo(info);
		}

		return batch;
	}

	@Override
	public HousePriceInfo parseHousePriceJson(String jsonString) {
		HousePriceInfo info = new HousePriceInfo();
		JSONValue val = JSONParser.parse(jsonString);
		JSONValue val2 = JSONParser.parse(val.isString().stringValue());
		
		JSONObject obj = val2.isObject();
		info.setId(obj.get(HousePriceInfo.ID).isString().stringValue());
		info.setAddress(obj.get(HousePriceInfo.ADDRESS).isString().stringValue());
		info.setHood(obj.get(HousePriceInfo.HOOD).isString().stringValue());
		info.setSquareMeters((int) obj.get(HousePriceInfo.SQUARE_METERS).isNumber().doubleValue());
		info.setStartPrice((long) obj.get(HousePriceInfo.START_PRICE).isNumber().doubleValue());
		info.setMonthlyFee((int) obj.get(HousePriceInfo.MONTHLY_FEE).isNumber().doubleValue());
		info.setUrl(obj.get(HousePriceInfo.URL).isString().stringValue());
		
		if(obj.get(HousePriceInfo.LAT) != null){
			info.setLat(obj.get(HousePriceInfo.LAT).isNumber().doubleValue());
		}
		
		if(obj.get(HousePriceInfo.LON) != null){
			info.setLon(obj.get(HousePriceInfo.LON).isNumber().doubleValue());
		}
		
		return info;
	}
}
