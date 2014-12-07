package com.weather.service;

import com.weather.dao.UserDao;
import com.weather.dom.RegisterUser;
import com.weather.dom.Roles;
import com.weather.dom.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @see com.weather.service.UserService
 *
 * @author Khaled Kandil
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    /**
     *@see UserService#getCurrentUSer()
     *
     * @return
     */
    @Override
    public User getCurrentUSer() {
        logger.info("getCurrentUSer function is called.");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.debug("Function takes no parameter, get the current logged in user: " + auth.getName());

        User user = userDao.getUSerByEmail(auth.getName());
        user.setIsAdmin(isUserAdmin(auth));

        return user;
    }

    /**
     * @see com.weather.service.UserService#register(com.weather.dom.RegisterUser)
     *
     * @param registerUser
     * @return
     */
    @Override
    public Boolean register(RegisterUser registerUser) {
        logger.info("register function is called.");

        logger.debug("The parameters are the register user form parameters: " + registerUser);

        if (!registerUser.getPassword().equals(registerUser.getConfirmPassword()))
            return false;

        return userDao.register(registerUser);
    }

    /**
     * Function that checks if the logged in user is admin or not.
     *
     * @param auth
     * @return
     */
    private boolean isUserAdmin(Authentication auth){
        logger.info("isUserAdmin function is called.");

        logger.debug("Parameters is the Authentication to check if the current user is admin or not.");

        for (GrantedAuthority authority : auth.getAuthorities()) {
            if (authority.getAuthority().equals(Roles.ROLE_ADMIN.getRole()))
                return true;
        }

        return false;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
