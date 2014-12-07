package com.weather;

import com.weather.dao.AdminDao;
import com.weather.dom.SystemNote;
import com.weather.service.AdminService;
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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/database.xml", "file:src/main/webapp/WEB-INF/spring-security.xml", "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml"})
@TransactionConfiguration(transactionManager = "jdbcTransactionManager", defaultRollback = true)
@Transactional
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;

    @Before
    public void setup() {
    }

    @Test
    public void testUpdateSystemNote() {
        Assert.assertTrue(adminDao.updateSystemNote("Junit System Test", "junit@junit.com"));
    }

    @Test
    public void testGetOldSystemNotes() {
        List<SystemNote> systemNotes = adminDao.getOldSystemNotes("junit@junit.com");
        Assert.assertNotNull(systemNotes);
    }
}
