package com.neoteric.config;

import com.neoteric.dao.StudentMarkDAO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/student");
        config.setUsername("root");  // Replace with your DB username
        config.setPassword("your_password");  // Replace with your DB password
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // Optional Hikari settings
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(2);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(30000);
        config.setLeakDetectionThreshold(2000);

        return new HikariDataSource(config);
    }

    @Bean
    public StudentMarkDAO studentMarkDAO() {
        StudentMarkDAO dao = new StudentMarkDAO();
        dao.setDataSource(dataSource());
        return dao;
    }
}
