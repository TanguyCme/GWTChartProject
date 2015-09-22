package com.3dcounting.client;

/*
This Module named ChartParam.java will describe a model wich will design a special chart
5 Arguments will be needed to create a ChartParam Object :
	- sBeginDate : String, Format "YYYY-MM-DD"
	- sBeginTime : String, Format "HH:MM:SS"
	- sEndDate : String, Format "YYYY-MM-DD"
	- sEndTime : String, Format "HH:MM:SS"
	- eGranularity : Enum, (Year, Month, Week, Day, Hour, Minute)
 Refer to the following description to instanciate ChartParam Objects.
*/

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.datepicker.client.DatePicker;
import java.util.Date;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.visualization.client.*;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.VisualizationUtils;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.AbstractDataTable.ColumnType;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.visualizations.ColumnChart;
import com.google.gwt.visualization.client.visualizations.ColumnChart.Options;


public class ChartParam {

	/**************************************
				   Attributes
	***************************************/

	//Begin time pickers
	private String _sBeginDate;
	private String _sBeginTime;

	//End time pickers
	private String _sEndDate;
	private String _sBeginTime;

	// //Granularity attribute
	// public Enum eGranularity {
	// 	YEAR, MONTH, WEEK, DAY, HOUR, MINUTE
	// };


	/**************************************
					Methods
	***************************************/

	/*
	Constructors
	*/
	public ChartParam(String sBeginDate, String sBeginTime, String sEndDate, String sEndTime, Enum eGranularity){
		this.setBeginDate(sBeginDate);
		this.setBeginTime(sBeginTime);
		this.setEndDate(sEndDate);
		this.setEndTime(sEndTime);
		this.setGranularity(eGranularity);
	}

	//*************Getters*************

	public String getBeginDate(){
		return this._sBeginDate;
	}

	public String getBeginTime(){
		return this._sBeginTime;
	}

	public String getEndDate(){
		return this._sEndDate;
	}

	public String getEndTime(){
		return this._sEndTime;
	}
	// public Enum getGranularity(){
	// 	return this.eGranularity;
	// }

	//*************Setters*************

	public void setBeginDate(String sBeginDate){
		this._sBeginDate = sBeginDate;
	}
	public void setBeginTime(String sBeginTime){
		this._sBeginTime = sBeginTime;
	}
	public void setEndDate(String sEndDate){
		this._sEndDate = sEndDate;
	}
	public void setEndTime(String sEndTime){
		this._sEndTime = sEndTime;
	}
	// public void setGranularity(Enum eGranularity){
	// 	this.eGranularity = eGranularity;
	// }
}
