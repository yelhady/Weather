package com.weather.dom;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherIconUrlJsonObject {

    @JsonProperty("value")
    private String weatherImageUrl;

    public String getWeatherImageUrl() {
        return weatherImageUrl;
    }

    public void setWeatherImageUrl(String weatherImageUrl) {
        this.weatherImageUrl = weatherImageUrl;
    }
}
