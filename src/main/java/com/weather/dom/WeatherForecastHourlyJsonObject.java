package com.weather.dom;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastHourlyJsonObject {

    @JsonProperty("humidity")
    private int humidityPercentage;

    @JsonProperty("weatherDesc")
    private List<WeatherDescriptionJsonObject> weatherDescriptionJsonObjects;

    @JsonProperty("weatherIconUrl")
    private List<WeatherIconUrlJsonObject> weatherIconUrlJsonObjects;

    @JsonProperty("windspeedKmph")
    private int windSpeedKmPerHour;

    public int getHumidityPercentage() {
        return humidityPercentage;
    }

    public void setHumidityPercentage(int humidityPercentage) {
        this.humidityPercentage = humidityPercentage;
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
