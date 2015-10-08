package com.app.gwtchartproject.client;
/*
This module describes the UI wich contain 5 begin pickers components,
5 end pickers components and a granularity listbox
Each time you can choose :
 													- The date of beginning and end
													- The time (min and hour) of begenning and end
													- The granularity of your chart,
													- a button to sens end and begin time if you want to change it dynamically

This module instanciate all the elements and format it in the UI to have a responsive view
*/

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.core.client.GWT;


public class ChartParamUI extends Widget{



	/**************************************
	 * 			Arguments
	 **************************************/
	public FlowPanel pane;
	private String _sBeginDateString;
	private String _sEndDateString;
	private String _sBeginHourString;
	private String _sBeginMinuteString;
	private String _sEndHourString;
	private String _sEndMinuteString;
	private String _sGranularity;

	/**************************************
	 * 			Getters
	 **************************************/
	public String getSelectedGranularityString(){
		return this._sGranularity;
	}

	//Getters Begin
	public String getSelectedBeginDateString(){
		return this._sBeginDateString;
	}

	public String getSelectedBeginHourString(){
		return this._sBeginHourString;
	}

	public String getSelectedBeginMinuteString(){
		return this._sBeginMinuteString;
	}

	//Getters End
	public String getSelectedEndDateString(){
		return this._sEndDateString;
	}

	public String getSelectedEndHourString(){
		return this._sEndHourString;
	}

	public String getSelectedEndMinuteString(){
		return this._sEndMinuteString;
	}

	/**************************************
	 * 			Setters
	 **************************************/
	public void setSelectedGranularityString(String sGranularity){
		this._sGranularity = sGranularity;
	}

	//Setters Begin
	public void setSelectedBeginDateString(String sBeginDateString){
		this._sBeginDateString = sBeginDateString;
	}

	public void setSelectedBeginHourString(String sBeginHourString){
		this._sBeginHourString = sBeginHourString;
	}

	public void setSelectedBeginMinuteString(String sBeginMinuteString){
		this._sBeginMinuteString = sBeginMinuteString;
	}

	//Setters End
	public void setSelectedEndDateString(String sEndDateString){
		this._sEndDateString = sEndDateString;
	}

	public void setSelectedEndHourString(String sEndHourString){
		this._sEndHourString = sEndHourString;
	}

	public void setSelectedEndMinuteString(String sEndMinuteString){
		this._sEndMinuteString = sEndMinuteString;
	}



	/**************************************
	 * 			Methods
	 **************************************/
	public FlowPanel getFlowPanel(){
		return this.pane;
	}

	public void setContentInPanel(Widget widget){
		if(pane == null){
			pane = new FlowPanel();
		}
		getFlowPanel().add(widget);
	}

	public static ChartServiceAsync getService(){
		return GWT.create(ChartService.class);
	}


	/*
	* ChartParam wich will be constantly update
	*/
	public ChartParam cpCurrentChartParam;


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

		class MyHandler implements ClickHandler{
			final AsyncCallback<String> callback = new AsyncCallback<String>(){
				public void onFailure(Throwable caught){
					DialogBox dialogBox = new DialogBox();
					dialogBox.setText("Remote Procedure Call - Failure");
					dialogBox.center();
				}
				public void onSuccess(String s){
					ChartDisplayer cd = new ChartDisplayer();
				}
			};
			public void onClick(ClickEvent event){
				getService().generateChart(callback);
				if(cpCurrentChartParam == null){
					cpCurrentChartParam = new ChartParam(getSelectedBeginDateString(), tpBeginTimeSelector.getTimePickerValue(), getSelectedEndDateString(), tpEndTimeSelector.getTimePickerValue(), getSelectedGranularityString());
				}cpCurrentChartParam.setBeginDate(getSelectedBeginDateString());
				cpCurrentChartParam.setBeginTime(tpBeginTimeSelector.getTimePickerValue());
				cpCurrentChartParam.setEndDate(getSelectedEndDateString());
				cpCurrentChartParam.setEndTime(tpEndTimeSelector.getTimePickerValue());
				cpCurrentChartParam.setGranularity(getSelectedGranularityString());
			}

		}
		MyHandler handler = new MyHandler();
		btSend.addClickHandler(handler);
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

		/*
		* BeginDatePicker Handler, Convert Date to sql-type Date and places it in the currentChartParam as BeginDate
		*/
		dpBeginDateSelector.addValueChangeHandler(new ValueChangeHandler<Date>(){

			@Override
      		public void onValueChange(ValueChangeEvent<Date> event) {
		  		Date selectedDate = new Date();
		    	selectedDate = event.getValue();
		   		setSelectedBeginDateString(sqlFormat.format(selectedDate));
		   		cpCurrentChartParam.setBeginDate(getSelectedBeginDateString());
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
    			setSelectedEndDateString(sqlFormat.format(selectedDate));
    			cpCurrentChartParam.setEndDate(dateString);
    		}
    	});
		}
	}
