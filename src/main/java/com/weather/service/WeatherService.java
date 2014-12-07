package com.weather.service;

import com.weather.dom.SystemNote;
import com.weather.dom.WeatherObjectWrapper;

import java.util.List;

/**
 * Handles the Weather data preparation functionality.
 *
 * @author Khaled Kandil
 */
public interface WeatherService {
    /**
     * Function that gets the weather object from webservice and current system note for it.
     *
     * @param Location
     * @return
     */
    public WeatherObjectWrapper getWeatherObjectByLocation(String Location);
}
