package com.weather.controller;

import com.weather.dom.User;
import com.weather.service.AdminService;
import com.weather.service.UserService;
import com.weather.service.WeatherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Controller that handles all the admin functionality.
 * Can't access any URL starts with /admin except hasRole('ROLE_ADMIN')
 *
 * @author Khaled Kandil
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private AdminService adminService;

    /**
     * Handles the adminDashBoard page.
     *
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/adminDashBoard", method = RequestMethod.GET)
    public String adminDashBoard(ModelMap model) throws IOException {
        User user = userService.getCurrentUSer();
        model.addAttribute("user", user);

        model.addAttribute("weatherJsonObjectWrapper", weatherService.getWeatherObjectByLocation("Cairo,EG"));

        model.addAttribute("oldSystemNotes", adminService.getOldSystemNotes());

        return "adminDashBoard";
    }

    /**
     * Handles the updateSystemNote functionality.
     *
     * @param systemNote
     * @return
     */
    @RequestMapping(value = "/updateSystemNote", method = RequestMethod.POST)
    public String updateSystemNote(@ModelAttribute("systemNote") String systemNote){
        adminService.updateSystemNote(systemNote);

        return "redirect:/home";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
}
