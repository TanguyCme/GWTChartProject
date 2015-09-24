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
import com.google.gwt.user.client.ui.FlowPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.fx.client.Draggable;
import com.sencha.gxt.widget.core.client.Component;

public class ChartParamUI extends Widget{
	private ContentPanel pane;

	public ContentPanel getContentPanel(){
		return this.pane;
	}

	public void setContentInPanel(Widget w){
		if(pane == null){
			pane = new ContentPanel();
		}
		getContentPanel().add(w);
	}


	/*
	* ChartParam wich will be constantly update
	*/
	public ChartParam cpCurrentChartParam = new ChartParam();


	/*
	* Constructor method
	*/
	public ChartParamUI(){
		super();
		this.onLoad();

	}
	public void onLoad(){
		/*
		* Begin picker components
		*/
		final TimePicker tpBeginTimeSelector = new TimePicker("Begin Date and Time Selector");
		final DatePicker dpBeginDateSelector = new DatePicker();

		/*
		* End picker components
		*/
		final TimePicker tpEndTimeSelector = new TimePicker("End Date and Time Selector");
		final DatePicker dpEndDateSelector = new DatePicker();

		/*
		* Granularity listBox
		*/
		final ListBox lbGranularitySelector = new ListBox();
		lbGranularitySelector.addItem("Granularity");

		/*
		* SendButton
		*/
		final Button btSend = new Button("SendNewParam");
		/*
		* Format modifiers
		*/
		final DateTimeFormat sqlFormat = DateTimeFormat.getFormat("yyyy-MM-dd");


		/*
		* Display all the UI elements
		*/
		VerticalPanel vpBegin = new VerticalPanel();
		VerticalPanel vpEnd = new VerticalPanel();

		HorizontalPanel hpGlobalContainer = new HorizontalPanel();

		vpBegin.add(tpBeginTimeSelector.getVPTimerContainer());
		vpBegin.add(dpBeginDateSelector);
		vpBegin.add(lbGranularitySelector);
		hpGlobalContainer.add(vpBegin);

		vpEnd.add(tpEndTimeSelector.getVPTimerContainer());
		vpEnd.add(dpEndDateSelector);
		vpEnd.add(btSend);
		hpGlobalContainer.add(vpEnd);

		setContentInPanel(hpGlobalContainer);
		pane.setWidth(450);

		RootPanel.get().add(getContentPanel());
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
