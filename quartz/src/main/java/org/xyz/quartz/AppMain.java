package org.xyz.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AppMain
 * @Description TODO
 * @Author xyz
 * @Date 2020/7/10 9:57
 * @Version 1.0
 **/
@SpringBootApplication
public class AppMain implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from xyz");
        System.out.println(maps);
    }
}
