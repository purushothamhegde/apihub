package com.philips.apihub.ca.rally;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsResponse {
	@JsonProperty("QueryResult")  // add this line
    private UsQueryResult QueryResult;

    public void setQueryResult(UsQueryResult QueryResult){
        this.QueryResult = QueryResult;
    }
    public UsQueryResult getQueryResult(){
        return this.QueryResult;
    }

    
}
