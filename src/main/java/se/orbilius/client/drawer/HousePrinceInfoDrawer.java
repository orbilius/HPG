package se.orbilius.client.drawer;

import se.orbilius.shared.HousePriceInfoBatch;

import com.google.gwt.user.client.ui.Panel;

public interface HousePrinceInfoDrawer {
	
	public void draw(Panel panel, HousePriceInfoBatch batch, String method);

}
