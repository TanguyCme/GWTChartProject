package com.app.gwtchartproject.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChartServiceAsync{
  void generateChart(AsyncCallback<String> callback)
  throws IllegalArgumentException;
}
