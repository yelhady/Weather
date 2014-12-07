package com.weather.service;

import com.weather.dom.SystemNote;

import java.util.List;

/**
 * Handles the Admin functionality.
 *
 * @author Khaled Kandil
 */
public interface AdminService {
    /**
     * Function that updates the system note from the data entered by admin.
     *
     * @param systemNote
     * @return
     */
    public Boolean updateSystemNote(String systemNote);

    /**
     * Function that retrieves the old notes added by this admin in the system.
     *
     * @return
     */
    public List<SystemNote> getOldSystemNotes();
}
