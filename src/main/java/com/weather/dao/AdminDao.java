package com.weather.dao;

import com.weather.dom.SystemNote;

import java.util.List;

/**
 * Handles the Admin functionality for the database layer.
 *
 * @author Khaled Kandil
 */
public interface AdminDao {
    /**
     * Function that updates the system note in the database from the data entered by admin.
     *
     * @param systemNote
     * @param userEmail
     * @return
     */
    public Boolean updateSystemNote(String systemNote, String userEmail);

    /**
     * Function that retrieves the old notes added by this admin in the system.
     *
     * @param userEmail
     * @return
     */
    public List<SystemNote> getOldSystemNotes(String userEmail);
}
