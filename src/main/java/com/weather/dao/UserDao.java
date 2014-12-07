package com.weather.dao;

import com.weather.dom.RegisterUser;
import com.weather.dom.User;

/**
 * Handles the User functionality for the database layer.
 *
 * @author Khaled Kandil
 */
public interface UserDao {
    /**
     * Function that get the user data using email.
     *
     * @param email
     * @return
     */
    public User getUSerByEmail(String email);

    /**
     * Function that handles adding the user to the system.
     *
     * @param registerUser
     * @return
     */
    public Boolean register(RegisterUser registerUser);
}
