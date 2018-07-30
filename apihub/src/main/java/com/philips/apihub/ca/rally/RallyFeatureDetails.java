package com.philips.apihub.ca.rally;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RallyFeatureDetails {
	@JsonProperty("Feature")  // add this line
    private Feature Feature;

    public void setFeature(Feature Feature){
        this.Feature = Feature;
    }
    public Feature getFeature(){
        return this.Feature;
    }
    
}
