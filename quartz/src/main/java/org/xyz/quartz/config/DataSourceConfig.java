package org.xyz.quartz.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/10 15:10
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariDataSource.setUsername("root");
        hikariDataSource.setJdbcUrl("jdbc:mysql://192.168.6.133:3306/xyz?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        hikariDataSource.setPassword("root");
        return hikariDataSource;
    }
}
