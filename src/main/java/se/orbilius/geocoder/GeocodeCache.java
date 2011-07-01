package se.orbilius.geocoder;
/*
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
*/
public class GeocodeCache {
/*
	public Location get(String address) {
		Location loc = Location.NO_LOCATION;
		int myRefreshPeriod = 1000;
		
		GeneralCacheAdministrator admin = new GeneralCacheAdministrator();
		
		try {
			// Get from the cache
			loc = (Location) admin.getFromCache(address, myRefreshPeriod);
		} catch (NeedsRefreshException nre) {
			try {
				// Get the value (probably from the database)
				//loc = "This is the content retrieved.";
				// Store in the cache
				admin.putInCache(address, loc);
			} catch (Exception ex) {
				// We have the current content if we want fail-over.
				loc = (Location) nre.getCacheContent();
				// It is essential that cancelUpdate is called if the
				// cached content is not rebuilt
				admin.cancelUpdate(address);
			}
		}
		return loc;
	}
*/
}
