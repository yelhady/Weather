package com.weather.controller;

import com.weather.dom.RegisterUser;
import com.weather.service.UserService;
import com.weather.service.WeatherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles the Register functionality.
 *
 * @author Khaled Kandil
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final Logger logger = Logger.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    /**
     * Retrieve the register page.
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(ModelMap modelMap) {
        return "register";
    }

    /**
     * Handle the register functionality.
     * Validate submitted form, add user to the database with ROLE_USER.
     *
     * @param registerUser
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String register(@ModelAttribute("registerUser") RegisterUser registerUser, ModelMap modelMap, HttpServletRequest request) {
        String error = validateRegistrationForm(registerUser);

        if (error != null) {
            modelMap.addAttribute("error", error);

            return "register";
        }

        boolean isEmailValid = userService.register(registerUser);

        if (!isEmailValid) {
            modelMap.addAttribute("error", registerUser.getEmail() + " belongs to an existing account.");

            return "register";
        }

        authenticateUserAndSetSession(registerUser, request);

        return "redirect:/home";
    }

    /**
     * Set the registered user as authenticated to be redirected to home page with out login.
     *
     * @param user
     * @param request
     */
    private void authenticateUserAndSetSession(RegisterUser user, HttpServletRequest request) {
        logger.info("Registered user authentication is called.");

        String email = user.getEmail();
        String password = user.getPassword();

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        token.setDetails(new WebAuthenticationDetails(request));

        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

    /**
     * Validate the registration form.
     *
     * @param registerUser
     * @return
     */
    private String validateRegistrationForm(RegisterUser registerUser) {
        logger.info("Validate registration form is called.");

        if (StringUtils.isEmpty(registerUser.getEmail()))
            return "Invalid Email.";

        if (StringUtils.isEmpty(registerUser.getPassword()))
            return "Invalid Password.";

        if (StringUtils.isEmpty(registerUser.getName()))
            return "Invalid Full Name.";

        if (StringUtils.isEmpty(registerUser.getMobileNumber()))
            return "Invalid Mobile Number.";

        if (!registerUser.getPassword().equals(registerUser.getConfirmPassword()))
            return "Password doesn't match.";

        return null;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
