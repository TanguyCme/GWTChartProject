package com.app.gwtchartproject.client;

/*
This module describe the chartdisplayer class wich extends widget tui suit in a Panel
You can display avery chart you need just in calling a new ChartDisplayer Object
Methods : - void: onLoad()
              -> instanciate a Runnable called in the loadVisualisation Function
              -> Verify if the panel is already instanciate
*/


import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.Component;

public class ChartDisplayer extends Widget{

  /***************************************
                Attributes
  ****************************************/
  private String _sName;
  public FlowPanel pane;




  /***************************************
                  Methods
  ****************************************/

  //Constructor
  public ChartDisplayer(){
    super();
    this.onLoad();
  }



  //Getters
  public FlowPanel getFlowPanel(){
    return this.pane;
  }

  public String getChartName(){
    return this._sName;
  }

  //Setters
  public void setChartName(String sName){
    this._sName = sName;
  }

  public void setFlowPanel(Widget widget){
    if(pane == null){
      pane = new FlowPanel();
    }
    getFlowPanel().add(widget);
  }






  //onLoad Method called when the ChartDisplayer
  //object is created
  public void onLoad(){
    Runnable onLoadCallback = new Runnable() {
      public void run() {
        Panel panel = RootPanel.get();
        // Create a hist chart visualization.
        ColumnChart hist = new ColumnChart(createTable(), createOptions());

        setFlowPanel(hist);
        panel.add(getFlowPanel());
      }
    };

    // Load the visualization api, passing the onLoadCallback to be called
    // when loading is done.
    VisualizationUtils.loadVisualizationApi(onLoadCallback, ColumnChart.PACKAGE);
  }






  //CreateOption creates options which will set the ColumnChart font
  private Options createOptions(){
    Options options = Options.create();
    options.setWidth(500);
    options.setHeight(300);
    options.set3D(true);
    options.setTitle("Student Brain Daily Activity");
    return options;
  }

  //CreateTable creates a data model wich will be used by the chartdisplayer to draw the chart
  private AbstractDataTable createTable() {
    DataTable data = DataTable.create();
    data.addColumn(ColumnType.STRING, "Task");
    data.addColumn(ColumnType.NUMBER, "%");
    data.addRows(24);
    data.setValue(0, 0, "00h");
    data.setValue(0, 1, 1);
    data.setValue(1, 0, "01h");
    data.setValue(1, 1, 1);
    data.setValue(2, 0, "02h");
    data.setValue(2, 1, 1);
    data.setValue(3, 0, "03h");
    data.setValue(3, 1, 2);
    data.setValue(4, 0, "04h");
    data.setValue(4, 1, 2);
    data.setValue(5, 0, "05h");
    data.setValue(5, 1, 2);
    data.setValue(6, 0, "06h");
    data.setValue(6, 1, 2);
    data.setValue(7, 0, "07h");
    data.setValue(7, 1, 10);
    data.setValue(8, 0, "08h");
    data.setValue(8, 1, 15);
    data.setValue(9, 0, "09h");
    data.setValue(9, 1, 20);
    data.setValue(10, 0, "10h");
    data.setValue(10, 1, 35);
    data.setValue(11, 0, "11h");
    data.setValue(11, 1, 40);
    data.setValue(12, 0, "12h");
    data.setValue(12, 1, 40);
    data.setValue(13, 0, "13h");
    data.setValue(13, 1, 25);
    data.setValue(14, 0, "14h");
    data.setValue(14, 1, 40);
    data.setValue(15, 0, "15h");
    data.setValue(15, 1, 40);
    data.setValue(16, 0, "16h");
    data.setValue(16, 1, 40);
    data.setValue(17, 0, "17h");
    data.setValue(17, 1, 35);
    data.setValue(18, 0, "18h");
    data.setValue(18, 1, 30);
    data.setValue(19, 0, "19h");
    data.setValue(19, 1, 25);
    data.setValue(20, 0, "20h");
    data.setValue(20, 1, 25);
    data.setValue(21, 0, "21h");
    data.setValue(21, 1, 25);
    data.setValue(22, 0, "22h");
    data.setValue(22, 1, 20);
    data.setValue(23, 0, "23h");
    data.setValue(23, 1, 1);
    return data;
  }


}
