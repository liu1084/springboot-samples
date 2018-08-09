package com.jim.data.config;

import lombok.extern.slf4j.Slf4j;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Author: Jim
 * Date: 2018/8/3:下午2:23
 * Description:
 */
@Configuration
@Slf4j
public class DBPoolConfig {
    @Bean(value = "dataSource")
    @Primary
    @Qualifier(value = "dataSource")
    public DataSource dataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setUser("root");
        ds.setPassword("root");
        ds.setUrl("jdbc:h2:file:/data/h2/db;DB_CLOSE_ON_EXIT=TRUE;AUTO_RECONNECT=TRUE");
        return ds;
    }
}
