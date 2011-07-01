package se.orbilius.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface HousePriceInfoServiceAsync {
  void getHousePriceInfo(String collections, String maxPrice, AsyncCallback<String> callback)
      throws IllegalArgumentException;
}
