package com.philips.apihub.ca.rally;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueryResult
{
    @JsonProperty("_rallyAPIMinor")
	private String _rallyAPIMinor;

    @JsonProperty("_rallyAPIMajor")
    private String _rallyAPIMajor;

    @JsonProperty("PageSize")  
    private String PageSize;

    @JsonProperty("Results")  
    private Results[] Results;

    @JsonProperty("Warnings") 
    private String[] Warnings;

    @JsonProperty("Errors")  
    private String[] Errors;

    @JsonProperty("StartIndex")  
    private String StartIndex;

    @JsonProperty("TotalResultCount")
    private String TotalResultCount;

    public String get_rallyAPIMinor ()
    {
        return _rallyAPIMinor;
    }

    public void set_rallyAPIMinor (String _rallyAPIMinor)
    {
        this._rallyAPIMinor = _rallyAPIMinor;
    }

    public String get_rallyAPIMajor ()
    {
        return _rallyAPIMajor;
    }

    public void set_rallyAPIMajor (String _rallyAPIMajor)
    {
        this._rallyAPIMajor = _rallyAPIMajor;
    }

    public String getPageSize ()
    {
        return PageSize;
    }

    public void setPageSize (String PageSize)
    {
        this.PageSize = PageSize;
    }

    public Results[] getResults ()
    {
        return Results;
    }

    public void setResults (Results[] Results)
    {
        this.Results = Results;
    }

    public String[] getWarnings ()
    {
        return Warnings;
    }

    public void setWarnings (String[] Warnings)
    {
        this.Warnings = Warnings;
    }

    public String[] getErrors ()
    {
        return Errors;
    }

    public void setErrors (String[] Errors)
    {
        this.Errors = Errors;
    }

    public String getStartIndex ()
    {
        return StartIndex;
    }

    public void setStartIndex (String StartIndex)
    {
        this.StartIndex = StartIndex;
    }

    public String getTotalResultCount ()
    {
        return TotalResultCount;
    }

    public void setTotalResultCount (String TotalResultCount)
    {
        this.TotalResultCount = TotalResultCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_rallyAPIMinor = "+_rallyAPIMinor+", _rallyAPIMajor = "+_rallyAPIMajor+", PageSize = "+PageSize+", Results = "+Results+", Warnings = "+Warnings+", Errors = "+Errors+", StartIndex = "+StartIndex+", TotalResultCount = "+TotalResultCount+"]";
    }
}
			
			