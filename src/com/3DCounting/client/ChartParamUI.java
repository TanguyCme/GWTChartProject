package com.3dcounting.client;

/*
This class Module ChartParamUI will describe the UI of the ChartProject, in wich you cant pick the param 
to select the chart of your choice.
This class implement EntryPoint because it's going to be displayed.
We need so 5 differents elements :
		- A dpBeginDateSelector: DatePicker
		- A tpBeginTimeSelector: Timepicker
		- A dpEndDateSelector: DatePicker
		- A tpEndTimeSelector: TimePicker 
		- A lbGranularitySelector: ListBox (YEAR, MONTH, WEEK, DAY, HOUR, MINUTE)

The onModuleLoad method will instanciate and dispaly all this UI elements and then Instanciante 
a ChartParam currentChartParam wich will be compared with the ChartParam Object wich 
created previous chart every 3seconds
*/

import com.3dcounting.client.ChartParam;
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
import com.summatech.gwt.GwtTimepicker;
import com.google.gwt.user.client.ui.ListBox;

public class ChartParamUI implements EntryPoint {

	/*
	* ChartParam wich will be constantly update
	*/
	public ChartParam cpCurrentChartParam = new ChartParam();

	/**************************************
				   Attributes
	***************************************/
	private String sGranularitySelected = new String();

	/**************************************
					Methods
	***************************************/
	public String getGranularitySelected(){
		return this.sGranularitySelected;
	}
	public void setGranularitySelected(String sGranularitySelected){
		this.sGranularitySelected = sGranularitySelected;
	}


	/*
	* Create the EntryPoint Method
	*/
	public onModuleLoad(){


		/*
		* Begin picker components
		*/
		final Label lblBeginSection = new Label("Choose Your begin state of chart treatment");
		final DatePicker dpBeginDateSelector = new DatePicker();
		final Label lblBeginTimeInstructions = new Label("Put your chosen begin time format : hh:mm:ss");
		final TextField tpBeginTimeSelector = new TextField("00:00:00");
		final Button btBeginTimeSend = new Button("Specify Begin Time");
		//Textfield Allows
		tpBeginTimeSelector.setMaxLength(8);
		tpBeginTimeSelector.setMaxLengthText("Oops, appears that you hadn't write a good format time");
		tpBeginTimeSelector.setMinLength(8);
		tpBeginTimeSelector.setMinLengthText("Oops, appears that you hadn't write a good format time");


		/*
		* End picker components
		*/
		final Label lblEndSection = new Label("Choose Your end state of chart treatment");
		final DatePicker dpEndDateSelector = new DatePicker();
		final Label lblEndTimeInstructions = new Label("Put your chosen end time format : hh:mm:ss");
		final TextField tpEndTimeSelector = new TextField("00:00:00");
		final Button btEndTimeSend = new Button("Specify End Time");
		//Textfield Allows
		tpEndTimeSelector.setMaxLength(8);
		tpEndTimeSelector.setMaxLengthText("Oops, appears that you hadn't write a good time");
		tpEndTimeSelector.setMinLength(8);
		tpEndTimeSelector.setMinLengthText("Oops, appears that you hadn't write a good time");


		/*
		* Granularity listBox
		*/
		final ListBox lbGranularitySelector = new ListBox();
		lbGranularitySelector.addItem("YEAR");
		lbGranularitySelector.addItem("MONTH");
		lbGranularitySelector.addItem("WEEK");
		lbGranularitySelector.addItem("DAY");
		lbGranularitySelector.addItem("HOUR");
		lbGranularitySelector.addItem("MINUTE");


		/*
		* Format modifiers
		*/
		final DateTimeFormat sqlFormat = DateTimeFormat.getFormat("yyyy-MM-dd");


		/*
		* Display all the UI elements
		*/
		// Begin Selection Elements
		RootPanel.get().add(lblBeginSection);
		RootPanel.get().add(dpBeginDateSelector);
		RootPanel.get().add(lblBeginTimeInstructions);
		RootPanel.get().add(tpBeginTimeSelector);
		RootPanel.get().add(btBeginTimeSend);

		// End Selection Elements
		RootPanel.get().add(lblEndSection);
		RootPanel.get().add(dpEndDateSelector);
		RootPanel.get().add(lblEndTimeInstructions);
		RootPanel.get().add(tpEndTimeSelector);
		RootPanel.get().add(btEndTimeSend);

		// Granularity ListBox
		RootPanel.get().add(lbGranularitySelector);

		/*
		* BeginDatePicker Handler, Convert Date to sql-type Date and places it in the currentChartParam as BeginDate
		*/
		dpBeginDateSelector.addValueChangeHandler(new ValueChangeHandler<Date>(){
      		public void onValueChange(ValueChangeEvent<Date> event) {
		  		final Date selectedDate = new Date();
		    	selectedDate = event.getValue();
		   		dateString = sqlFormat.format(selectedDate);
		   		cpCurrentChartParam.setBeginDate(dateString);
    		}
    	});


    	/*
		* EndDatePicker Handler, Convert Date to sql-type Date and places it into the currentChartParam as EndDate
    	*/
    	dpEndDateSelector.addValueChangeHandler(new ValueChangeHandler<Date>(){
    		public void onValueChange(ValueChangeEvent<Date> event) {
    			final Date selectedDate = new Date();
    			selectedDate = event.getValue();
    			String dateString = new String();
    			dateString = sqlFormat.format(selectedDate);
    			cpCurrentChartParam.setEndDate(dateString);
    		}


    	});

	}
}