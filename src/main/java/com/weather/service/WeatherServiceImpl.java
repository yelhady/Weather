package com.weather.service;

import com.weather.dao.WeatherDao;
import com.weather.dom.SystemNote;
import com.weather.dom.User;
import com.weather.dom.WeatherObjectWrapper;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * @see com.weather.service.WeatherService
 *
 * @author Khaled Kandil
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    private static final Logger logger = Logger.getLogger(WeatherServiceImpl.class);

    @Autowired
    private WeatherDao weatherDao;

    /**
     * @see com.weather.service.WeatherService#getWeatherObjectByLocation(String)
     *
     * @param location
     * @return
     */
    @Override
    public WeatherObjectWrapper getWeatherObjectByLocation(String location) {
        logger.info("getWeatherObjectByLocation function is called.");

        logger.debug("Parameters is location: " + location);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.worldweatheronline.com/free/v2/weather.ashx?key=b4d87a07d77148764557037029560&q=" + location + "&num_of_days=10&tp=24&format=json";
        String queryResults = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherObjectWrapper weatherObjectWrapper = null;

        try {
            weatherObjectWrapper = mapper.readValue(queryResults, WeatherObjectWrapper.class);
            int temperature = weatherObjectWrapper.getDataJsonObject().getCurrentConditionJsonObjects().get(0).getDegreeInCelsius();
            weatherObjectWrapper.setSystemNote(getSystemNote(temperature));
        } catch (JsonMappingException e) {
            logger.error("Error while mapping Json object.\n", e);
            return null;
        } catch (JsonParseException e) {
            logger.error("Error while parsing Json object.\n", e);
            return null;
        } catch (Exception e) {
            logger.error(e);
            return null;
        }

        return weatherObjectWrapper;
    }

    /**
     * Function that get the system note based on some rules.
     *
     * if the admin updated today's system note, retrieve it.
     * Otherwise, get the appropriate one from the pre-defined system notes.
     *
     * @param temperature
     * @return
     */
    private SystemNote getSystemNote(int temperature){
        logger.info("getSystemNote function is called.");

        logger.debug("Parameters is the temperature: " + temperature);

        SystemNote systemNoteOfToday = weatherDao.getTodaySystemNote();

        if(systemNoteOfToday != null)
            return systemNoteOfToday;

        return weatherDao.getPreDefinedSystemNote(temperature);
    }

    public void setWeatherDao(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }
}
