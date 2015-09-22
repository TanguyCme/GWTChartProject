package com.3dcounting.client;
/*
This Module named TimePicker.java Describe a time picker widget wich 
will contain 3 arguments : 
	- sHourSelected : String [0-23]
	- sMinuteSelected : String [0-59]
	- sTimePickerValue : String, Format "HH:MM:00"
The two arguments will be chosen by the user and automatically upload into 
the argument named sTimePickerValue;
*/

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;

public class TimePicker extends Widget {

	/**************************************
				   Attributes
	***************************************/
	private String _sHourSelected;
	private String _sMinuteSelected;
	private String _sTimePickerValue;

	/**************************************
				     Methods
	***************************************/

	/*
	Constructor
	*/
	public TimePicker(){
		super();
	}

	//*************Getters*************

	public String getSelectedHour(){
		return this._sHourSelected;
	} 

	public String getSelectedMinute(){
		return this._sMinuteSelected;
	}

	public getTimePickerValue(){
		return this._sTimePickerValue;
	}

	//*************Setters*************

	public void setSelectedHour(String sHourSelected){
		this._sHourSelected = sHourSelected;
	}

	public void setSelectedMinute(String sMinuteSelected){
		this._sMinuteSelected = sMinuteSelected;
	}

	public void setTimePickerValue(){
		this._sTimePickerValue = getSelectedHour() + ":" + getSelectedMinute() + ":00";
	}

	//Override Widget Methods
	@Override
	public void onLoad(){

		//Create the two needed Listboxs
		final ListBox lbHourSelector = new ListBox();
		final ListBox lbMinuteSelector = new ListBox();
		final Label lblHour = new Label("h");
		final Label lblMinute = new Label("min");

		//Implements the HourSelector
		lbHourSelector.addItem("00");
		lbHourSelector.addItem("01");
		lbHourSelector.addItem("02");
		lbHourSelector.addItem("03");
		lbHourSelector.addItem("04");
		lbHourSelector.addItem("05");
		lbHourSelector.addItem("06");
		lbHourSelector.addItem("07");
		lbHourSelector.addItem("08");
		lbHourSelector.addItem("09");
		lbHourSelector.addItem("10");
		lbHourSelector.addItem("11");
		lbHourSelector.addItem("12");
		lbHourSelector.addItem("13");
		lbHourSelector.addItem("14");
		lbHourSelector.addItem("15");
		lbHourSelector.addItem("16");
		lbHourSelector.addItem("17");
		lbHourSelector.addItem("18");
		lbHourSelector.addItem("19");
		lbHourSelector.addItem("20");
		lbHourSelector.addItem("21");
		lbHourSelector.addItem("22");
		lbHourSelector.addItem("23");

		//Define the number of elements
		lbHourSelector.setVisibleItemCount(24);

		//Implements the MinuteSelector
		lbMinuteSelector.addItem("00");
		lbMinuteSelector.addItem("01");
		lbMinuteSelector.addItem("02");
		lbMinuteSelector.addItem("03");
		lbMinuteSelector.addItem("04");
		lbMinuteSelector.addItem("05");
		lbMinuteSelector.addItem("06");
		lbMinuteSelector.addItem("07");
		lbMinuteSelector.addItem("08");
		lbMinuteSelector.addItem("09");
		lbMinuteSelector.addItem("10");
		lbMinuteSelector.addItem("11");
		lbMinuteSelector.addItem("12");
		lbMinuteSelector.addItem("13");
		lbMinuteSelector.addItem("14");
		lbMinuteSelector.addItem("15");
		lbMinuteSelector.addItem("16");
		lbMinuteSelector.addItem("17");
		lbMinuteSelector.addItem("18");
		lbMinuteSelector.addItem("19");
		lbMinuteSelector.addItem("20");
		lbMinuteSelector.addItem("21");
		lbMinuteSelector.addItem("22");
		lbMinuteSelector.addItem("23");
		lbMinuteSelector.addItem("24");
		lbMinuteSelector.addItem("25");
		lbMinuteSelector.addItem("26");
		lbMinuteSelector.addItem("27");
		lbMinuteSelector.addItem("28");
		lbMinuteSelector.addItem("29");
		lbMinuteSelector.addItem("30");
		lbMinuteSelector.addItem("31");
		lbMinuteSelector.addItem("32");
		lbMinuteSelector.addItem("33");
		lbMinuteSelector.addItem("34");
		lbMinuteSelector.addItem("35");
		lbMinuteSelector.addItem("36");
		lbMinuteSelector.addItem("37");
		lbMinuteSelector.addItem("38");
		lbMinuteSelector.addItem("39");
		lbMinuteSelector.addItem("40");
		lbMinuteSelector.addItem("41");
		lbMinuteSelector.addItem("42");
		lbMinuteSelector.addItem("43");
		lbMinuteSelector.addItem("44");
		lbMinuteSelector.addItem("45");
		lbMinuteSelector.addItem("46");
		lbMinuteSelector.addItem("47");
		lbMinuteSelector.addItem("48");
		lbMinuteSelector.addItem("49");
		lbMinuteSelector.addItem("50");
		lbMinuteSelector.addItem("51");
		lbMinuteSelector.addItem("52");
		lbMinuteSelector.addItem("53");
		lbMinuteSelector.addItem("54");
		lbMinuteSelector.addItem("55");
		lbMinuteSelector.addItem("56");
		lbMinuteSelector.addItem("57");
		lbMinuteSelector.addItem("58");
		lbMinuteSelector.addItem("59");

		//Define the number of elements
		lbMinuteSelector.setVisibleItemCount(60);

		//Add the pickers and labels to the RootPanel
		RootPanel.get().add(lbHourSelector);
		RootPanel.get().add(lblHour);
		RootPanel.get().add(lbMinuteSelector);
		RootPanel.get().add(lblMinute);

		//Create change Value Handlers to notify a lisbox change
		lbHourSelector.addChangeHandler(new ChangeHandler<String>(){
			public void onChange(ChangeHandler<String> event) {
				setSelectedHour(event.getSelectedValue());
				setTimePickerValue();
			}
		});

		lbMinuteSelector.addChangeHandler(new ChangeHandler<String>(){
			public void onChange(ChangeHandler<String> event) {
				getSelectedMinute(event.getSelectedValue());
				setTimePickerValue();
			}
		});
	}



}




				