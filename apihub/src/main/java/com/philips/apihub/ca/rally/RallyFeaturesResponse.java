package com.philips.apihub.ca.rally;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RallyFeaturesResponse {
	@JsonProperty("QueryResult")  // add this line
	private QueryResult QueryResult;

    public QueryResult getQueryResult ()
    {
        return QueryResult;
    }

    public void setQueryResult (QueryResult QueryResult)
    {
        this.QueryResult = QueryResult;
    }

    @Override
    public String toString()
    {
        return "RallyFeaturesResponse [QueryResult = "+QueryResult+"]";
    }
}
