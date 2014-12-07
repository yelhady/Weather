package com.weather;

import com.weather.dao.WeatherDao;
import com.weather.dom.WeatherObjectWrapper;
import com.weather.service.WeatherService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class WeatherDaoTest {
    @Autowired
    private WeatherDao weatherDao;

    @Before
    public void setup() {
    }

    @Test
    public void testGetTodaySystemNote() {
        Assert.assertNotNull(weatherDao.getTodaySystemNote());
    }

    @Test
    public void testGetPreDefinedSystemNote() {
        Assert.assertNotNull(weatherDao.getPreDefinedSystemNote(10));
    }

    @Test
    public void testInvalidGetPreDefinedSystemNote() {
        Assert.assertNull(weatherDao.getPreDefinedSystemNote(-1));
    }
}
