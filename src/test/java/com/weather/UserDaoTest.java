package com.weather;

import com.weather.dao.UserDao;
import com.weather.dom.RegisterUser;
import com.weather.service.UserService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/database.xml", "file:src/main/webapp/WEB-INF/spring-security.xml", "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
@TransactionConfiguration(transactionManager = "jdbcTransactionManager", defaultRollback = true)
@Transactional
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Before
    public void setup() {
    }

    @Test
    public void testSuccessRegistration() {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail("junit@junit.com");
        registerUser.setName("junit");
        registerUser.setPassword("junit");
        registerUser.setConfirmPassword("junit");
        registerUser.setMobileNumber("junit");

        Assert.assertTrue(userDao.register(registerUser));
    }

    @Test
    public void testInvalidRegistrationUsingRegisteredEmail() {
        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail("junit@junit.com");
        registerUser.setName("junit");
        registerUser.setPassword("junit");
        registerUser.setConfirmPassword("junit");
        registerUser.setMobileNumber("junit");

        Assert.assertFalse(userDao.register(registerUser));
    }

    @Test
    public void testGetUSerByEmail() {
        Assert.assertNotNull(userDao.getUSerByEmail("junit@junit.com"));
    }
}
