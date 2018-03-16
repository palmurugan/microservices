package com.hts.report.service.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hts.report.domain.Resource;

/**
 * 
 * @author PalMurugan
 *
 */
public abstract class ConnectionManager {

    private static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    protected JdbcTemplate getJDBCTemplate(Resource resource) {
        return new JdbcTemplate(getDataSource(resource));
    }

    private DataSource getDataSource(Resource resource) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(ConnectionManager.MYSQL_DRIVER);
        dataSource.setUrl(resource.getDatasource().getConnectionURL());
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
}
