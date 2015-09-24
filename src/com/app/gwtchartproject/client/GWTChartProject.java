package com.app.gwtchartproject.client;
/*
This module describe the entrypoint of the application,
here the application is added to the RootPanel after call
*/

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTChartProject implements EntryPoint {



	public void onModuleLoad() {
		final ChartParamUI cpUI = new ChartParamUI();
		final ChartDisplayer cdHist = new ChartDisplayer("toto");
		FlowPanel fp = new FlowPanel();

		fp.add(cpUI.getContentPanel());
		// fp.add(cdHist.getContentPanel());
		// RootPanel.get().add(new ChartParamUI());
		RootPanel.get().add(fp);

	}
}
