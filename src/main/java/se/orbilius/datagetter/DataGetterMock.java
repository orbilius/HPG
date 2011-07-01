package se.orbilius.datagetter;

import java.util.ArrayList;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class DataGetterMock implements DataGetter {

	@Override
	public HousePriceInfoBatch getBatch() {

		ArrayList<HousePriceInfo> list = new ArrayList<HousePriceInfo>();

		list.add( new HousePriceInfo(
				"Torgnyv�gen 4, Bromma, Sweden", 3000000, 200));
		list.add( new HousePriceInfo(
				"K�glestigen 4, Bromma, Sweden", 3200000, 120));
		list.add( new HousePriceInfo(
				"Alstr�mmergatan 22, Stockholm, Sweden", 5000000, 420));
		list.add( new HousePriceInfo(
				"Molinv�gen 5, Bromma, Sweden", 3600000, 123));
		list.add( new HousePriceInfo(
				"Islandsv�gen 30, Bromma, Sweden", 3100000, 200));
		list.add( new HousePriceInfo(
				"Lusthusbacken 10, Bromma, Sweden", 3200000, 100));
		list.add( new HousePriceInfo(
				"T�rnrosv�gen 2, Bromma, Sweden", 22000000, 120));
		list.add( new HousePriceInfo(
				"Barrstigen 8, Bromma, Sweden", 21000000, 50));
		list.add( new HousePriceInfo(
				"Solleftegatan 40, Bromma, Sweden", 2200000, 120));
		
		
	  	 
		HousePriceInfoBatch batch = new HousePriceInfoBatch();
		batch.setInfoList(list);
		return batch;
	}
}
