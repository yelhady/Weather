package com.weather.controller;

import com.weather.dom.User;
import com.weather.service.UserService;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.rmi.runtime.Log;

import java.io.IOException;
import org.apache.log4j.*;

/**
 * Handles the home page after login.
 *
 * @author Khaled Kandil
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    private static final Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    /**
     * Handles retrieving the home page.
     *
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) throws IOException {
        User user = userService.getCurrentUSer();
        model.addAttribute("user", user);

        model.addAttribute("weatherJsonObjectWrapper", weatherService.getWeatherObjectByLocation("Cairo,EG"));

        return "home";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
