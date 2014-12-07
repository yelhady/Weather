package com.weather.dao;

import com.weather.dom.SystemNote;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the AdminDao interface.
 *
 * @see com.weather.dao.AdminDao
 *
 * @author Khaled Kandil
 */
@Repository
public class JdbcAdminDao implements AdminDao {
    private static final Logger logger = Logger.getLogger(JdbcAdminDao.class);

    @Autowired
    private DataSource dataSource;

    /**
     * @see com.weather.dao.AdminDao#updateSystemNote(String, String)
     * @param systemNote
     * @param userEmail
     * @return
     */
    @Override
    public Boolean updateSystemNote(String systemNote, String userEmail) {
        logger.info("updateSystemNote function is called.");

        logger.debug("Parameters are the note: " + systemNote + " inserted by admin: " + userEmail);

        String sql = "INSERT INTO SYSTEM_NOTES (EMAIL, BODY, DATE) VALUES (?, ?, curdate())";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userEmail);
            ps.setString(2, systemNote);
            ps.executeUpdate();

            return true;
        } catch (SQLException e) {
            logger.error("Error while getting updating system note for user: " + userEmail + ".\n", e);
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("Error while closing database connection.\n", e);
                    return false;
                }
            }
        }
    }

    /**
     * @see com.weather.dao.AdminDao#getOldSystemNotes(String)
     *
     * @param userEmail
     * @return
     */
    @Override
    public List<SystemNote> getOldSystemNotes(String userEmail) {
        logger.info("getOldSystemNotes function is called.");

        logger.debug("Parameter is the admin email who requested his old notes: " + userEmail);

        String sql = "SELECT * FROM SYSTEM_NOTES WHERE EMAIL = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userEmail);
            List<SystemNote> systemNotes = new ArrayList<SystemNote>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SystemNote systemNote = new SystemNote();

                systemNote.setUserEmail(rs.getString("EMAIL"));
                systemNote.setText(rs.getString("BODY"));
                systemNote.setDate(rs.getDate("DATE"));

                systemNotes.add(systemNote);
            }
            rs.close();
            ps.close();
            return systemNotes;
        } catch (SQLException e) {
            logger.error("Error while getting system notes for user: " + userEmail + " from database.\n", e);
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("Error while closing database connection.\n", e);
                    return null;
                }
            }
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
