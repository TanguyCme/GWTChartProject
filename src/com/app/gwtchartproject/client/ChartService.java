package com.app.gwtchartproject.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("generate")
public interface ChartService extends RemoteService{
  String generateChart() throws IllegalArgumentException;
}
