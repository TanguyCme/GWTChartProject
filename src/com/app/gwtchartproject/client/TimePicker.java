package com.app.gwtchartproject.client;

/*
This Module named TimePicker.java Describe a time picker widget wich
will contain 3 arguments :
	- sHourSelected : String [0-23]
	- sMinuteSelected : String [0-59]
	- sTimePickerValue : String, Format "HH:MM:00"
The two arguments will be chosen by the user and automatically upload into
the argument named sTimePickerValue
*/

import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.Component;

public class TimePicker extends Widget {

	/**************************************
				   Attributes
	***************************************/
	private String _sHourSelected;
	private String _sMinuteSelected;
	private String _sTimePickerValue;
	private String _sTimePickerName;

	/**************************************
				     Methods
	***************************************/

	/*
	Constructor
	*/
	public TimePicker(String sName){
		super();
		this._sTimePickerName = sName;
    this.onLoad();
	}

	//*************Getters*************

	public String getSelectedHour(){
		return this._sHourSelected;
	}

	public String getSelectedMinute(){
		return this._sMinuteSelected;
	}

	public String getTimePickerValue(){
		return this._sTimePickerValue;
	}
	public String getTimePickerName(){
		return this._sTimePickerName;
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

	public void setTimePickerName(String sName){
		this._sTimePickerName = sName;
	}

	//Override Widget Methods
	@Override
	public void onLoad(){

		//Create the two needed Listboxs
		final ListBox lbHourSelector = new ListBox();
		final ListBox lbMinuteSelector = new ListBox();
		final Label lblHour = new Label("h");
		final Label lblMinute = new Label("min");
		final Label lblName = new Label(this.getTimePickerName());

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
		lbHourSelector.setVisibleItemCount(1);

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
		lbMinuteSelector.setVisibleItemCount(1);

		/*
		This bloc defines th UI, set the Component Draggable
		and defines width of the contentpanel
		*/
		//1st one HorizontalPanel which horizontally plces the elements
		HorizontalPanel hpContainer = new HorizontalPanel();
		VerticalPanel vpContainer = new VerticalPanel();
		vpContainer.add(lblName);
		hpContainer.add(lbHourSelector);
		hpContainer.add(lblHour);
		hpContainer.add(lbMinuteSelector);
		hpContainer.add(lblMinute);
		vpContainer.add(hpContainer);

		RootPanel.get().add(vpContainer);

		//Create change value handler passing index to notify a listbox change for hours
		lbHourSelector.addChangeHandler(new ChangeHandler(){

			@Override
			public void onChange(ChangeEvent event) {
				Integer iIndex = lbHourSelector.getSelectedIndex();
				switch(iIndex){
				case 0:
					setSelectedHour("00");
					break;
				case 1:
					setSelectedHour("01");
					break;
				case 2:
					setSelectedHour("02");
					break;
				case 3:
					setSelectedHour("03");
					break;
				case 4:
					setSelectedHour("04");
					break;
				case 5:
					setSelectedHour("05");
					break;
				case 6:
					setSelectedHour("06");
					break;
				case 7:
					setSelectedHour("07");
					break;
				case 8:
					setSelectedHour("08");
					break;
				case 9:
					setSelectedHour("09");
					break;
				case 10:
					setSelectedHour("10");
					break;
				case 11:
					setSelectedHour("11");
					break;
				case 12:
					setSelectedHour("12");
					break;
				case 13:
					setSelectedHour("13");
					break;
				case 14:
					setSelectedHour("14");
					break;
				case 15:
					setSelectedHour("15");
					break;
				case 16:
					setSelectedHour("16");
					break;
				case 17:
					setSelectedHour("17");
					break;
				case 18:
					setSelectedHour("18");
					break;
				case 19:
					setSelectedHour("19");
					break;
				case 20:
					setSelectedHour("20");
					break;
				case 21:
					setSelectedHour("21");
					break;
				case 22:
					setSelectedHour("22");
					break;
				case 23:
					setSelectedHour("23");
					break;
				}
				setTimePickerValue();
			}
		});

		//Create change Value handler passing index to notify a lisbox change for minutes
		lbMinuteSelector.addChangeHandler(new ChangeHandler(){

			@Override
			public void onChange(ChangeEvent event) {
				Integer iIndex = lbMinuteSelector.getSelectedIndex();
				switch(iIndex){
				case 0:
					setSelectedMinute("00");
					break;
				case 1:
					setSelectedMinute("01");
					break;
				case 2:
					setSelectedMinute("02");
					break;
				case 3:
					setSelectedMinute("03");
					break;
				case 4:
					setSelectedMinute("04");
					break;
				case 5:
					setSelectedMinute("05");
					break;
				case 6:
					setSelectedMinute("06");
					break;
				case 7:
					setSelectedMinute("07");
					break;
				case 8:
					setSelectedMinute("08");
					break;
				case 9:
					setSelectedMinute("09");
					break;
				case 10:
					setSelectedMinute("10");
					break;
				case 11:
					setSelectedMinute("11");
					break;
				case 12:
					setSelectedMinute("12");
					break;
				case 13:
					setSelectedMinute("13");
					break;
				case 14:
					setSelectedMinute("14");
					break;
				case 15:
					setSelectedMinute("15");
					break;
				case 16:
					setSelectedMinute("16");
					break;
				case 17:
					setSelectedMinute("17");
					break;
				case 18:
					setSelectedMinute("18");
					break;
				case 19:
					setSelectedMinute("19");
					break;
				case 20:
					setSelectedMinute("20");
					break;
				case 21:
					setSelectedMinute("21");
					break;
				case 22:
					setSelectedMinute("22");
					break;
				case 23:
					setSelectedMinute("23");
					break;
				case 24:
					setSelectedMinute("24");
					break;
				case 25:
					setSelectedMinute("25");
					break;
				case 26:
					setSelectedMinute("26");
					break;
				case 27:
					setSelectedMinute("27");
					break;
				case 28:
					setSelectedMinute("28");
					break;
				case 29:
					setSelectedMinute("29");
					break;
				case 30:
					setSelectedMinute("30");
					break;
				case 31:
					setSelectedMinute("31");
					break;
				case 32:
					setSelectedMinute("32");
					break;
				case 33:
					setSelectedMinute("33");
					break;
				case 34:
					setSelectedMinute("34");
					break;
				case 35:
					setSelectedMinute("35");
					break;
				case 36:
					setSelectedMinute("36");
					break;
				case 37:
					setSelectedMinute("37");
					break;
				case 38:
					setSelectedMinute("38");
					break;
				case 39:
					setSelectedMinute("39");
					break;
				case 40:
					setSelectedMinute("40");
					break;
				case 41:
					setSelectedMinute("41");
					break;
				case 42:
					setSelectedMinute("42");
					break;
				case 43:
					setSelectedMinute("43");
					break;
				case 44:
					setSelectedMinute("44");
					break;
				case 45:
					setSelectedMinute("45");
					break;
				case 46:
					setSelectedMinute("46");
					break;
				case 47:
					setSelectedMinute("47");
					break;
				case 48:
					setSelectedMinute("48");
					break;
				case 49:
					setSelectedMinute("49");
					break;
				case 50:
					setSelectedMinute("50");
					break;
				case 51:
					setSelectedMinute("51");
					break;
				case 52:
					setSelectedMinute("52");
					break;
				case 53:
					setSelectedMinute("53");
					break;
				case 54:
					setSelectedMinute("54");
					break;
				case 55:
					setSelectedMinute("55");
					break;
				case 56:
					setSelectedMinute("56");
					break;
				case 57:
					setSelectedMinute("57");
					break;
				case 58:
					setSelectedMinute("58");
					break;
				case 59:
					setSelectedMinute("59");
					break;

				}
				setTimePickerValue();
			}
		});
	}



}
