package se.orbilius;

import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

public class HousePriceInfoTestUtil {

	public static final String TEST_ADDRESS = "Testadress 1";
	public static final double TEST_LAT = 2.2d;
	public static final double TEST_LON = 1.1d;
	
	public static HousePriceInfo getTestHousePriceInfo() {
		HousePriceInfo info = new HousePriceInfo();
		info.setAddress(TEST_ADDRESS);
		info.setLat(TEST_LAT);
		info.setLon(TEST_LON);
		info.setStartPrice(1000000);
		info.setSquareMeters(200);
		info.setUrl("http://www.hemnet.se");
		return info;
	}

	public static HousePriceInfoBatch getTestBatch() {
		HousePriceInfoBatch batch = new HousePriceInfoBatch();
		batch.addInfo(new HousePriceInfo("Torgnyv�gen 4, Bromma, Sweden", 3000000, 100));
		batch.addInfo(new HousePriceInfo("K�glestigen 4, Bromma, Sweden", 3200000, 200));
		batch.addInfo(new HousePriceInfo("Alstr�mmergatan 22, Stockholm, Sweden", 5000000, 300));
		 batch.addInfo(new HousePriceInfo("Flyttblocksv�gen 10, Bromma - Marieh�ll",  4795000, 151));
		 batch.addInfo(new HousePriceInfo("Gamla Bromstensv�gen 37, B�llsta",3300000, 88 ));
		 batch.addInfo(new HousePriceInfo("Edebyv�gen 51, Eker� Drottningholm",9500000, 180 ));
		 batch.addInfo(new HousePriceInfo("Carl Barks V�g 13K, Sp�nga Bromsten" ,2695000, 121 ));
		 batch.addInfo(new HousePriceInfo("B�tsman Stens v�g 51C, Sp�nga - Bromsten",3175000, 104 ));
		 batch.addInfo(new HousePriceInfo("V�stra Johannelund - Hus 13, V�llingby - Vinsta",3350000, 105 ));
		 batch.addInfo(new HousePriceInfo("V�stra Johannelund - Hus 1, V�llingby - Vinsta",3315000, 105 ));
		 batch.addInfo(new HousePriceInfo("Linjem�starv�gen 4-Toppklass!, N�lsta",5950000, 172 ));
		 batch.addInfo(new HousePriceInfo("V�stra Johannelund - Hus 6 (Bokad), V�llingby - Vinsta", 2750000, 105));
		 batch.addInfo(new HousePriceInfo("�broddsv�gen 53, H�sselby S�dra Villastad", 3850000,  152 ));
		
		return batch;
	}
}
