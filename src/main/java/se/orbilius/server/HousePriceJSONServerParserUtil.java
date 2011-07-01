package se.orbilius.server;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;
import se.orbilius.shared.HousePriceJSONUtil;
import se.orbilius.util.HousePriceUtil;

public class HousePriceJSONServerParserUtil implements HousePriceJSONUtil {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * se.orbilius.server.HousePriceJSONUtil#housePriceToJSONString(se.orbilius
	 * .shared.HousePriceInfo)
	 */
	@SuppressWarnings("unchecked")
	public String housePriceToJSONString(HousePriceInfo info) {
		JSONObject json = new JSONObject();
		json.put(HousePriceInfo.ID, info.getId());		
		json.put(HousePriceInfo.ADDRESS, info.getAddress());
		json.put(HousePriceInfo.HOOD, info.getHood());
		json.put(HousePriceInfo.START_PRICE, info.getStartPrice());
		json.put(HousePriceInfo.SQUARE_METERS, info.getSquareMeters());
		json.put(HousePriceInfo.MONTHLY_FEE, info.getMonthlyFee());
		json.put(HousePriceInfo.URL, info.getUrl());
		
		if(info.getSavedDate() != null){
			json.put(HousePriceInfo.SAVED_DATE, HousePriceUtil.getDateFormat().format(info.getSavedDate()));
		}
		if(info.getLat() != 0d){
			json.put(HousePriceInfo.LAT, info.getLat());
		}

		if(info.getLon() != 0d){
			json.put(HousePriceInfo.LON, info.getLon());
		}
		
		return json.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * se.orbilius.server.HousePriceJSONUtil#parseHousePriceJson(java.lang.String
	 * )
	 */
	public HousePriceInfo parseHousePriceJson(String string) {

		try {
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(string);

			HousePriceInfo hpi = new HousePriceInfo();
			hpi.setId(((String)json.get(HousePriceInfo.ID)));
			hpi.setAddress((String) json.get(HousePriceInfo.ADDRESS));
			hpi.setHood((String) json.get(HousePriceInfo.HOOD));
			hpi.setStartPrice(((Long) json.get(HousePriceInfo.START_PRICE)).longValue());
			hpi.setSquareMeters(((Long) json.get(HousePriceInfo.SQUARE_METERS))
							.intValue());
			
			if(json.get(HousePriceInfo.LAT) != null){
				hpi.setLat(((Double) json.get(HousePriceInfo.LAT)).doubleValue());				
			}

			if(json.get(HousePriceInfo.LON) != null){
				hpi.setLon(((Double) json.get(HousePriceInfo.LON)).doubleValue());			
			}			
			
			if(json.get(HousePriceInfo.MONTHLY_FEE) != null){
				hpi.setMonthlyFee(((Long) json.get(HousePriceInfo.MONTHLY_FEE)).intValue());
			}
			hpi.setUrl((String) json.get(HousePriceInfo.URL));
			return hpi;
		} catch (ParseException e) {
			System.out.println("Parse exception:" + e.getMessage());
			e.printStackTrace();
			return null;
		} catch (Exception e){
			throw new IllegalArgumentException("Failed to parse string " + string, e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * se.orbilius.server.HousePriceJSONUtil#housePriceBatchToJSONString(se.
	 * orbilius.shared.HousePriceInfoBatch)
	 */
	@SuppressWarnings("unchecked")
	public String housePriceBatchToJSONString(HousePriceInfoBatch batch) {
		JSONObject o = new JSONObject();

		JSONArray a = new JSONArray();
		for (HousePriceInfo info : batch.getInfoList()) {
			String jsonString = housePriceToJSONString(info);
			a.add(jsonString);
		}

		o.put("infoList", a);
		return o.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * se.orbilius.server.HousePriceJSONUtil#parseHousePriceBatch(java.lang.
	 * String)
	 */
	public HousePriceInfoBatch parseHousePriceBatch(String jsonString) {
		try {

			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(jsonString);
			JSONArray a = (JSONArray) obj.get("infoList");
			HousePriceInfoBatch batch = new HousePriceInfoBatch();
			for (Iterator iter = a.iterator(); iter.hasNext();) {
				Object o = iter.next();
				HousePriceInfo info = parseHousePriceJson((String) o);
				batch.addInfo(info);
			}
			return batch;
		} catch (ParseException e) {
			System.out.println("Parse exception:" + e.getMessage());

			return null;
		}
	}
}
