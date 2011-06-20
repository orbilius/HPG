package se.orbilius.client;

//import se.orbilius.shared.HousePriceInfoBatch;

import se.orbilius.analyzer.HouseAnalyzerFactory;
import se.orbilius.client.drawer.MapDrawer;
import se.orbilius.client.drawer.SimplePriceInfoDrawer;
import se.orbilius.shared.HousePriceInfoBatch;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class HousePriceInfoGrapher implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final HousePriceInfoServiceAsync housePriceInfoService = GWT
			.create(HousePriceInfoService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button("Send");
		final TextBox searchField = new TextBox();
		final TextBox maxPrice = new TextBox();
		final com.google.gwt.user.client.ui.ListBox box = new ListBox();
		box.addItem("Medium price", HouseAnalyzerFactory.MEDIUM_PRICE_ANALYZER);
		box.addItem("Medium price per squaremeter", HouseAnalyzerFactory.MEDIUM_PRICE_PER_SQUARE_METER_ANALYZER);
		searchField.setText("Data Collection");
		maxPrice.setText("Max price");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(searchField);
		RootPanel.get("nameFieldContainer").add(maxPrice);
		//RootPanel.get("nameFieldContainer").add(method);
		RootPanel.get("nameFieldContainer").add(box);

		
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		searchField.setFocus(true);
		searchField.selectAll();

		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		final VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);

		RootPanel.get("nameFieldContainer").add(dialogVPanel);

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				getHousePriceInfo();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					getHousePriceInfo();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void getHousePriceInfo() {
				// First, we validate the input.
				errorLabel.setText("");
				String collections = searchField.getText();
				String maxPriceText = maxPrice.getText();
				//final String m = method.getText();
				int index = box.getSelectedIndex();
				final String m = box.getValue(index);
				textToServerLabel.setText(collections);
				serverResponseLabel.setText("");
				housePriceInfoService.getHousePriceInfo(collections, maxPriceText,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogVPanel.add(new HTML(
										"Remote Procedure Call - Failure"));
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
							}

							public void onSuccess(String result) {
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								//serverResponseLabel.setHTML(result);

								try {
									HousePriceInfoBatch batch = new HousePriceJSONClientParserUtil().parseHousePriceBatch(result);
									new
									MapDrawer().draw(dialogVPanel,
									batch, m);
								} catch (Exception e) {
									serverResponseLabel
											.addStyleName("serverResponseLabelError");
									serverResponseLabel
											.setHTML("Failed to parse server response: "
													+ e.getMessage());
									System.out.println(e);
								}

								sendButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		searchField.addKeyUpHandler(handler);
	}
}
