package com.weather.dao;

import com.weather.dom.RegisterUser;
import com.weather.dom.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @see com.weather.dao.UserDao
 *
 * @author Khaled Kandil
 */
@Repository
public class JdbcUserDao implements UserDao {
    private static final Logger logger = Logger.getLogger(JdbcUserDao.class);

    @Autowired
    private DataSource dataSource;

    /**
     * @see com.weather.dao.UserDao#getUSerByEmail(String)
     *
     * @param email
     * @return
     */
    @Override
    public User getUSerByEmail(String email) {
        logger.info("getUSerByEmail function is called.");

        logger.debug("The parameter is the user email to get all the info about him: " + email);

        String sql = "SELECT * FROM USER WHERE EMAIL = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            User user = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();

                user.setEmail(rs.getString("EMAIL"));
                user.setName(rs.getString("NAME"));
                user.setMobileNumber(rs.getString("MOBILE_NUMBER"));
            }
            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            logger.error("Error while getting user: " + email + " from database.\n", e);
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
     * @see UserDao#register(com.weather.dom.RegisterUser)
     *
     * @param registerUser
     * @return
     */
    @Override
    public Boolean register(RegisterUser registerUser) {
        logger.info("register function is called.");

        logger.debug("The parameters are the register user form parameters: " + registerUser);

        String sql_register = "INSERT INTO USER (NAME, EMAIL, PASSWORD, MOBILE_NUMBER) VALUES (?, ?, ?, ?)";
        String sql_roles = "INSERT INTO USER_ROLES (EMAIL, ROLE) VALUES(?, 'ROLE_USER')";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_register);
            ps.setString(1, registerUser.getName());
            ps.setString(2, registerUser.getEmail());
            ps.setString(3, registerUser.getPassword());
            ps.setString(4, registerUser.getMobileNumber());
            ps.executeUpdate();

            ps = conn.prepareStatement(sql_roles);
            ps.setString(1, registerUser.getEmail());
            ps.executeUpdate();

            ps.close();
            return true;
        } catch (SQLException e) {
            logger.error("Error while adding user: " + registerUser +  ".\n", e);

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

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
