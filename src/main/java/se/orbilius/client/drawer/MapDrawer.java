package se.orbilius.client.drawer;

import se.orbilius.analyzer.HouseAnalyzer;
import se.orbilius.analyzer.HouseAnalyzerFactory;
import se.orbilius.shared.HousePriceInfo;
import se.orbilius.shared.HousePriceInfoBatch;

import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.event.MarkerClickHandler;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Icon;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.maps.client.overlay.MarkerOptions;
import com.google.gwt.maps.client.overlay.Overlay;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

public class MapDrawer implements HousePrinceInfoDrawer {

	private MapWidget map;

	@Override
	public void draw(Panel panel, HousePriceInfoBatch batch, String method) {

		LatLng stockholm = LatLng.newInstance(59.3327881, 18.0644881);
		map = new MapWidget(stockholm, 10);
		map.setSize("1000px", "600px");

		map.addControl(new LargeMapControl());
		HouseAnalyzer analyzer = HouseAnalyzerFactory.getHouseAnalyzer(method);
		double medium = analyzer.analyze(batch);
		double max = analyzer.getMax();

		for (HousePriceInfo info : batch.getInfoList()) {

			double result = analyzer.getInfoValue(info);
			int percentage = 0;
			percentage = (int) Math.round(result / medium * 100.0);

			LatLng point = LatLng.newInstance(info.getLat(), info.getLon());

			LatLng cawkerCity = point;
			// Add a marker
			map.addOverlay(createMarker(cawkerCity, info, result, max));

		}
		panel.add(map);
	}

	private Overlay createMarker(final LatLng latLng,
			final HousePriceInfo info, double result, double max) {
		IconBuilder builder = new IconBuilder();
		String color = DrawerUtil.hexColor((int) result, (int) max);
		Icon icon = builder.primaryColor(color).strokeColor(color).cornerColor(
				color).width(10).height(10).build();
		MarkerOptions ops = MarkerOptions.newInstance(icon);
		ops.setIcon(icon);
		ops.setTitle(info.getAddress() + ", " + info.getStartPrice() + " kr"
				+ ", " + info.getSquareMeters() + " m2");

		ops.setClickable(true);
		Marker marker = new Marker(latLng, ops);
		marker.addMarkerClickHandler(new MarkerClickHandler() {

			@Override
			public void onClick(MarkerClickEvent event) {

				String url = "http://www.hemnet.se" + info.getUrl().replaceAll("\\\\", "");
			
				System.out.println("URL: " + url);

				Window.open(url, info.getAddress(), "");
/*
					map.getInfoWindow().open(
							latLng,
							new InfoWindowContent(content));
*/
				System.out.println("DU KLICKADE: " + info.getUrl());
			}

		});
		System.out.println("DONE!");
		return marker;

	}

	/*
	 * class MyLatLngCallBack implements LatLngCallback {
	 * 
	 * HousePriceInfo info = null; int percentage; private double max; private
	 * double result; MyLatLngCallBack(HousePriceInfo info, int percentage,
	 * double max, double result) { this.info = info; this.percentage =
	 * percentage; this.max = max; this.result = result; }
	 * 
	 * @Override public void onFailure() { System.out.println("FAILUER!"); }
	 * 
	 * @Override public void onSuccess(LatLng point) {
	 * System.out.println("A POINT AT " + point.getLatitude() + " " +
	 * point.getLongitude()); LatLng cawkerCity = point; // Add a marker
	 * map.addOverlay(createMarker(cawkerCity)); }
	 * 
	 * private Overlay createMarker(final LatLng latLng) { IconBuilder builder =
	 * new IconBuilder(); System.out.println("INFO: " + info); String color =
	 * DrawerUtil.hexColor((int) result, (int) max); Icon icon =
	 * builder.primaryColor
	 * (color).strokeColor(color).cornerColor(color).width(10
	 * ).height(10).build(); MarkerOptions ops =
	 * MarkerOptions.newInstance(icon); ops.setIcon(icon);
	 * 
	 * ops.setClickable(true); Marker marker = new Marker(latLng, ops);
	 * marker.addMarkerClickHandler(new MarkerClickHandler(){
	 * 
	 * @Override public void onClick(MarkerClickEvent event) {
	 * Window.alert("DU KLICKADE: " + info.getUrl());
	 * 
	 * map.getInfoWindow().open( latLng, new InfoWindowContent("DU KLICKADE: " +
	 * info.getUrl()));
	 * 
	 * 
	 * System.out.println("DU KLICKADE: " + info.getUrl()); }
	 * 
	 * }); System.out.println("DONE!"); return marker;
	 * 
	 * } }
	 */
}
