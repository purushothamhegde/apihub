package com.philips.apihub.ca.rally;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Tags
{
    private String _rallyAPIMajor;

    private String _rallyAPIMinor;

    private String _ref;

    private String _type;

    private List<String> _tagsNameArray;

    @JsonProperty("Count")
    private int Count;

    public void set_rallyAPIMajor(String _rallyAPIMajor){
        this._rallyAPIMajor = _rallyAPIMajor;
    }
    public String get_rallyAPIMajor(){
        return this._rallyAPIMajor;
    }
    public void set_rallyAPIMinor(String _rallyAPIMinor){
        this._rallyAPIMinor = _rallyAPIMinor;
    }
    public String get_rallyAPIMinor(){
        return this._rallyAPIMinor;
    }
    public void set_ref(String _ref){
        this._ref = _ref;
    }
    public String get_ref(){
        return this._ref;
    }
    public void set_type(String _type){
        this._type = _type;
    }
    public String get_type(){
        return this._type;
    }
    public void set_tagsNameArray(List<String> _tagsNameArray){
        this._tagsNameArray = _tagsNameArray;
    }
    public List<String> get_tagsNameArray(){
        return this._tagsNameArray;
    }
    public void setCount(int Count){
        this.Count = Count;
    }
    public int getCount(){
        return this.Count;
    }
}