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
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.Component;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class ChartParamUI extends Widget{

	/*
	* ChartParam wich will be constantly update
	*/
	public ChartParam cpCurrentChartParam = new ChartParam();


	/*
	* Constructor method
	*/
	public ChartParamUI(){
		super();

		/*
		* Begin picker components
		*/
		final Label lblBeginSection = new Label("Begin Date");
		final DatePicker dpBeginDateSelector = new DatePicker();
		final Label lblBeginTimeInstructions = new Label("Put your chosen begin time format : hh:mm:ss");
		final TimePicker tpBeginTimeSelector = new TimePicker("Begin Time Selector");
		final Button btGenerate = new Button("Generator");

		/*
		* End picker components
		*/
		final Label lblEndSection = new Label("End Date");
		final DatePicker dpEndDateSelector = new DatePicker();
		final Label lblEndTimeInstructions = new Label("Put your chosen end time format : hh:mm:ss");
		final TimePicker tpEndTimeSelector = new TimePicker("Begin Time Selector");

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
		// Ui description : VerticalPanel (HorizontalPanel(labels), HorizontalPanel(Calendars), HorizontalPanel(Granularity & button generate))
		VerticalPanel vpSectionElement = new VerticalPanel();
		HorizontalPanel hpTitleContainer = new HorizontalPanel();
		HorizontalPanel hpCalendarContainer = new HorizontalPanel();
		HorizontalPanel hpGranularityAndButtonContainer = new HorizontalPanel();

		vpSectionElement.add(tpBeginTimeSelector);
		vpSectionElement.add(tpEndTimeSelector);

		hpTitleContainer.add(lblBeginSection);
		hpTitleContainer.add(lblEndSection);
		vpSectionElement.add(hpTitleContainer);

		hpCalendarContainer.add(dpBeginDateSelector);
		hpCalendarContainer.add(dpEndDateSelector);
		vpSectionElement.add(hpCalendarContainer);

		hpGranularityAndButtonContainer.add(lbGranularitySelector);
		hpGranularityAndButtonContainer.add(btGenerate);
		vpSectionElement.add(hpGranularityAndButtonContainer);

		RootPanel.get().add(vpSectionElement);


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
