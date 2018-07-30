package com.philips.apihub.ca.rally;

import com.fasterxml.jackson.annotation.JsonProperty;

public class _tagsNameArray
{
	@JsonProperty("Name")
    private String Name;

    private String _ref;

	@JsonProperty("DisplayColor")
    private String DisplayColor;

	@JsonProperty("TargetDate")
    private String TargetDate;

    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }
    public void set_ref(String _ref){
        this._ref = _ref;
    }
    public String get_ref(){
        return this._ref;
    }
    public void setDisplayColor(String DisplayColor){
        this.DisplayColor = DisplayColor;
    }
    public String getDisplayColor(){
        return this.DisplayColor;
    }
    public void setTargetDate(String TargetDate){
        this.TargetDate = TargetDate;
    }
    public String getTargetDate(){
        return this.TargetDate;
    }
}