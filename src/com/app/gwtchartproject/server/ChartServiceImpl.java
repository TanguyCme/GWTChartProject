package com.app.gwtchartproject.server;

import com.app.gwtchartproject.client.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class ChartServiceImpl extends RemoteServiceServlet implements ChartService{
  public String generateChart(){
    return "toto";
  }
}
