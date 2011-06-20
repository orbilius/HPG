package se.orbilius.client.drawer;

import se.orbilius.shared.HousePriceInfoBatch;
import se.orbilius.shared.HousePriceInfo;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Panel;

public class SimplePriceInfoDrawer implements HousePrinceInfoDrawer {

	@Override
	public void draw(Panel panel, HousePriceInfoBatch batch, String method) {
	    Grid g = new Grid(batch.getInfoList().size() + 1, 5);
        g.setText(0, 0, "Address");
        g.setText(0, 1, "Start price");
        g.setText(0, 2, "Square meters");
        
	    // Put some values in the grid cells.
	    for (int row = 0; row < batch.getInfoList().size(); ++row) {
	    	HousePriceInfo info = batch.getInfoList().get(row);
	        g.setText(row + 1, 0, info.getAddress());
	        g.setText(row + 1, 1, Long.toString(info.getStartPrice()));
	        g.setText(row + 1, 2, Integer.toString(info.getSquareMeters()));
	        
	    }

	    g.getCellFormatter().setWidth(0, 2, "256px");
	    panel.add(g);
	}
}
