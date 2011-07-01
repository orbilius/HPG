package se.orbilius.client.drawer;

public class DrawerUtil {
	
	public  static String hexColor(int part, int full){
		int R=(255 * part)/full;
		int G=(255 * (full-part))/full; ;
		int B=0;
		
		String hR = pad(Integer.toHexString(R));
		String hG = pad(Integer.toHexString(G));
		String hB = "00";

		System.out.println(part + " is " + hR + hG + hB);
		
		return hR + hG + hB;
	}
	
	public  static String hexColor(int percentage){
		return hexColor(percentage, 100);
	}
	private static String pad(String hexString) {
		
		if(hexString.length() == 1){
			hexString = "0" + hexString;
		}
		return hexString;
	}
}
