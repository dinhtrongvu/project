package com.example.spring.jdbctest.com.example.spring.DAO;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentJdbcDAO {
    private final static Logger logger = Logger.getLogger(StudentJdbcDAO.class);
    private DriverManagerDataSource dataSource;
    private JdbcTemplate jdbcTemplate;

//    private void setDataSource(DriverManagerDataSource dataSource) {
//        this.dataSource = dataSource;
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    private void createTableIfNotExist() {
        try {
            DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
            if (rs.next()) {
                logger.info("Table " + rs.getString("TABLE_NAME") + "already exists!");
                return;
            }
            jdbcTemplate.execute("CREATE TABLE STUDENT ("
                    + " ID BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + " name VARCHAR(1000), "
                    + " AGE INTEGER " +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
