package com.weather.dao;

import com.weather.dom.SystemNote;

import java.util.List;

/**
 * Handles the Weather system notes functionality for the database layer.
 *
 * @author Khaled Kandil
 */
public interface WeatherDao {
    /**
     * Function that gets today's system note.
     *
     * @return
     */
    public SystemNote getTodaySystemNote();

    /**
     * Function that gets pre-defined system notes.
     *
     * @param temperature
     * @return
     */
    public SystemNote getPreDefinedSystemNote(int temperature);
}
