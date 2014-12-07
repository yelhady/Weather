package com.weather.service;

import com.weather.dao.AdminDao;
import com.weather.dao.WeatherDao;
import com.weather.dom.SystemNote;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @see com.weather.service.AdminService
 *
 * @author Khaled Kandil
 */
@Service
public class AdminServiceImpl implements AdminService{
    private static final Logger logger = Logger.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminDao adminDao;

    /**
     * @see com.weather.service.AdminService#updateSystemNote(String)
     *
     * @param systemNote
     * @return
     */
    @Override
    public Boolean updateSystemNote(String systemNote) {
        logger.info("updateSystemNote function is called.");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.debug("Parameters is the new system note: " + systemNote + " set by admin : " + auth.getName());

        return adminDao.updateSystemNote(systemNote, auth.getName());
    }

    /**
     * @see AdminService#getOldSystemNotes()
     *
     * @return
     */
    @Override
    public List<SystemNote> getOldSystemNotes() {
        logger.info("getOldSystemNotes function is called.");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        logger.debug("Function takes no parameter, current admin is the requester of his old system notes - email: " + auth.getName());

        return adminDao.getOldSystemNotes(auth.getName());
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
}
