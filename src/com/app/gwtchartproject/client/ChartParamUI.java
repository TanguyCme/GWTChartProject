package com.app.gwtchartproject.client;
/*
This module describes the UI wich contain 5 begin pickers components,
5 end pickers components and a granularity listbox
Each time you can choose :
 													- The date of begenning and end
													- The time (min and hour) of begenning and end
													- The granularity of your chart,
													- a button to sens end and begin time if you want to change it dynamically

This module instanciate all the elements and format it in the UI to have a responsive view
*/

import java.util.Date;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.Widget;

public class ChartParamUI extends Widget{

	/*
	* ChartParam wich will be constantly update
	*/
	public ChartParam cpCurrentChartParam = new ChartParam();


	/*
	* Constructor method
	*/
	public ChartParamUI(){


		/*
		* Begin picker components
		*/
		final Label lblBeginSection = new Label("Choose Your begin state of chart treatment");
		final DatePicker dpBeginDateSelector = new DatePicker();
		final Label lblBeginTimeInstructions = new Label("Put your chosen begin time format : hh:mm:ss");
		final TimePicker tpBeginTimeSelector = new TimePicker("Begin Time Selector");
		final Button btBeginTimeSend = new Button("Specify Begin Time");

		/*
		* End picker components
		*/
		final Label lblEndSection = new Label("Choose Your end state of chart treatment");
		final DatePicker dpEndDateSelector = new DatePicker();
		final Label lblEndTimeInstructions = new Label("Put your chosen end time format : hh:mm:ss");
		final TimePicker tpEndTimeSelector = new TimePicker("Begin Time Selector");
		final Button btEndTimeSend = new Button("Specify End Time");

		/*
		* Granularity listBox
		*/
		final ListBox lbGranularitySelector = new ListBox();
//		lbGranularity.addItem(item);

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

			@Override
      		public void onValueChange(ValueChangeEvent<Date> event) {
		  		Date selectedDate = new Date();
		    	selectedDate = event.getValue();
		   		String dateString = sqlFormat.format(selectedDate);
		   		cpCurrentChartParam.setBeginDate(dateString);
    		}
    	});


    	/*
		* EndDatePicker Handler, Convert Date to sql-type Date and places it into the currentChartParam as EndDate
    	*/
    	dpEndDateSelector.addValueChangeHandler(new ValueChangeHandler<Date>(){
    		public void onValueChange(ValueChangeEvent<Date> event) {
    			Date selectedDate = new Date();
    			selectedDate = event.getValue();
    			String dateString = new String();
    			dateString = sqlFormat.format(selectedDate);
    			cpCurrentChartParam.setEndDate(dateString);
    		}


    	});

	}
}
