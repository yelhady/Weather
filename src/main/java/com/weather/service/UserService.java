package com.weather.service;

import com.weather.dom.RegisterUser;
import com.weather.dom.User;

/**
 * Handles the User functionality.
 *
 * @author Khaled Kandil
 */
public interface UserService {
    /**
     * Function that get the user data using email.
     *
     * @return
     */
    public User getCurrentUSer();

    /**
     * Function that handles adding the user to the system.
     *
     * @param registerUser
     * @return
     */
    public Boolean register(RegisterUser registerUser);
}
