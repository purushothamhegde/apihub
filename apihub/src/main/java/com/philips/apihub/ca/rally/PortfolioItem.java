package com.philips.apihub.ca.rally;
public class PortfolioItem
{
    private String _rallyAPIMajor;

    private String _rallyAPIMinor;

    private String _ref;

    private String _refObjectUUID;

    private String _refObjectName;

    private String _type;

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
    public void set_refObjectUUID(String _refObjectUUID){
        this._refObjectUUID = _refObjectUUID;
    }
    public String get_refObjectUUID(){
        return this._refObjectUUID;
    }
    public void set_refObjectName(String _refObjectName){
        this._refObjectName = _refObjectName;
    }
    public String get_refObjectName(){
        return this._refObjectName;
    }
    public void set_type(String _type){
        this._type = _type;
    }
    public String get_type(){
        return this._type;
    }
}