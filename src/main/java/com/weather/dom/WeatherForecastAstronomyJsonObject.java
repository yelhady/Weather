package com.weather.dom;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastAstronomyJsonObject {

    @JsonProperty("sunrise")
    private String sunriseTime;

    @JsonProperty("sunset")
    private String sunsetTime;
}
