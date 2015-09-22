package com.app.gwtchartproject.client;
/*
This module describe the entrypoint of the application,
here the application is added to the RootPanel after call
*/

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTChartProject implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */


	/**
	 * This is the entry point method.
	 */


	public void onModuleLoad() {
		final ChartParamUI cpDisplayedChartParamUI = new ChartParamUI();
		RootPanel.get().add(cpDisplayedChartParamUI);

	}
}
