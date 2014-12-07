package com.weather.dom;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
    public class WeatherForecastJsonObject {

    @JsonProperty("astronomy")
    private List<WeatherForecastAstronomyJsonObject> astronomyJsonObjects;

    @JsonProperty("date")
    private String date;

    @JsonProperty("hourly")
    private List<WeatherForecastHourlyJsonObject> hourlyJsonObjects;

    @JsonProperty("maxtempC")
    private int maxTemperatureInCelsius;

    @JsonProperty("maxtempF")
    private int maxTemperatureInFahrenheit;

    @JsonProperty("mintempC")
    private int minTemperatureInCelsius;

    @JsonProperty("mintempF")
    private int minTemperatureInFahrenheit;

    public List<WeatherForecastAstronomyJsonObject> getAstronomyJsonObjects() {
        return astronomyJsonObjects;
    }

    public void setAstronomyJsonObjects(List<WeatherForecastAstronomyJsonObject> astronomyJsonObjects) {
        this.astronomyJsonObjects = astronomyJsonObjects;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<WeatherForecastHourlyJsonObject> getHourlyJsonObjects() {
        return hourlyJsonObjects;
    }

    public void setHourlyJsonObjects(List<WeatherForecastHourlyJsonObject> hourlyJsonObjects) {
        this.hourlyJsonObjects = hourlyJsonObjects;
    }

    public int getMaxTemperatureInCelsius() {
        return maxTemperatureInCelsius;
    }

    public void setMaxTemperatureInCelsius(int maxTemperatureInCelsius) {
        this.maxTemperatureInCelsius = maxTemperatureInCelsius;
    }

    public int getMaxTemperatureInFahrenheit() {
        return maxTemperatureInFahrenheit;
    }

    public void setMaxTemperatureInFahrenheit(int maxTemperatureInFahrenheit) {
        this.maxTemperatureInFahrenheit = maxTemperatureInFahrenheit;
    }

    public int getMinTemperatureInCelsius() {
        return minTemperatureInCelsius;
    }

    public void setMinTemperatureInCelsius(int minTemperatureInCelsius) {
        this.minTemperatureInCelsius = minTemperatureInCelsius;
    }

    public int getMinTemperatureInFahrenheit() {
        return minTemperatureInFahrenheit;
    }

    public void setMinTemperatureInFahrenheit(int minTemperatureInFahrenheit) {
        this.minTemperatureInFahrenheit = minTemperatureInFahrenheit;
    }
}
