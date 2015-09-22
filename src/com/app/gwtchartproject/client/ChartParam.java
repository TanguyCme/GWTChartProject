package com.app.gwtchartproject.client;
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



public class ChartParam {

	/**************************************
				   Attributes
	***************************************/

	//Begin time pickers
	private String _sBeginDate;
	private String _sBeginTime;

	//End time pickers
	private String _sEndDate;
	private String _sEndTime;

	//Granularity attribute
	private Granularity _gGranularity;


	/**************************************
					Methods
	***************************************/

	/*
	Constructors
	*/
	public ChartParam(String sBeginDate, String sBeginTime, String sEndDate, String sEndTime, Granularity gGranularity){
		this.setBeginDate(sBeginDate);
		this.setBeginTime(sBeginTime);
		this.setEndDate(sEndDate);
		this.setEndTime(sEndTime);
		this.setGranularity(gGranularity);
	};

	public ChartParam(){};

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

	public Granularity getGranularity(){
		return this._gGranularity;
	}

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
	public void setGranularity(Granularity gGranularity){
		this._gGranularity = gGranularity;
	}
}
