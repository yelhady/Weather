package com.weather.dom;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentConditionJsonObject {

    @JsonProperty("FeelsLikeC")
    private int realFeelInCelsius;

    @JsonProperty("FeelsLikeF")
    private int realFeelInFahrenheit;

    @JsonProperty("humidity")
    private int humidityPercentage;

    @JsonProperty("temp_C")
    private int degreeInCelsius;

    @JsonProperty("temp_F")
    private int degreeInFahrenheit;

    @JsonProperty("weatherDesc")
    private List<WeatherDescriptionJsonObject> weatherDescriptionJsonObjects;

    @JsonProperty("weatherIconUrl")
    private List<WeatherIconUrlJsonObject> weatherIconUrlJsonObjects;

    @JsonProperty("windspeedKmph")
    private int windSpeedKmPerHour;

    public int getRealFeelInCelsius() {
        return realFeelInCelsius;
    }

    public void setRealFeelInCelsius(int realFeelInCelsius) {
        this.realFeelInCelsius = realFeelInCelsius;
    }

    public int getRealFeelInFahrenheit() {
        return realFeelInFahrenheit;
    }

    public void setRealFeelInFahrenheit(int realFeelInFahrenheit) {
        this.realFeelInFahrenheit = realFeelInFahrenheit;
    }

    public int getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(int humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
    }

    public int getDegreeInCelsius() {
        return degreeInCelsius;
    }

    public void setDegreeInCelsius(int degreeInCelsius) {
        this.degreeInCelsius = degreeInCelsius;
    }

    public int getDegreeInFahrenheit() {
        return degreeInFahrenheit;
    }

    public void setDegreeInFahrenheit(int degreeInFahrenheit) {
        this.degreeInFahrenheit = degreeInFahrenheit;
    }

    public List<WeatherDescriptionJsonObject> getWeatherDescriptionJsonObjects() {
        return weatherDescriptionJsonObjects;
    }

    public void setWeatherDescriptionJsonObjects(List<WeatherDescriptionJsonObject> weatherDescriptionJsonObjects) {
        this.weatherDescriptionJsonObjects = weatherDescriptionJsonObjects;
    }

    public List<WeatherIconUrlJsonObject> getWeatherIconUrlJsonObjects() {
        return weatherIconUrlJsonObjects;
    }

    public void setWeatherIconUrlJsonObjects(List<WeatherIconUrlJsonObject> weatherIconUrlJsonObjects) {
        this.weatherIconUrlJsonObjects = weatherIconUrlJsonObjects;
    }

    public int getWindSpeedKmPerHour() {
        return windSpeedKmPerHour;
    }

    public void setWindSpeedKmPerHour(int windSpeedKmPerHour) {
        this.windSpeedKmPerHour = windSpeedKmPerHour;
    }
}
