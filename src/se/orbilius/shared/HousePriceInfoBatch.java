package se.orbilius.shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HousePriceInfoBatch {
	
	public final static int NO_MAX_PRICE = -1;
	private List<HousePriceInfo> infoList = new ArrayList<HousePriceInfo>();
	
	public List<HousePriceInfo> getInfoList() {
		return infoList;
	}
	
	public void merge(HousePriceInfoBatch batch){
		infoList.addAll(batch.getInfoList());
	}
	
	public void addInfo(HousePriceInfo info){
		infoList.add(info);
	}
	
	public void setInfoList(List<HousePriceInfo> infoList) {
		this.infoList = infoList;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for (HousePriceInfo info : infoList) {
			sb.append(info.toString());
			sb.append("\r\n");
		}
		return sb.toString();
	}
}
