package com.philips.apihub.ca.rally;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
public class UsQueryResult
{
    private String _rallyAPIMajor;

    private String _rallyAPIMinor;

    
    @JsonProperty("Errors")
    private List<String> Errors;

    @JsonProperty("Warnings")
    private List<String> Warnings;

    @JsonProperty("TotalResultCount")
    private int TotalResultCount;

    @JsonProperty("StartIndex")
    private int StartIndex;

    @JsonProperty("PageSize")
    private int PageSize;

    @JsonProperty("Results")
    private List<UsResults> Results;

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
    public void setErrors(List<String> Errors){
        this.Errors = Errors;
    }
    public List<String> getErrors(){
        return this.Errors;
    }
    public void setWarnings(List<String> Warnings){
        this.Warnings = Warnings;
    }
    public List<String> getWarnings(){
        return this.Warnings;
    }
    public void setTotalResultCount(int TotalResultCount){
        this.TotalResultCount = TotalResultCount;
    }
    public int getTotalResultCount(){
        return this.TotalResultCount;
    }
    public void setStartIndex(int StartIndex){
        this.StartIndex = StartIndex;
    }
    public int getStartIndex(){
        return this.StartIndex;
    }
    public void setPageSize(int PageSize){
        this.PageSize = PageSize;
    }
    public int getPageSize(){
        return this.PageSize;
    }
    public void setResults(List<UsResults> Results){
        this.Results = Results;
    }
    public List<UsResults> getResults(){
        return this.Results;
    }
}
