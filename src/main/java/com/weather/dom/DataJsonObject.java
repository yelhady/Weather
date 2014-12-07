package com.weather.dom;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataJsonObject {

    @JsonProperty("current_condition")
    private List<CurrentConditionJsonObject> currentConditionJsonObjects;

    @JsonProperty("request")
    private List<RequestJsonObject> requestJsonObjects;

    @JsonProperty("weather")
    private List<WeatherForecastJsonObject> weatherForecastJsonObjects;

    public List<CurrentConditionJsonObject> getCurrentConditionJsonObjects() {
        return currentConditionJsonObjects;
    }

    public void setCurrentConditionJsonObjects(List<CurrentConditionJsonObject> currentConditionJsonObjects) {
        this.currentConditionJsonObjects = currentConditionJsonObjects;
    }

    public List<RequestJsonObject> getRequestJsonObjects() {
        return requestJsonObjects;
    }

    public void setRequestJsonObjects(List<RequestJsonObject> requestJsonObjects) {
        this.requestJsonObjects = requestJsonObjects;
    }

    public List<WeatherForecastJsonObject> getWeatherForecastJsonObjects() {
        return weatherForecastJsonObjects;
    }

    public void setWeatherForecastJsonObjects(List<WeatherForecastJsonObject> weatherForecastJsonObjects) {
        this.weatherForecastJsonObjects = weatherForecastJsonObjects;
    }
}
