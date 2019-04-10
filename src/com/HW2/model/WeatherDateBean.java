package com.HW2.model;

import org.codehaus.jackson.annotate.JsonProperty;


public class WeatherDateBean {
    public WeatherDateBean(String date) {
        this.DATE = date;
    }
    @JsonProperty("DATE")
    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }
    String DATE;
}