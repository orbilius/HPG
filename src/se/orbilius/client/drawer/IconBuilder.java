package se.orbilius.client.drawer;

import com.google.gwt.maps.client.geom.Point;
import com.google.gwt.maps.client.geom.Size;
import com.google.gwt.maps.client.overlay.Icon;

public class IconBuilder {
	//private static final String BASE_URL = "http://chart.apis.google.com/chart?cht=mm";
	private static final String BASE_URL = "http://chart.apis.google.com/chart?cht=v&chd=t:100&chf=bg,s,65432100";
	private int width = 32;
	private int height = 32;
	private String primaryColor = "ff0000";
	private String strokeColor = "000000";
	private String cornerColor = "ffffff";

	public IconBuilder width(int width) {
		this.width = width;
		return this;
	}

	public IconBuilder height(int height) {
		this.height = height;
		return this;
	}

	public IconBuilder primaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
		return this;
	}

	public IconBuilder strokeColor(String strokeColor) {
		this.strokeColor = strokeColor;
		return this;
	}

	public IconBuilder cornerColor(String cornerColor) {
		this.cornerColor = cornerColor;
		return this;
	}

	public Icon build() {
		
		String iconBase = BASE_URL + "&chs=" + width + "x" + height + "&chco="
				+ cornerColor + "," + primaryColor + "," + strokeColor;
		String iconUrl = iconBase + "&ext=.png";
		Icon icon = Icon.newInstance(Icon.getDefaultIcon());
		icon.setImageURL(iconUrl);
		icon.setIconSize(Size.newInstance(width, height));
		icon.setShadowSize(Size.newInstance((int) Math.floor(width * 1.6),
				height));
		icon.setIconAnchor(Point.newInstance(width / 2, height));
		icon.setInfoWindowAnchor(Point.newInstance(width / 2, (int) Math
				.floor(height / 12)));
		icon.setPrintImageURL(iconUrl + "&chof=gif");

	//	icon.setMozPrintImageURL(iconUrl + "&chf=bg,s,ECECD8" + "&chof=gif");
		//icon.setTransparentImageURL(iconBase + "&chf=a,s,ffffff11&ext=.png");

			
		icon.setImageMap(new int[] { width / 2, height, 7 * width / 16,
				5 * height / 8, 5 * width / 16, 7 * height / 16,
				7 * width / 32, 5 * height / 16, 5 * width / 16, height / 8,
				width / 2, 0, 11 * width / 16, height / 8, 25 * width / 32,
				5 * height / 16, 11 * width / 16, 7 * height / 16,
				9 * width / 16, 5 * height / 8 });
		return icon;
	
	}
}
