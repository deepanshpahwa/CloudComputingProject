package com.HW2.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public  class WeatherBean implements Serializable {
    private String DATE;

    private Double max_temperature;

    private Double min_temperature;

    WeatherBean(){}

    public WeatherBean(String date, Double max_temp, Double min_temp) {
        this.DATE = date;
        this.max_temperature = max_temp;
        this.min_temperature = min_temp;
    }
    @JsonProperty("DATE")
    public String getDATE() {
        return DATE;
    }
    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    @JsonProperty("TMAX")
    public Double getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(Double max_temperature) {
        this.max_temperature = max_temperature;
    }

    @JsonProperty("TMIN")
    public Double getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(Double min_temperature) {
        this.min_temperature = min_temperature;
    }

}
