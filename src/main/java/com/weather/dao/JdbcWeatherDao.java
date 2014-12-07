package com.weather.dao;

import com.weather.dom.SystemNote;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @see com.weather.dao.WeatherDao
 *
 * @author Khaled Kandil
 */
@Repository
public class JdbcWeatherDao implements WeatherDao {
    private static final Logger logger = Logger.getLogger(JdbcWeatherDao.class);

    @Autowired
    private DataSource dataSource;

    /**
     *  @see WeatherDao#getTodaySystemNote()
     *
     * @return
     */
    @Override
    public SystemNote getTodaySystemNote() {
        logger.info("getTodaySystemNote function is called.");

        logger.debug("Function takes no parameter, get today's system note.");

        String sql = "SELECT * FROM SYSTEM_NOTES WHERE DATE = curdate()";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            SystemNote systemNote = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                systemNote = new SystemNote();

                systemNote.setUserEmail(rs.getString("EMAIL"));
                systemNote.setText(rs.getString("BODY"));
                systemNote.setDate(rs.getDate("DATE"));
            }
            rs.close();
            ps.close();
            return systemNote;
        } catch (SQLException e) {
            logger.error("Error while getting today's system note from database.\n", e);
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

    /**
     * @see WeatherDao#getPreDefinedSystemNote(int)
     *
     * @param temperature
     * @return
     */
    @Override
    public SystemNote getPreDefinedSystemNote(int temperature) {
        logger.info("getPreDefinedSystemNote function is called.");

        logger.debug("Function takes today's temperature as a parameter.");

        String sql = "SELECT BODY FROM PRE_DEFINED_SYSTEM_NOTES WHERE MIN_VALUE < ? AND MAX_VALUE >= ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, temperature);
            ps.setInt(2, temperature);
            SystemNote systemNote = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                systemNote = new SystemNote();

                systemNote.setText(rs.getString("BODY"));
            }
            rs.close();
            ps.close();
            return systemNote;
        } catch (SQLException e) {
            logger.error("Error while getting pre defined system notes from database.\n", e);
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
