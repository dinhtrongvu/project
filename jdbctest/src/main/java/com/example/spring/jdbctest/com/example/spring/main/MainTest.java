package com.example.spring.jdbctest.com.example.spring.main;

import com.example.spring.jdbctest.com.example.spring.DAO.StudentJdbcDAO;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    private final static Logger logger = Logger.getLogger(MainTest.class);
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("StudentJdbcDAO");
        logger.info(" create bean " +jdbc);

    }
}
